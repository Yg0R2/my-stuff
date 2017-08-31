package yg0r2.scripts.script.impl;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.InvocationRequest;
import yg0r2.scripts.args.Args;
import yg0r2.scripts.script.ScriptFactory;
import yg0r2.scripts.script.ScriptKeys;
import yg0r2.scripts.script.ScriptType;
import yg0r2.scripts.script.exception.ScriptException;
import yg0r2.scripts.script.model.Script;
import yg0r2.scripts.script.util.ScriptUtils;

import java.io.File;
import java.util.Arrays;

public class BookingAppScript implements Script {

    private File bookingAppDir;

    public BookingAppScript() {
        bookingAppDir = ScriptUtils.getWorkingDirectory(ScriptType.BA.toString());
    }

    @Override
    public void execute(Args args) throws ScriptException {
        boolean runOnlyBa = args.getBooleanValue(ScriptKeys.OPTION_ONLY);
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

    @Override
    public void printUsage() {
        System.out.println("BookingApp usage");
    }

    private void buildBA() throws ScriptException {
        InvocationRequest invocationRequest = new DefaultInvocationRequest();
        invocationRequest.setGoals(Arrays.asList(ScriptKeys.MVN_CLEAN_INSTALL_WITHOUT_TEST_COMMANDS));

        ScriptUtils.executeMaven(invocationRequest);
    }

    private void startBA() throws ScriptException {
        String[] cmd = ArrayUtils.addAll(ScriptKeys.START_NEW_CMD_COMMANDS, new String[] {"run-ba.bat && exit"});

        ProcessBuilder processBuilder = new ProcessBuilder(cmd);
        processBuilder.directory(bookingAppDir);

        ScriptUtils.executeProcess(processBuilder);
    }

}
