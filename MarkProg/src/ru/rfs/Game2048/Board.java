package ru.rfs.Game2048;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Board {
    private int weight;
    private int height;
    Map<Key, Integer> board = new HashMap<>();

    public void Board(int w, int h) {
        this.weight = w;
        this.height = h;
    }

    public abstract void fillBoard(List<Integer> list);
    public abstract List<Key> availableSpace();
    public abstract void addItem(Key key, Integer value);
    public abstract Key getKey(int i, int j);
    public abstract Integer getValue(Key key);
    public abstract List<Key> getColumn(int j);
    public abstract List<Key> getRow(int i);
    public abstract boolean hasValue(Integer value);
    public abstract List<Integer> getValues(List<Key> keys);
}
