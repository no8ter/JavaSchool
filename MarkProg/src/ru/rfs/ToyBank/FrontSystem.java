package ru.rfs.ToyBank;

import java.util.ArrayDeque;
import java.util.Deque;

public class FrontSystem {

    private volatile Deque<Task> deque = new ArrayDeque<>();
    public boolean readyToAccept = true;
    public boolean readyToSend = false;

    public FrontSystem() {}

    public synchronized void addTask(Task newTask){
        readyToAccept = false;
        deque.addLast(newTask);
        readyToAccept = true;
        readyToSend = true;
        notifyAll();
    }

    public synchronized Task popTask(){
        if (deque.size() > 0) {
            try {
                return deque.pollFirst();
            } finally {
                if (deque.size() == 0) {
                    readyToSend = false;
                }
            }
        }
        return null;
    }
}
