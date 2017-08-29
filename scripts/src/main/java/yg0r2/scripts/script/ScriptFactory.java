package yg0r2.scripts.script;

import yg0r2.scripts.script.exception.ScriptException;
import yg0r2.scripts.script.impl.BookingApp;
import yg0r2.scripts.script.impl.OpenScript;
import yg0r2.scripts.script.model.Script;

public class ScriptFactory {

    public static Script getScript(ScriptType scriptType) throws ScriptException {
        if (ScriptType.OP == scriptType) {
            return new OpenScript();
        }
        else if (ScriptType.BA == scriptType) {
            return new BookingApp();
        }

        throw new ScriptException("The requested script '" + scriptType + "' is missing.");
    }

}
