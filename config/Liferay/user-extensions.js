var gotoLabels = {};
var skipCommandLabels = {};
var skipTestLabels = [];
var whileLabels = {}; 

// overload the original Selenium reset function
Selenium.prototype.reset = function() {
    // reset the labels
    this.initialiseLabels();
    // proceed with original reset code
    this.defaultTimeout = Selenium.DEFAULT_TIMEOUT; 
    this.browserbot.selectWindow("null"); 
    this.browserbot.resetPopups();
}

Selenium.prototype.initialiseLabels = function()
{
    gotoLabels = {};
    skipCommandLabels = { skips: {} };
    skipTestLabels = [];
    whileLabels = { ends: {}, whiles: {} };
    var command_rows = [];
    var numCommands = testCase.commands.length;
    for (var i = 0; i < numCommands; ++i) {
        var x = testCase.commands[i];
        command_rows.push(x);
    } 
    var cycles = [];
    var skipps = [];
    for( var i = 0; i < command_rows.length; i++ ) {
        if (command_rows[i].type == 'command')
        switch( command_rows[i].command.toLowerCase() ) {
            case "label":
                gotoLabels[ command_rows[i].target ] = i;
                break;
            case "skipcommand":
            case "endskipcommand":
                skipps.push( [command_rows[i].command.toLowerCase(), i] );
                break; 
            case "skiptest":
                skipTestLabels.push( [command_rows[i].target, i] );
                break;
            case "while":
            case "endwhile":
                cycles.push( [command_rows[i].command.toLowerCase(), i] );
                break; 
        }
    }   
    var i = 0; 
    while( cycles.length ) {
        if( i >= cycles.length ) {
            throw new Error( "non-matching while/endWhile found" );
        }
        switch( cycles[i][0] ) {
            case "while":
                if( ( i+1 < cycles.length ) && ( "endwhile" == cycles[i+1][0] ) ) {
                    // pair found
                    whileLabels.ends[ cycles[i+1][1] ] = cycles[i][1];
                    whileLabels.whiles[ cycles[i][1] ] = cycles[i+1][1];
                    cycles.splice( i, 2 );
                    i = 0;
                } else ++i;
                break;
            case "endwhile":
                ++i;
                break;
        }
    } 
    i = 0; 
    while( skipps.length ) {
        if( i >= skipps.length ) {
            throw new Error( "non-matching skipCommand/endSkipCommand found" );
        }
        switch( skipps[i][0] ) {
            case "skipcommand":
                if( ( i+1 < skipps.length ) && ( "endskipcommand" == skipps[i+1][0] ) ) {
                    // pair found
                    skipCommandLabels.skips[ skipps[i][1] ] = skipps[i+1][1];
                    skipps.splice( i, 2 );
                    i = 0;
                } else ++i;
                break;
            case "endskipcommand":
                ++i;
                break;
        }
    } 
} 

Selenium.prototype.continueFromRow = function( row_num ) 
{
    if(row_num == undefined || row_num == null || row_num < 0) {
        throw new Error( "Invalid row_num specified." );
    }
    testCase.debugContext.debugIndex = row_num;
}

// do nothing. simple label
Selenium.prototype.doLabel = function(){};

Selenium.prototype.doGotolabel = function( label ) 
{
    if( undefined == gotoLabels[label] ) {
        throw new Error( "Specified label '" + label + "' is not found." );
    }
    this.continueFromRow( gotoLabels[ label ] );
};

Selenium.prototype.doGoto = Selenium.prototype.doGotolabel;

Selenium.prototype.doGotoIf = function( condition, label ) 
{
    if( eval(condition) ) this.doGotolabel( label );
}

Selenium.prototype.doSkipCommand = function( value ) 
{
    //If the fixedIssues contains this LPE these commands will skipped
    if ( value.indexOf("!") == -1 ) {
        var last_row = testCase.debugContext.debugIndex;
        var end_skip_command_row = skipCommandLabels.skips[ last_row ];
        if( undefined == end_skip_command_row ) throw new Error( "Corresponding 'endSkipCommand' is not found." );
        this.continueFromRow( end_skip_command_row );
    }
}

Selenium.prototype.doEndSkipCommand = function() 
{
}

Selenium.prototype.doSkipTest = function( value )
{
    //If the fixedIssues contains this LPE these commands will skipped
    if ( (value.indexOf("!") == -1) && (value != "") ) {
        var actualSkip;
        for (var i = 0; i < skipTestLabels.length; i++) {
            if ( skipTestLabels[i][0] == value ) {
                actualSkip = i;
                break;
            }
        }

        var nextSkip;
        if ( actualSkip <  skipTestLabels.length - 1) {
            nextSkip = skipTestLabels[actualSkip + 1][1];
        }
        else {
            nextSkip = testCase.commands.length - 1;
        }

        this.continueFromRow( nextSkip );
    }
}

Selenium.prototype.doWhile = function( condition ) 
{
    if( !eval(condition) ) {
        var last_row = testCase.debugContext.debugIndex;
        var end_while_row = whileLabels.whiles[ last_row ];
        if( undefined == end_while_row ) throw new Error( "Corresponding 'endWhile' is not found." );
        this.continueFromRow( end_while_row );
    }
}

