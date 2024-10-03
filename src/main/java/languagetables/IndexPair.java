package languagetables;

import java.util.Objects;

public class IndexPair {

    private final int row;
    private final int column;

    public IndexPair(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IndexPair)) return false;
        IndexPair indexPair = (IndexPair) o;
        return row == indexPair.row && column == indexPair.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
