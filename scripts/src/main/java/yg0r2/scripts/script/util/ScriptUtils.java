package yg0r2.scripts.script.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.maven.shared.invoker.DefaultInvoker;
import org.apache.maven.shared.invoker.InvocationRequest;
import org.apache.maven.shared.invoker.InvocationResult;
import org.apache.maven.shared.invoker.Invoker;
import org.apache.maven.shared.invoker.MavenInvocationException;
import yg0r2.scripts.script.exception.ScriptException;
import yg0r2.scripts.util.FileUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;

public class ScriptUtils {

    private static final String DEFAULT_WORKING_DIRECTORY_KEY = "default";
    private static final String PATH_JSON_RESOURCE_NAME = "/paths.json";
    private static final Map<String, String> PATH_MAP = readPathMap();

    public static final Process executeProcess(ProcessBuilder processBuilder) throws ScriptException {
        return executeProcess(processBuilder, 0);
    }

    public static final Process executeProcess(ProcessBuilder processBuilder, long millis) throws ScriptException {
        processBuilder.inheritIO();

        try {
            return processBuilder.start();
        }
        catch (IOException e) {
            throw new ScriptException(e);
        }
        finally {
            try {
                Thread.sleep(millis);
            }
            catch (InterruptedException e) {
            }
        }
    }

    public static final InvocationResult executeMaven(InvocationRequest invocationRequest) throws ScriptException {
        Invoker invoker = new DefaultInvoker();
        invoker.setMavenHome(new File(System.getenv("MVN_HOME")));

        InvocationResult invocationResult;
        try {
            invocationResult = invoker.execute(invocationRequest);
        }
        catch (MavenInvocationException e) {
            throw new ScriptException(e);
        }

        if (invocationResult.getExitCode() != 0) {
            throw new ScriptException(invocationResult.getExecutionException());
        }

        return invocationResult;
    }

    public static Set<String> getScriptNames() {
        return PATH_MAP.keySet();
    }

    public static File getDefaultWorkingDirectory() {
        return new File(PATH_MAP.get(DEFAULT_WORKING_DIRECTORY_KEY));
    }

    public static File getWorkingDirectory(String fileNameOrKey) {
        if (PATH_MAP.containsKey(fileNameOrKey)) {
            return new File(PATH_MAP.get(fileNameOrKey));
        }

        File standaloneDir = new File(fileNameOrKey);
        if (standaloneDir.exists() && standaloneDir.isDirectory()) {
            return standaloneDir;
        }

        return new File(getDefaultWorkingDirectory() + "\\" + fileNameOrKey);
    }


    private static Map<String, String> readPathMap() {
        Gson gson = new Gson();

        String content;
        try {
            content = FileUtils.readResourceContent(PATH_JSON_RESOURCE_NAME);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        Type type = new TypeToken<Map<String, String>>() {}.getType();

        return gson.fromJson(content, type);
    }

}
