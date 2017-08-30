package yg0r2.scripts.script.impl;

import org.apache.commons.lang3.ArrayUtils;
import yg0r2.scripts.args.Args;
import yg0r2.scripts.script.exception.ScriptException;
import yg0r2.scripts.script.model.Script;
import yg0r2.scripts.util.PathJsonUtils;

import java.io.File;

public class ApacheScript extends Script {

    private File apacheDir;

    public ApacheScript() {
        this.apacheDir = PathJsonUtils.getWorkingDirectory("apache");
    }

    @Override
    public void execute(Args args) throws ScriptException {
        if (!isApacheRunning()) {
            startApache();
        }
    }

    private boolean isApacheRunning() {
        File pidFile = new File(apacheDir, "logs\\httpd.pid");

        if (pidFile.canWrite()) {
            pidFile.delete();
        }

        return pidFile.exists();
    }

    private void startApache() throws ScriptException {
        File apacheBinDir = new File(apacheDir, "bin");

        String[] cmd = ArrayUtils.addAll(START_NEW_CMD_COMMANDS, new String[] {"devconf_httpd.bat && exit"});

        ProcessBuilder processBuilder = new ProcessBuilder(cmd);
        processBuilder.directory(apacheBinDir);

        executeProcess(processBuilder);
    }

}
