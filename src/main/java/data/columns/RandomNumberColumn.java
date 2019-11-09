package data.columns;

import java.util.Random;


public abstract class RandomNumberColumn implements TestDataColumn {

    private final int value;

    public RandomNumberColumn(int from, int to) {
        Random random = new Random();
        value = random.nextInt(to - from + 1) + from;
    }

    @Override
    public String getValue() {
        return String.valueOf(value);
    }
}
