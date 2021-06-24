package ru.rfs.Game2048;

public class TestClass {
    public static void main(String[] args){
        Board<Key, Integer> board = new SquareBoard<Integer>(4);
        Game game2048 = new Game2048();
        System.out.println(game2048.canMove());
    }
}