Selenium.prototype.doEndWhile = function() 
{
    var last_row = testCase.debugContext.debugIndex;
    var while_row = whileLabels.ends[ last_row ] - 1;
    if( undefined == while_row ) throw new Error( "Corresponding 'While' is not found." );
    this.continueFromRow( while_row );
}

Selenium.prototype.doLogDebug = function(value, varName) { 
    LOG.debug("DEBUG: " + value);
}

Selenium.prototype.doDisplayError = function(value, testName, error) {
}

Selenium.prototype.doStoreFirstNumber = function(locator, value) {
    storedVars[value] = this.getFirstNumber(locator);
};

Selenium.prototype.doStoreFirstNumberIncrement = function(locator, value) {
    storedVars[value] = this.getFirstNumberIncrement(locator);
};

Selenium.prototype.doStoreNumberDecrement = function(expression, variableName) {
    storedVars[variableName] = this.getNumberDecrement(expression);
};

Selenium.prototype.doStoreNumberIncrement = function(expression, variableName) {
    storedVars[variableName] = this.getNumberIncrement(expression);
};

Selenium.prototype.firstNumber = function(value) {
    return parseInt(value.replace(/.*?(\d+).*$/, '$1'), 10);
};

Selenium.prototype.getFirstNumber = function(locator) {
    var locationValue = this.getText(locator);

    return this.firstNumber(locationValue);
};

Selenium.prototype.getFirstNumberIncrement = function(locator) {
    var locationValue = this.getText(locator);

    return this.firstNumber(locationValue) + 1;
};

Selenium.prototype.getNumberDecrement = function(expression) {
    return parseInt(expression) - 1;
};

Selenium.prototype.getNumberIncrement = function(expression) {
    return parseInt(expression) + 1;
};

Selenium.prototype.isPartialText = function(locator, value) {
    var locationValue = this.getText(locator);
    var index = locationValue.search(value);

    return (index != -1);
};

Selenium.prototype.doStoreIncrementedText = function(locator, value) {
    storedVars[value] = this.getFirstNumberIncrement(locator);
};

Selenium.prototype.getCurrentDay = function() {
    var date = new Date();

    return date.getDate();
};

Selenium.prototype.getCurrentMonth = function() {
    var date = new Date();
    
    var month = new Array(12);

    month[0] = "January";
    month[1] = "February";
    month[2] = "March";
    month[3] = "April";
    month[4] = "May";
    month[5] = "June";
    month[6] = "July";
    month[7] = "August";
    month[8] = "September";
    month[9] = "October";
    month[10] = "November";
    month[11] = "December";

    return month[date.getMonth()];
};

Selenium.prototype.getCurrentYear = function() {
    var date = new Date();

    return date.getFullYear();
};

Selenium.prototype.getCurrentAMPM = function() {
    var date = new Date();
    var hours = date.getHours();

    return hours >= 12 ? 'pm' : 'am';
};

Selenium.prototype.getCurrentAMPMHour = function() {
    var date = new Date();
    var hours = date.getHours();

    hours = hours % 12;
    hours = hours ? hours : 12;

    return hours;
};

Selenium.prototype.getCurrentHour = function() {
    var date = new Date();

    return date.getHours();
};

Selenium.prototype.getCurrentMinute = function() {
    var date = new Date();

    return date.getMinutes();
};

Selenium.prototype.doDownloadFile = function(value) {
	this.doPause("5000");
};

Selenium.prototype.doDownloadTempFile = function(value) {
	this.doPause("5000");
};

Selenium.prototype.doUploadCommonFile = function(locator, value) {
    this.doType(locator, "l:\\liferay-deprecated-test\\test-src\\functional-base\\com\\liferay\\selenium\\dependencies\\" + value);
};
Selenium.prototype.doUploadFile = function(locator, value) {
    this.doType(locator, value);
};

Selenium.prototype.doUploadTempFile = function(locator, value) {
    this.doType(locator, "C:\\Users\\KTibi\\tmp\\selenium-output\\" + value);

};

Selenium.prototype.doInsertCKEditor = function(locator, value) { 
    this.doWaitForCondition("var x = Selenium.browserbot.findElementOrNull('//td[@id=\"cke_contents_form\"]'); x != null;", "50000"); 
    this.doRunScript("CKEDITOR.instances['" + locator + "'].setData('" + value + "');"); 
} 

