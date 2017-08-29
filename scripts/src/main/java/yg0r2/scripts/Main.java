package yg0r2.scripts;

import yg0r2.scripts.args.Args;
import yg0r2.scripts.args.parser.ArgParser;
import yg0r2.scripts.script.ScriptFactory;
import yg0r2.scripts.script.model.Script;

public class Main {

    public static void main(String[] args) throws Exception {
        ArgParser parser = new ArgParser(args);
        Args scriptArgs = parser.parse();

        Script script = ScriptFactory.getScript(scriptArgs.getScriptType());

        script.execute(scriptArgs);
    }

}
