package ru.rfs.Game2048;

public class NotEnoughSpace extends Exception {
    public NotEnoughSpace(String message) {
        super(message);
    }
}
