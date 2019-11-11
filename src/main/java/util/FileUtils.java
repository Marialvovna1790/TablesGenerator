package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileUtils {

    public static List<String> readFile(String filename) {
        ArrayList<String> strings = new ArrayList<>();
        try {
            try (InputStreamReader reader = new InputStreamReader(getFileStreamFromResources(filename));
                 BufferedReader br = new BufferedReader(reader)) {

                String line;
                while ((line = br.readLine()) != null) {
                    strings.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return strings;
    }

    private static InputStream getFileStreamFromResources(String fileName) {
        ClassLoader classLoader = FileUtils.class.getClassLoader();
        return classLoader.getResourceAsStream(fileName);
    }
}
