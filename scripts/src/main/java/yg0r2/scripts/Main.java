package yg0r2.scripts;

import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.DefaultInvoker;
import org.apache.maven.shared.invoker.InvocationRequest;
import org.apache.maven.shared.invoker.Invoker;
import yg0r2.scripts.args.Args;
import yg0r2.scripts.args.parser.ArgParser;
import yg0r2.scripts.script.ScriptFactory;
import yg0r2.scripts.script.model.Script;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        normal(args);
        //test();
    }

    private static void normal(String[] args) throws Exception {
        ArgParser parser = new ArgParser(args);
        Args scriptArgs = parser.parse();

        Script script = ScriptFactory.getScript(scriptArgs.getScriptType());

        script.execute(scriptArgs);
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
