package ru.rfs.ToyBank;

public class TaskManager extends Thread{

    FrontSystem fs;
    Task task;
    Bank bank;

    public TaskManager(FrontSystem fs, Bank bank) {
        this.fs = fs;
        this.bank = bank;
        changeName();
    }

    private void changeName(){
        String[] subStr;
        subStr = getName().split("-");
        setName("Обработчик заявок "+subStr[1]);
    }

    @Override
    public synchronized void run(){
        while (true) {
            while (!fs.readyToSend) {
                try {
                    this.wait(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            task = fs.popTask();
            bank.doTransact(task, getName());
            System.out.println(getName() + ": Получена заявка на обработку по клиенту - " + task.threadName);
        }
    }
}
