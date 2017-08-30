package yg0r2.scripts.script.impl;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.InvocationRequest;
import yg0r2.scripts.args.Args;
import yg0r2.scripts.script.exception.ScriptException;
import yg0r2.scripts.script.model.Script;
import yg0r2.scripts.util.PathJsonUtils;

import java.io.File;
import java.util.Arrays;

public class CommonAssetsPackScript extends Script {

    private File capDir;
    private File capWebDir;

    public CommonAssetsPackScript() {
        capDir = PathJsonUtils.getWorkingDirectory("cap");
        capWebDir = new File(capDir, "cap-web");
    }

    @Override
    public void execute(Args args) throws ScriptException {
        buildCAP();

        startCAP();
    }

    private void buildCAP() throws ScriptException {
        InvocationRequest invocationRequest = new DefaultInvocationRequest();
        invocationRequest.setGoals(Arrays.asList("clean", "install", SKIP_MAVEN_TEST_GOAL));

        executeMaven(invocationRequest);
    }

    private void startCAP() throws ScriptException {
        String[] cmd = ArrayUtils.addAll(START_NEW_CMD_COMMANDS, new String[] {"mvn jetty:run && exit"});

        ProcessBuilder processBuilder = new ProcessBuilder(cmd);
        processBuilder.directory(capWebDir);

        executeProcess(processBuilder, 20000);
    }

}
