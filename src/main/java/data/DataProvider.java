package data;

import util.FileUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DataProvider {
    private final Map<DataFile, List<String>> cache = new HashMap<>();

    public List<String> getData(DataFile dataFile) {
        return cache.computeIfAbsent(dataFile, data -> FileUtils.readFile(data.getFileName()));
    }
}
