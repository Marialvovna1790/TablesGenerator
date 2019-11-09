package data.columns;


public class IndexColumn extends RandomNumberColumn {
    public IndexColumn(int from, int to) {
        super(from, to);
    }

    @Override
    public String getHeaderName() {
        return "Индекс";
    }
}
