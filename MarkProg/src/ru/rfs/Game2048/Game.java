package ru.rfs.Game2048;

public interface Game {
    public void init();
    public boolean canMove();
    public boolean move(Direction direction);
    public void addItem() throws NotEnoughSpace;
    public Board getGameBoard();
    public boolean hasWin();
}

