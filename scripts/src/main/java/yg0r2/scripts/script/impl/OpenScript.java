package yg0r2.scripts.script.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import yg0r2.scripts.args.Args;
import yg0r2.scripts.script.FileUtils;
import yg0r2.scripts.script.ScriptType;
import yg0r2.scripts.script.exception.ScriptException;
import yg0r2.scripts.script.model.Script;

import java.io.File;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

public class OpenScript implements Script {

    private List<OpenJsonObject> openJsonObjects;

    public OpenScript() throws ScriptException {
        Gson gson = new Gson();

        String content = FileUtils.readResourceContent("/op.json");

        Type type = new TypeToken<List<OpenJsonObject>>() {}.getType();

        openJsonObjects = gson.fromJson(content, type);
    }

    @Override
    public void execute(Args args) throws ScriptException {
        String fileNameOrKey = args.getStringValue(ScriptType.OP.getExceptionalArg());

        try {
            ProcessBuilder processBuilder = new ProcessBuilder(BASH_EXE_LOCATION);
            processBuilder.directory(getWorkingDirectory(fileNameOrKey));
            processBuilder.start();
        }
        catch (Exception e) {
            throw new ScriptException(e);
        }
    }

    private File getDefaultWorkingDirectory() {
        OpenJsonObject openJsonObject = openJsonObjects.stream()
            .filter(o -> o.getKey().equals("default"))
            .findFirst()
            .get();

        return new File(openJsonObject.getValue());
    }

    private File getWorkingDirectory(String fileNameOrKey) {
        Optional<OpenJsonObject> optionalOpenJsonObject = openJsonObjects.stream()
                .filter(o -> o.getKey().equals(fileNameOrKey))
                .findFirst();

        if (optionalOpenJsonObject.isPresent()) {
            return new File(optionalOpenJsonObject.get().getValue());
        }

        return new File(getDefaultWorkingDirectory() + "\\" + fileNameOrKey);
    }

}
