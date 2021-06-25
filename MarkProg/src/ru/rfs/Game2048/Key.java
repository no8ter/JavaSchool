package ru.rfs.Game2048;

public class Key implements Comparable<Key>{
    private int row;
    private int column;
    public Key(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Key key = (Key) o;

        if (row != key.row) return false;
        return column == key.column;
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + column;
        return result;
    }

    @Override
    public int compareTo(Key key) {
        if (key.getColumn() == this.getColumn() && key.getRow() == this.getRow()) {
            return 0;
        } else if (this.getRow() > key.getRow()) {
            return 1;
        } else if (this.getRow() == key.getRow() && this.getColumn() > key.getColumn()) {
            return 1;
        } else {
            return -1;
        }
    }
}
