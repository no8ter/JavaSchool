package ru.rfs.Game2048;

import java.util.Random;

public class Game2048 implements Game{

    Board board;

    GameHelper helper = new GameHelper();
    Random random = new Random();

    public Game2048(Board b) {
        this.board = b;
    }

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