Selenium.prototype.isTextPresentXML = function(pattern) {
  /**
   * Verifies that the specified text pattern appears somewhere in the entire XML document
   * (as opposed to text only within &lt;body/&gt; tags).
   * Note that when defining text patterns in your test case you should
   * escape HTML characters. For example: <td>&lt;userInRole&gt;</td>
   * (not <td><userInRole></td>).
   * @param pattern a <a href="#patterns">pattern</a> to match with the text of the document
   * @return boolean true if the pattern matches the text, false otherwise
   */

    // the only code that differs from the stock Selenium isTextPresent
    //    is the code to retrieve allText...
    // IE
    var allText = this.browserbot.getDocument().xml;
    if (allText == null) {
        // Firefox
        allText = new XMLSerializer().serializeToString(this.browserbot.getDocument());
    }

    var patternMatcher = new PatternMatcher(pattern);
    if (patternMatcher.strategy == PatternMatcher.strategies.glob) {
            if (pattern.indexOf("glob:")==0) {
                    pattern = pattern.substring("glob:".length); // strip off "glob:"
                }
        patternMatcher.matcher = new PatternMatcher.strategies.globContains(pattern);
    }
    else if (patternMatcher.strategy == PatternMatcher.strategies.exact) {
                pattern = pattern.substring("exact:".length); // strip off "exact:"
        return allText.indexOf(pattern) != -1;
    }
    return patternMatcher.matches(allText);
};

Selenium.prototype.doEval = function(script) {
    try {
        return eval(script);
    } catch (e) {
        throw new SeleniumError("Threw an exception: " + e.message);
    }
}; 

Selenium.prototype.doTypeAceEditor = function(locator, value) {
	value = value.replace(/'/g, "\\'");

    this.doWaitForCondition("var x = Selenium.browserbot.findElementOrNull('" + locator + "'); x != null;", "50000"); 

	this.doType(locator, value);

	this.doSendKeys(locator, "\13");
};

Selenium.prototype.doTypeCKEditor = function(locator, value) {
	value = value.replace(/'/g, "\\'");

    this.doWaitForCondition("var x = Selenium.browserbot.findElementOrNull('" + locator + "'); x != null;", "50000"); 

	var titleAttribute = this.doEval("this.browserbot.findElement(\"" + locator + "\").getAttribute('title');");

	var x = titleAttribute.indexOf(',');
	var y = titleAttribute.indexOf(',', x + 1);
	if (y == -1) {
		y = titleAttribute.length;
	}

	titleAttribute = titleAttribute.substring(x + 1, y);
	titleAttribute = titleAttribute.trim();

	this.doRunScript("CKEDITOR.instances['" + titleAttribute + "'].setData('" + value + "');");
    this.doPause("500");
};

Selenium.prototype.doTypeFrame = function(locator, value) {
	value = value.replace(/'/g, "\\'");

    this.doWaitForCondition("var x = Selenium.browserbot.findElementOrNull('" + locator + "'); x != null;", "50000"); 

	this.doSelectFrame(locator);

    this.doPause("100");

    this.doRunScript("document.body.innerHTML = '" + value + "';");

    this.doPause("100");

	this.doSelectFrame("relative=parent");

    this.doPause("500");
};

Selenium.prototype.doAssertIframeLoaded = function(locator) {
	if (!this.doIsIframeLoaded(locator)) {
		throw new SeleniumError("IFrame not loaded.");
	}
};

Selenium.prototype.doIsIframeLoaded = function(locator) {
	var status = this.doEval("this.browserbot.findElement(\"" + locator + "\").contentDocument.readyState");

	return status=="complete";
};

Selenium.prototype.doWaitForIframeToLoad = function(locator) {
	this.doPause("500");
	if (!this.doIsIframeLoaded(locator)) {
		var row_num = testCase.debugContext.debugIndex;

		this.continueFromRow(row_num - 1);
	}
	else {
		this.doAssertIframeLoaded(locator);
	}
};

Selenium.prototype.doTypeInnerHTML = function(locator, value) {
    var pElement = this.browserbot.getDocument().createElement("P");
    var textNode = this.browserbot.getDocument().createTextNode(value);
   pElement.appendChild(textNode);

	var brElement = this.browserbot.getDocument().createElement("BR");
    pElement.appendChild(brElement);

	var element = this.doEval("this.browserbot.findElement(\"" + locator + "\")");
	element.appendChild(pElement);

    this.doPause("1000");
};

Selenium.prototype.doMakeEnable = function(locator) {
    this.doEval("this.browserbot.findElement(\"" + locator + "\").removeAttribute('disabled');");
    var cssValue = this.doEval("this.browserbot.findElement(\"" + locator + "\").getAttribute('class');");

	cssValue = cssValue.replace("disabled", "");

    this.doEval("this.browserbot.findElement(\"" + locator + "\").setAttribute('class','" + cssValue + "');");
};

Selenium.prototype.doMakeVisible = function(locator) {
    this.doEval("this.browserbot.findElement(\"" + locator + "\").style.cssText = 'display:inline !important';");
    this.doEval("this.browserbot.findElement(\"" + locator + "\").style.overflow = 'visible';");
    this.doEval("this.browserbot.findElement(\"" + locator + "\").style.minHeight = '1px';");
    this.doEval("this.browserbot.findElement(\"" + locator + "\").style.minWidth = '1px';;");
    this.doEval("this.browserbot.findElement(\"" + locator + "\").style.opacity = '1';;");
    this.doEval("this.browserbot.findElement(\"" + locator + "\").style.visibility = 'visible';;");
};