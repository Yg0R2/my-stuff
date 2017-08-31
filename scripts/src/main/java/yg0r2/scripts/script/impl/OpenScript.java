package yg0r2.scripts.script.impl;

import yg0r2.scripts.args.Args;
import yg0r2.scripts.script.ScriptKeys;
import yg0r2.scripts.script.ScriptType;
import yg0r2.scripts.script.exception.ScriptException;
import yg0r2.scripts.script.model.Script;
import yg0r2.scripts.script.util.ScriptUtils;

public class OpenScript implements Script {

    @Override
    public void execute(Args args) throws ScriptException {
        String fileNameOrKey = args.getStringValue(ScriptType.OP.getExceptionalArg());

        ProcessBuilder processBuilder = new ProcessBuilder(ScriptKeys.BASH_EXE_LOCATION);
        processBuilder.directory(ScriptUtils.getWorkingDirectory(fileNameOrKey));

        ScriptUtils.executeProcess(processBuilder);
    }

    @Override
    public void printUsage() {
        System.out.println("op usage");
    }

}
