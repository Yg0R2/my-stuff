package yg0r2.scripts.script.impl;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.InvocationRequest;
import yg0r2.scripts.args.Args;
import yg0r2.scripts.script.ScriptFactory;
import yg0r2.scripts.script.ScriptType;
import yg0r2.scripts.script.exception.ScriptException;
import yg0r2.scripts.script.model.Script;
import yg0r2.scripts.util.PathJsonUtils;

import java.io.File;
import java.util.Arrays;

public class BookingAppScript extends Script {

    private File baDir;

    public BookingAppScript() {
        baDir = PathJsonUtils.getWorkingDirectory("ba");
    }

    @Override
    public void execute(Args args) throws ScriptException {
        boolean runOnlyBa = args.getBooleanValue("only");
        boolean csRequired = args.getBooleanValue("cs");

        if (!runOnlyBa) {
            Script apacheScript = ScriptFactory.getScript(ScriptType.APACHE);
            apacheScript.execute(args);

            Script capScript = ScriptFactory.getScript(ScriptType.CAP);
            capScript.execute(args);
        }

        buildBA();

        startBA();
    }

    private void buildBA() throws ScriptException {
        InvocationRequest invocationRequest = new DefaultInvocationRequest();
        invocationRequest.setGoals(Arrays.asList("clean", "install", SKIP_MAVEN_TEST_GOAL));

        executeMaven(invocationRequest);
    }

    private void startBA() throws ScriptException {
        String[] cmd = ArrayUtils.addAll(START_NEW_CMD_COMMANDS, new String[] {"run-ba.bat && exit"});

        ProcessBuilder processBuilder = new ProcessBuilder(cmd);
        processBuilder.directory(baDir);

        executeProcess(processBuilder);
    }

}
