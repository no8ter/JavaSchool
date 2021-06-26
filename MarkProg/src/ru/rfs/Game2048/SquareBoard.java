package ru.rfs.Game2048;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SquareBoard<V> extends Board<Key, V> {

    private final int size;

    SquareBoard(int size) {
        super(size, size);
        this.size = size;
    }

    /**
     * Заполнить доску входными данными из списка
     *
     * @param list Список из Integer
     */
    @Override
    public void fillBoard(List<V> list) {
        if (list.size() > size*size) {
            throw new RuntimeException("Ошибка инициализации");
        }

        for (int row = 0; row<size; row++) {
            for (int column = 0; column<size; column++) {
                Key key = new Key(row, column);
                addItem(key, list.get((row*size)+column));
            }
        }
    }

    /**
     * Найти пустые ячейки на доске (==null)
     *
     * @return Список ключей с пустыми значениями
     */
    @Override
    public List<Key> availableSpace() {
        List<Key> ret = new ArrayList<>();
        for (Key k: board.keySet()) {
            if (board.get(k) == null) ret.add(k);
        }
        return ret;

    }

    /**
     * Добавить значение по ключу
     *
     * @param key   Key
     * @param value Integer
     */
    @Override
    public void addItem(Key key, V value) {
        board.put(key, value);
    }

    /**
     * Получить ссылку на ключ доски
     *
     * @param row    int
     * @param column int
     * @return Ссылка на ключ или null при отсутсвующих координатах
     */
    @Override
    public Key getKey(int row, int column) {
        for (Key k : board.keySet()) {
            if (k.equals(new Key(row, column))) return k;
        }
        return null;
    }

    /**
     * Получить значение поля по ключу
     *
     * @param key Key
     * @return Число или null если поле пустое
     */
    @Override
    public V getValue(Key key) {
        return board.get(key);
    }

    /**
     * Возвращает список ключей, находящихся в переданном столбце
     *
     * @param column int
     * @return List
     */
    @Override
    public List<Key> getColumn(int column) {
        List<Key> ret = new ArrayList<>();
        for (Key k : board.keySet()) {
            if (k.getColumn() == column) {
                ret.add(k);
            }
        }
        Collections.sort(ret);
        return ret;
    }

    /**
     * Возвращает список ключей, находящихся в переданной строке
     *
     * @param row inr
     * @return List
     */
    @Override
    public List<Key> getRow(int row) {
        List<Key> ret = new ArrayList<>();
        for (Key k :
                board.keySet()) {
            if (k.getRow() == row) {
                ret.add(k);
            }
        }
        Collections.sort(ret);
        return ret;
    }

    /**
     * Проверка наличия переданного числа на доске
     *
     * @param value Integer
     * @return true/false наличия числа
     */
    @Override
    public boolean hasValue(V value) {
        return board.containsValue(value);
    }

    /**
     * Возвращает список значений по переданным ключам
     *
     * @param keys List
     * @return list
     */
    @Override
    public List<V> getValues(List<Key> keys) {
        List<V> ret = new ArrayList<>();
        for (Key k : keys) {
            ret.add(getValue(k));
        }
        return ret;
    }
}
