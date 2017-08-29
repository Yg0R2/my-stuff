package yg0r2.scripts.args.parser.exception;

import yg0r2.scripts.args.parser.ErrorCode;

public class MissingArgumentException extends ParserException {

    public MissingArgumentException(String... parameters) {
        this(ErrorCode.MISSING_ARGUMENT_VALUE, parameters);
    }

    public MissingArgumentException(ErrorCode errorCode, String... parameters) {
        super(errorCode, parameters);
    }

}
