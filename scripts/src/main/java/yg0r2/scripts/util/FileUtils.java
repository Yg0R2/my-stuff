package yg0r2.scripts.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class FileUtils {

    public static String readResourceContent(String resource) throws IOException {
        InputStream is = FileUtils.class.getResourceAsStream(resource);

        if (is == null) {
            throw new FileNotFoundException("The requested resource '" + resource + "' is missing.");
        }

        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(is))) {
            return buffer.lines().collect(Collectors.joining("\n"));
        }
    }

}
