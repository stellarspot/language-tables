package languagetables;

public class PredefinedPageSplitter implements PageSplitter {

    private static final int MAX_ROWS = 7;
    private static final int MAX_COLUMNS = 5;

    @Override
    public int maxSize() {
        return MAX_ROWS * MAX_COLUMNS;
    }

    @Override
    public IndexPair split(int size) {

        int rows = MAX_ROWS;
        int columns = MAX_COLUMNS;

        if (size == 1) {
            rows = 1;
            columns = 1;
        } else if (size == 2) {
            rows = 2;
            columns = 1;
        } else if (size <= 4) {
            rows = 2;
            columns = 2;
        } else if (size < 8) {
            rows = 2;
            columns = 4;
        } else if (size < 16) {
            rows = 4;
            columns = 4;
        }

        return new IndexPair(rows, columns);
    }
}
