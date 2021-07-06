package ru.rfs.ToyBank;

public class Main {
    public static void main(String[] args) {

        System.out.println("---------------------------------Toy Bank---------------------------------");

        Bank bank = new Bank();
        FrontSystem fs = new FrontSystem();

        TaskManager tm1 = new TaskManager(fs, bank);
        TaskManager tm2 = new TaskManager(fs, bank);

        tm1.start();
        tm2.start();

        ClientThread client1 = new ClientThread(new Task("1", 5000, Operations.CREDIT), fs);
        ClientThread client2 = new ClientThread(new Task("1", 10000, Operations.REPAYMENT), fs);
        ClientThread client3 = new ClientThread(new Task("1", 15000, Operations.CREDIT), fs);
        ClientThread client4 = new ClientThread(new Task("1", 20000, Operations.REPAYMENT), fs);
        ClientThread client5 = new ClientThread(new Task("1", 25000, Operations.CREDIT), fs);

        client1.start();
        client2.start();
        client3.start();
        client4.start();
        client5.start();

        if (client1.isAlive() == false && client2.isAlive() == false && client3.isAlive() == false && client4.isAlive() == false && client5.isAlive() == false) {
            System.exit(-5);
        }
    }
}
