package yg0r2.scripts.script.model;

import org.apache.maven.shared.invoker.DefaultInvoker;
import org.apache.maven.shared.invoker.InvocationRequest;
import org.apache.maven.shared.invoker.InvocationResult;
import org.apache.maven.shared.invoker.Invoker;
import org.apache.maven.shared.invoker.MavenInvocationException;
import yg0r2.scripts.args.Args;
import yg0r2.scripts.script.exception.ScriptException;

import java.io.File;
import java.io.IOException;

public abstract class Script {

    public static final String BASH_EXE_LOCATION = "C:\\Program Files\\Git\\git-bash.exe";
    public static final String[] START_NEW_CMD_COMMANDS = {"cmd", "/c", "start", "cmd", "/k"};
    public static final String SKIP_MAVEN_TEST_GOAL = "-Dmaven.test.skip=true";

    private File mavenHomeDir = new File(System.getenv("MAVEN_HOME"));

    public abstract void execute(Args args) throws ScriptException;

    //public abstract void usage();

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

    protected final InvocationResult executeMaven(InvocationRequest invocationRequest) throws ScriptException {
        Invoker invoker = new DefaultInvoker();
        invoker.setMavenHome(mavenHomeDir);

        InvocationResult invocationResult;
        try {
            invocationResult = invoker.execute(invocationRequest);
        }
        catch (MavenInvocationException e) {
            throw new ScriptException(e);
        }

        if (invocationResult.getExitCode() != 0) {
            throw new ScriptException(invocationResult.getExecutionException());
        }

        return invocationResult;
    }

}