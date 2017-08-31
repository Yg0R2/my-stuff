package yg0r2.scripts.script.impl;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.InvocationRequest;
import yg0r2.scripts.args.Args;
import yg0r2.scripts.script.ScriptKeys;
import yg0r2.scripts.script.exception.ScriptException;
import yg0r2.scripts.script.model.Script;
import yg0r2.scripts.script.util.ScriptUtils;

import java.io.File;
import java.util.Arrays;

public class CommonAssetsPackScript implements Script {

    private File capDir;
    private File capWebDir;

    public CommonAssetsPackScript() {
        capDir = ScriptUtils.getWorkingDirectory("cap");
        capWebDir = new File(capDir, "cap-web");
    }

    @Override
    public void execute(Args args) throws ScriptException {
        //buildCAP();

        startCAP();
    }

    @Override
    public void printUsage() {
        System.out.println("CommonAssetsPack usage");
    }

    private void buildCAP() throws ScriptException {
        InvocationRequest invocationRequest = new DefaultInvocationRequest();

        invocationRequest.setBaseDirectory(capDir);
        invocationRequest.setGoals(Arrays.asList(ScriptKeys.MVN_CLEAN_INSTALL_WITHOUT_TEST_COMMANDS));

        ScriptUtils.executeMaven(invocationRequest);
    }

    private void startCAP() throws ScriptException {
        String[] cmd = ArrayUtils.addAll(ScriptKeys.START_NEW_CMD_COMMANDS, new String[] {"mvn jetty:run && exit"});

        ProcessBuilder processBuilder = new ProcessBuilder(cmd);
        processBuilder.directory(capWebDir);

        Process p = ScriptUtils.executeProcess(processBuilder, 0);
        System.out.println();
    }

}
