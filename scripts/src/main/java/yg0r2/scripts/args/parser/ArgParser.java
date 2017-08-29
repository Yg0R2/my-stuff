package yg0r2.scripts.args.parser;

import yg0r2.scripts.args.Args;
import yg0r2.scripts.args.parser.exception.IllegalArgumentException;
import yg0r2.scripts.args.parser.exception.MissingArgumentException;
import yg0r2.scripts.args.parser.exception.MissingScriptException;
import yg0r2.scripts.args.parser.exception.ParserException;
import yg0r2.scripts.script.ScriptType;

public final class ArgParser {

    private String[] arguments;

    public ArgParser(String[] arguments) {
        this.arguments = arguments;
    }

    public Args parse() throws ParserException {
        if (arguments.length == 0) {
            throw new MissingScriptException();
        }

        Args args = new Args();
        args.setScriptType(ScriptType.get(arguments[0]));

        for (int i = 1; i < arguments.length; i++) {
            String arg = arguments[i];

            if (arg.startsWith("-D")) {
                args.addEnvironmentVariable(arg);
            }
            else if (arg.startsWith("--")) {
                String key = arg.substring(2);

                args.addStringValue(key, parseStringArg(i));

                i++;
            }
            else if (arg.startsWith("-")) {
                String key = arg.substring(1);

                args.addBooleanValue(key);
            }
            else {
                String key = parseExceptionalArg(args.getScriptType(), arg);

                args.addStringValue(key, arg);
            }
        }

        return args;
    }

    private boolean isArgumentSurroundedWithQuotes(String arg) {
        if (!arg.startsWith("\"")) {
            return false;
        }

        if (!arg.endsWith("\"")) {
            return false;
        }

        int quotesCount = (int) arg.codePoints().filter(ch -> ch == '\"').count();

        return quotesCount % 2 == 0;
    }

    private String normalizeStringParameter(String arg) {
        if (isArgumentSurroundedWithQuotes(arg)) {
            arg = arg.substring(1, arg.length() - 1);
        }

        return arg;
    }

    private String parseExceptionalArg(ScriptType scriptType, String arg) throws  ParserException {
        if (ScriptType.OP == scriptType) {
            return ScriptType.OP.getExceptionalArg();
        }

        throw new IllegalArgumentException(arg);
    }

    private String parseStringArg(int index) throws ParserException {
        if (index + 1 >= arguments.length) {
            throw new MissingArgumentException(ErrorCode.MISSING_STRING_ARGUMENT_VALUE, arguments[index]);
        }

        String nextArg = arguments[index + 1];

        if (nextArg.startsWith("-")) {
            throw new IllegalArgumentException(ErrorCode.MISSING_STRING_ARGUMENT_VALUE, arguments[index]);
        }

        return normalizeStringParameter(nextArg);
    }

}
