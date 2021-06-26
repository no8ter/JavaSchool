package ru.rfs.Game2048;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Game2048 implements Game{

    public static final int GAME_SIZE = 4;
    private final Board<Key, Integer> board = new SquareBoard<>(GAME_SIZE);

    GameHelper helper = new GameHelper();
    Random random = new Random();

    @Override
    public void init() {
        int square = GAME_SIZE * GAME_SIZE;
        List<Integer> rawBoard = new ArrayList<>(square);
        for (int row = 0; row < square; row++) {
            rawBoard.add(null);
        }
        this.board.fillBoard(rawBoard);
        try {
            addItem();
            addItem();
        } catch (NotEnoughSpace notEnoughSpace) {
            notEnoughSpace.printStackTrace();
        }
    }

    @Override
    public boolean canMove() {
        return board.availableSpace().size() != 0;
    }

    @Override
    public boolean move(Direction direction) {
        if (canMove()) {
            List<Integer> afterMoveValues = new ArrayList<>();
            
            if (direction == Direction.LEFT) {
                for (int i = 0; i < GAME_SIZE; i++) {
                    List<Key> row = board.getRow(i);
                    afterMoveValues.addAll(helper.moveAndMergeEqual(board.getValues(row)));
                }
            } else if (direction == Direction.RIGHT) {
                for (int i = 0; i < GAME_SIZE; i++) {
                    List<Key> row = board.getRow(i);
                    List<Integer> values = board.getValues(row);
                    Collections.reverse(values);
                    values = helper.moveAndMergeEqual(values);
                    Collections.reverse(values);
                    afterMoveValues.addAll(values);
                }


            } else if (direction == Direction.DOWN) {
                List<List<Integer>> columns = new ArrayList<>();
                for (int i = 0; i < GAME_SIZE; i++) {
                    List<Key> column = board.getColumn(i);
                    List<Integer> values = board.getValues(column);
                    Collections.reverse(values);
                    List<Integer> merged = helper.moveAndMergeEqual(values);
                    columns.add(merged);
                }

                for (int i = GAME_SIZE-1; i >= 0; i--) {
                    for (int q = 0; q < GAME_SIZE; q++) {
                        afterMoveValues.add(columns.get(q).get(i));
                    }
                }


            } else if (direction == Direction.UP) {
                List<List<Integer>> columns = new ArrayList<>();
                for (int i = 0; i < GAME_SIZE; i++) {
                    List<Key> column = board.getColumn(i);
                    List<Integer> values = board.getValues(column);
//                    Collections.reverse(values);
                    List<Integer> merged = helper.moveAndMergeEqual(values);
                    columns.add(merged);
                }

                for (int i = 0; i < GAME_SIZE; i++) {
                    for (int q = 0; q < GAME_SIZE; q++) {
                        afterMoveValues.add(columns.get(q).get(i));
                    }
                }
            }


            if (!afterMoveValues.equals(getAllValues())) {
                board.fillBoard(afterMoveValues);
                try {
                    addItem();
                } catch (NotEnoughSpace notEnoughSpace) {
                    notEnoughSpace.printStackTrace();
                }
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void addItem() throws NotEnoughSpace {
        List<Key> emptyCells = board.availableSpace();
        if (emptyCells.size() == 0) {
            throw new NotEnoughSpace("Некуда добавлять новое число");
        }
        int randId = random.nextInt(emptyCells.size());
        board.addItem(emptyCells.get(randId), randomBlock());
    }

    @Override
    public Board<Key, Integer> getGameBoard() {
        return this.board;
    }

    @Override
    public boolean hasWin() {
        return getAllValues().contains(2048);
    }

    /**
     * Возвращает список значений всех полей на доске
     * @return список полей
     */
    private List<Integer> getAllValues() {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < GAME_SIZE; i++) {
            List<Key> row = board.getRow(i);
            ret.addAll(board.getValues(row));
        }
        return ret;
    }

    /**
     * Генерация случайного числа для блока по правилам игры 2048
     * 90% - 2
     * 10% - 4
     * @return Integer 2 || 4
     */
    private Integer randomBlock() {
        return (int) (Math.random() * 100) <= 10 ? 4 : 2 ;
    }

    /**
     * Возвращает строку для вывода текущего состояния таблицы
     * ТОЛЬКО ДЛЯ ОТЛАДКИ!
     * @return отображение таблицы
     */
    private String printBoard() {
        StringBuilder b = new StringBuilder();

        for (int i = 0; i < GAME_SIZE; i++) {
            List<Key> row = board.getRow(i);
            b.append(board.getValues(row));
            b.append('\n');
        }

        return b.toString();
    }
}
