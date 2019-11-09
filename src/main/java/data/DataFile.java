package data;

public enum DataFile {
    MALES("males.txt"),
    FEMALES("females.txt"),
    CITIES("cities.txt"),
    STREETS("streets.txt"),
    DISTRICTS("districts.txt");

    private String fileName;

    DataFile(String s) {
        fileName = s;
    }

    public String getFileName() {
        return fileName;
    }
}
