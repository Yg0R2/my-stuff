package yg0r2.scripts.script;

import java.util.Arrays;
import java.util.Optional;

public enum ScriptType {

    OP("op", "path"),
    START("start");

    private String exceptionalArg;
    private String value;

    public static ScriptType get(String value) {
        Optional<ScriptType> optionalScriptType = Arrays.stream(values())
                .filter(scriptType -> scriptType.value.equals(value))
                .findFirst();

        if (!optionalScriptType.isPresent()) {
            throw new IllegalArgumentException("The requested '" + value + "' ScriptType is not valid.");
        }

        return optionalScriptType.get();
    }

    ScriptType(String value) {
        this.value = value;
    }

    ScriptType(String value, String exceptionalArg) {
        this.value = value;
        this.exceptionalArg = exceptionalArg;
    }

    public String getExceptionalArg() {
        return exceptionalArg;
    }

    @Override
    public String toString() {
        return value;
    }

}
