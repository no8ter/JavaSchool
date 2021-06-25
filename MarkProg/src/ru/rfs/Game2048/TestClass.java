package ru.rfs.Game2048;

import java.util.Random;

public class TestClass {
    public static void main(String[] args){
        Board<Key, Integer> board = new SquareBoard<Integer>(4);
        Game game2048 = new Game2048();
        System.out.println(game2048.canMove());

        Key k1 = new Key(1,0);
        Key k2 = new Key(1,1);
        System.out.println(k1.compareTo(k2));

    }
}

