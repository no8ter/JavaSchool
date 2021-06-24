package ru.rfs.Game2048;

import java.util.Random;

public class Game2048 implements Game{

    public static final int GAME_SIZE = 4;

    private final Board<Key, Integer> board = new SquareBoard<>(GAME_SIZE);

    GameHelper helper = new GameHelper();
    Random random = new Random();

    @Override
    public void init() {

    }

    @Override
    public boolean canMove() {
        return false;
    }

    @Override
    public boolean move(Direction direction) {
        return false;
    }

    @Override
    public void addItem() {

    }

    @Override
    public Board getGameBoard() {
        return null;
    }

    @Override
    public boolean hasWin() {
        return false;
    }
}
