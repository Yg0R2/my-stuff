package yg0r2.scripts.script.impl;

import yg0r2.scripts.args.Args;
import yg0r2.scripts.script.exception.ScriptException;
import yg0r2.scripts.script.model.Script;
import yg0r2.scripts.util.PathJsonUtils;

import java.io.File;

public class BookingApp extends Script {

    private File apacheDir;
    private File baDir;
    private File capDir;

    public BookingApp() {
        apacheDir = PathJsonUtils.getWorkingDirectory("apache");
        baDir = PathJsonUtils.getWorkingDirectory("ba");
        capDir = PathJsonUtils.getWorkingDirectory("cap");
    }

    @Override
    public void execute(Args args) throws ScriptException {
        boolean runOnlyBa = args.getBooleanValue("only");

        if (!runOnlyBa) {
            if (!isApacheRunning()) {
                startApache();
            }

            startCAP();
        }

        startBA();
    }

    private boolean isApacheRunning() {
        File pidFile = new File(apacheDir, "logs\\httpd.pid");

        return pidFile.exists();
    }

    private void startApache() throws ScriptException {
        File apacheBinDir = new File(apacheDir, "bin");

        String[] cmd = { "cmd", "/c", "start", "cmd", "/k", "devconf_httpd.bat && exit" };

        ProcessBuilder processBuilder = new ProcessBuilder(cmd);
        processBuilder.directory(apacheBinDir);

        executeProcess(processBuilder);
    }

    private void startBA() throws ScriptException {
        String[] cmd = { "cmd", "/c", "start", "cmd", "/k", "run-ba.bat && exit" };

        ProcessBuilder processBuilder = new ProcessBuilder(cmd);
        processBuilder.directory(baDir);

        executeProcess(processBuilder);
    }

    private void startCAP() throws ScriptException {
        String[] buildCmd = { "mvn clean install -Dmaven.test.skip=true" };

        ProcessBuilder processBuilder = new ProcessBuilder(buildCmd);
        processBuilder.directory(capDir);

        executeProcess(processBuilder);

        File capWebDir = new File(capDir, "cap-web");

        String[] startCmd = { "cmd", "/c", "start", "cmd", "/k", "mvn jetty:run && exit" };

        processBuilder = new ProcessBuilder(startCmd);
        processBuilder.directory(capWebDir);

        executeProcess(processBuilder, 20000);
    }

}
