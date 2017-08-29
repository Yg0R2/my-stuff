package yg0r2.scripts.args;

import yg0r2.scripts.args.parser.exception.ParserException;
import yg0r2.scripts.script.ScriptType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Args {

    private List<String> booleanParameters;
    private ScriptType scriptType;
    private List<String> envVariables;
    private Map<String, String> stringParameters;

    public Args() throws ParserException {
        booleanParameters = new ArrayList<>();
        envVariables = new ArrayList<>();
        stringParameters = new HashMap<>();
    }

    public void addBooleanValue(String key) {
        booleanParameters.add(key);
    }

    public boolean getBooleanValue(String key) {
        return booleanParameters.contains(key) ? true : false;
    }

    public void setScriptType(ScriptType scriptType) {
        this.scriptType = scriptType;
    }

    public ScriptType getScriptType() {
        return scriptType;
    }

    public void addEnvironmentVariable(String envVar) {
        envVariables.add(envVar);
    }

    public List<String> getEnvironmentVariable() {
        return envVariables;
    }

    public void addStringValue(String key, String value) {
        stringParameters.put(key, value);
    }

    public String getStringValue(String key) {
        return stringParameters.get(key);
    }

}
