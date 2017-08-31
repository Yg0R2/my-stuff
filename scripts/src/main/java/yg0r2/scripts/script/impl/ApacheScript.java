package yg0r2.scripts.script.impl;

import org.apache.commons.lang3.ArrayUtils;
import yg0r2.scripts.args.Args;
import yg0r2.scripts.script.ScriptKeys;
import yg0r2.scripts.script.ScriptType;
import yg0r2.scripts.script.exception.ScriptException;
import yg0r2.scripts.script.model.Script;
import yg0r2.scripts.script.util.ScriptUtils;

import java.io.File;

public class ApacheScript implements Script {

    private File apacheBinDir;
    private File apachePidFile;

    public ApacheScript() {
        File apacheDir = ScriptUtils.getWorkingDirectory(ScriptType.APACHE.toString());

        apacheBinDir = new File(apacheDir, "bin");
        apachePidFile = new File(apacheDir, "logs\\httpd.pid");
    }

    @Override
    public void execute(Args args) throws ScriptException {
        if (!isApacheRunning()) {
            startApache();
        }
    }

    @Override
    public void printUsage() {
        System.out.println("apache usage");
    }

    private boolean isApacheRunning() {
        /*if (apachePidFile.canWrite()) {
            apachePidFile.delete();
        }*/

        return apachePidFile.exists();
    }

    private void startApache() throws ScriptException {
        String[] cmd = ArrayUtils.addAll(ScriptKeys.START_NEW_CMD_COMMANDS, new String[] {"devconf_httpd.bat && exit"});

        ProcessBuilder processBuilder = new ProcessBuilder(cmd);
        processBuilder.directory(apacheBinDir);

        ScriptUtils.executeProcess(processBuilder);
    }

}
