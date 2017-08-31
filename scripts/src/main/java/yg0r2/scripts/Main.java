package yg0r2.scripts;

import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.DefaultInvoker;
import org.apache.maven.shared.invoker.InvocationRequest;
import org.apache.maven.shared.invoker.Invoker;
import yg0r2.scripts.args.Args;
import yg0r2.scripts.args.parser.ArgParser;
import yg0r2.scripts.args.parser.exception.ParserException;
import yg0r2.scripts.script.ScriptFactory;
import yg0r2.scripts.script.ScriptKeys;
import yg0r2.scripts.script.exception.ScriptException;
import yg0r2.scripts.script.model.Script;
import yg0r2.scripts.script.util.ScriptUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        normal(args);
        //test();
    }

    private static void normal(String[] args) {
        Args scriptArgs = null;
        try {
            ArgParser parser = new ArgParser(args);

            scriptArgs = parser.parse();
        }
        catch (ParserException e) {
            Set<String> scriptNames = ScriptUtils.getScriptNames();

            System.out.println(scriptNames.stream().collect(Collectors.joining(", ")));
        }

        Script script = null;
        try {
            script = ScriptFactory.getScript(scriptArgs.getScriptType());
        }
        catch (ScriptException e) {
            System.out.println(e.getMessage());
        }

        if (scriptArgs.getBooleanValue(ScriptKeys.OPTION_HELP)) {
            script.printUsage();
        }
        else {
            try {
                script.execute(scriptArgs);
            }
            catch (ScriptException e) {
                script.printUsage();
            }
        }
    }

    private static void test() throws Exception {
        //String[] cmd = { "cmd", "/c", "start", "cmd.exe", "/k", "mvn --version" };
        //String[] cmd = {"cmd", "/c", "dir"};
        //String[] cmd = {"C:\\Program Files\\Git\\git-bash.exe", "-c", "ls"};
        String[] cmd = { "cmd", "/c", "mvn --version" };

        ProcessBuilder pb = new ProcessBuilder(cmd);
        pb.inheritIO();
        pb.redirectError();
        pb.redirectInput();

        //pb.environment().forEach((k, v) -> System.out.println(k + ", " + v));
        //System.out.println(System.getenv("MAVEN_HOME"));
        //pb.environment().put("maven.home", System.getenv("MAVEN_HOME"));
        //pb.environment().forEach((k, v) -> System.out.println(k + ", " + v));
        //System.out.println();

        pb.directory(new File("w:\\apache2-httpd\\bin"));
        //Process p = pb.start();
        //log(p.getErrorStream());

        InvocationRequest invocationRequest = new DefaultInvocationRequest();
        //invocationRequest.setMavenOpts("--version");
        invocationRequest.setGoals(Arrays.asList("--version"));

        Invoker invoker = new DefaultInvoker();
        invoker.setMavenHome(new File(System.getenv("MAVEN_HOME")));
        invoker.execute(invocationRequest);
    }

    private static void log(InputStream is) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

}
