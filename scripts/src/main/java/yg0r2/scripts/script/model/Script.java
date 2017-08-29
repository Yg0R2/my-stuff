package yg0r2.scripts.script.model;

import yg0r2.scripts.args.Args;
import yg0r2.scripts.script.exception.ScriptException;

import java.io.IOException;

public abstract class Script {

    public static final String BASH_EXE_LOCATION = "C:\\Program Files\\Git\\git-bash.exe";

    public abstract void execute(Args args) throws ScriptException;

    protected final Process executeProcess(ProcessBuilder processBuilder) throws ScriptException {
        return executeProcess(processBuilder, 0);
    }

    protected final Process executeProcess(ProcessBuilder processBuilder, long millis) throws ScriptException {
        processBuilder.inheritIO();

        try {
            return processBuilder.start();
        }
        catch (IOException e) {
            throw new ScriptException(e);
        }
        finally {
            try {
                Thread.sleep(millis);
            }
            catch (InterruptedException e) {
            }
        }
    }
}