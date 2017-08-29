package yg0r2.scripts.script.impl;

import yg0r2.scripts.args.Args;
import yg0r2.scripts.script.ScriptType;
import yg0r2.scripts.script.exception.ScriptException;
import yg0r2.scripts.script.model.Script;
import yg0r2.scripts.util.PathJsonUtils;

public class OpenScript extends Script {

    @Override
    public void execute(Args args) throws ScriptException {
        String fileNameOrKey = args.getStringValue(ScriptType.OP.getExceptionalArg());

        ProcessBuilder processBuilder = new ProcessBuilder(BASH_EXE_LOCATION);
        processBuilder.directory(PathJsonUtils.getWorkingDirectory(fileNameOrKey));

        executeProcess(processBuilder);
    }

}
