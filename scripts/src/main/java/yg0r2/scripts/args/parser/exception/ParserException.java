package yg0r2.scripts.args.parser.exception;

import yg0r2.scripts.args.parser.ErrorCode;

public class ParserException extends Exception {

    private static String parseErrorCodeMessage(ErrorCode errorCode, String... parameters) {
        String errorCodeValue = errorCode.toString();

        for (int i = 0; i < parameters.length; i++) {
            errorCodeValue = errorCodeValue.replace("$" + i, parameters[i]);
        }

        return errorCodeValue;
    }

    public ParserException(ErrorCode errorCode, String... parameters) {
        super(parseErrorCodeMessage(errorCode, parameters));
    }

}
