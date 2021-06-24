package ru.rfs.Game2048;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Board<K, V> {
    private final int weight;
    private final int height;
    Map<K, V> board = new HashMap<K, V>();

    public Board(int w, int h) {
        this.weight = w;
        this.height = h;
    }

    public abstract void fillBoard(List<V> list);
    public abstract List<K> availableSpace();
    public abstract void addItem(K key, V value);
    public abstract K getKey(int row, int column);
    public abstract V getValue(K key);
    public abstract List<K> getColumn(int column);
    public abstract List<K> getRow(int row);
    public abstract boolean hasValue(V value);
    public abstract List<V> getValues(List<K> keys);
}
