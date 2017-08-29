package yg0r2.scripts.args.parser.exception;

import yg0r2.scripts.args.parser.ErrorCode;

public class MissingScriptException extends ParserException {

    public MissingScriptException() {
        super(ErrorCode.MISSING_SCRIPT_ERROR);
    }

}
