package yg0r2.scripts.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import yg0r2.scripts.script.impl.PathJson;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

public class PathJsonUtils {

    private static final String DEFAULT_WORKING_DIRECTORY_KEY = "default";
    private static final List<PathJson> PATH_JSON = readPathJson();
    private static final String PATH_JSON_RESOURCE_NAME = "/paths.json";

    private static List<PathJson> readPathJson() {
        Gson gson = new Gson();

        String content;
        try {
            content = FileUtils.readResourceContent(PATH_JSON_RESOURCE_NAME);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        Type type = new TypeToken<List<PathJson>>() {}.getType();

        return gson.fromJson(content, type);
    }

    public static File getDefaultWorkingDirectory() {
        PathJson openJsonObject = PATH_JSON.stream()
            .filter(o -> o.getKey().equals(DEFAULT_WORKING_DIRECTORY_KEY))
            .findFirst()
            .get();

        return new File(openJsonObject.getValue());
    }

    public static File getWorkingDirectory(String fileNameOrKey) {
        Optional<PathJson> optionalOpenJsonObject = PATH_JSON.stream()
            .filter(pathJson -> pathJson.getKey().equals(fileNameOrKey))
            .findFirst();

        if (optionalOpenJsonObject.isPresent()) {
            return new File(optionalOpenJsonObject.get().getValue());
        }

        return new File(getDefaultWorkingDirectory() + "\\" + fileNameOrKey);
    }

}
