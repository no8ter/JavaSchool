package ru.rfs.ToyBank;

import java.util.Random;

public class ClientThread extends Thread {

    Task task;
    FrontSystem fs;
    public ClientThread(Task task, FrontSystem fs){
        this.task = task;
        this.fs = fs;
        changeName();
        task.threadName = getName();
    }

    private void changeName(){
        String[] subStr;
        subStr = getName().split("-");
        setName("Клиент "+subStr[1]);
    }

    @Override
    public synchronized void run(){
        while (!fs.readyToAccept){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        fs.addTask(task);
        System.out.println(getName() + ": Заявка " + task + " отправлена в банк");
    }
}
