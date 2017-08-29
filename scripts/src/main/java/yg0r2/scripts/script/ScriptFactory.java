package yg0r2.scripts.script;

import yg0r2.scripts.script.exception.ScriptException;
import yg0r2.scripts.script.impl.OpenScript;
import yg0r2.scripts.script.model.Script;

public class ScriptFactory {

    public static Script getScript(ScriptType scriptType) throws ScriptException {
        if (ScriptType.OP == scriptType) {
            return new OpenScript();
        }
        else if ("asd".equals(scriptType)) {

        }

        return null;
    }

}
