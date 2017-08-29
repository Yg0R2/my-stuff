package yg0r2.scripts.args.parser;

public enum ErrorCode {

    INVALID_ARGUMENT("Invalid parameter '$0'."),
    MISSING_ARGUMENT_VALUE("Parameter value is missing."),
    MISSING_SCRIPT_ERROR("Script parameter is missing."),
    MISSING_STRING_ARGUMENT_VALUE("String parameter '$0' value is missing.");

    private String value;

    ErrorCode(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
