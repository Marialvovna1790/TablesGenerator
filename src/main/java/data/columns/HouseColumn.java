package data.columns;


public class HouseColumn extends RandomNumberColumn {
    public HouseColumn(int from, int to) {
        super(from, to);
    }

    @Override
    public String getHeaderName() {
        return "Дом";
    }
}
