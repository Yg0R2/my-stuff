package yg0r2.scripts.script.impl;

import yg0r2.scripts.args.Args;
import yg0r2.scripts.script.exception.ScriptException;
import yg0r2.scripts.script.model.Script;

import java.io.File;

public class GitScript implements Script {

    private File[] gitRepoDirs;
    /*
    w:\projects\HCom\HWEB\CommonAssetsPack\
    w:\projects\HCom\HWEB\ComponentSvc\
    w:\projects\HCom\HWEB\DionysusUIPack\
    w:\projects\HCom\HWEB\MvtConfigurationPack\
    w:\projects\HCom\COP\BookingApp\
    */

    @Override
    public void execute(Args args) throws ScriptException {

    }

    @Override
    public void printUsage() {

    }

}
