package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class FileUtils {

    public static List<String> readFile(String filename) {
        ArrayList<String> strings = new ArrayList<>();
        try {
            try (FileReader reader = new FileReader(getFileFromResources(filename));
                 BufferedReader br = new BufferedReader(reader)) {

                String line;
                while ((line = br.readLine()) != null) {
                    strings.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }

    private static File getFileFromResources(String fileName) {

        ClassLoader classLoader = FileUtils.class.getClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }
    }
}
