package yg0r2.scripts.script.model;

import yg0r2.scripts.args.Args;
import yg0r2.scripts.script.exception.ScriptException;

import java.io.IOException;

public interface Script {

    public static final String BASH_EXE_LOCATION = "C:\\Program Files\\Git\\git-bash.exe";

    void execute(Args args) throws ScriptException;

}
