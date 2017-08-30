package yg0r2.scripts.script;

import yg0r2.scripts.script.exception.ScriptException;
import yg0r2.scripts.script.impl.ApacheScript;
import yg0r2.scripts.script.impl.BookingAppScript;
import yg0r2.scripts.script.impl.CommonAssetsPackScript;
import yg0r2.scripts.script.impl.ComponentSvcScript;
import yg0r2.scripts.script.impl.OpenScript;
import yg0r2.scripts.script.model.Script;

public class ScriptFactory {

    public static Script getScript(ScriptType scriptType) throws ScriptException {
        if (scriptType.APACHE == scriptType) {
            return new ApacheScript();
        }
        else if (ScriptType.BA == scriptType) {
            return new BookingAppScript();
        }
        else if (ScriptType.CAP == scriptType) {
            return new CommonAssetsPackScript();
        }
        else if (ScriptType.CVC == scriptType) {
            return new ComponentSvcScript();
        }
        else if (ScriptType.OP == scriptType) {
            return new OpenScript();
        }

        throw new ScriptException("The requested script '" + scriptType + "' is missing.");
    }

}
