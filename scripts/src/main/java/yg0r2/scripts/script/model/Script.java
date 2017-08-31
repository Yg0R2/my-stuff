package yg0r2.scripts.script.model;

import yg0r2.scripts.args.Args;
import yg0r2.scripts.script.exception.ScriptException;

public interface Script {

    void execute(Args args) throws ScriptException;

    void printUsage();

}