package yg0r2.scripts.args.parser.exception;

import yg0r2.scripts.args.parser.ErrorCode;

public class IllegalArgumentException extends ParserException {

    public IllegalArgumentException(String... parameters) {
        this(ErrorCode.INVALID_ARGUMENT, parameters);
    }

    public IllegalArgumentException(ErrorCode errorCode, String... parameters) {
        super(errorCode, parameters);
    }

}
