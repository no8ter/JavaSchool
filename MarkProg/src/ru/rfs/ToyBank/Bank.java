package ru.rfs.ToyBank;

public class Bank {
    private volatile int balance;

    public Bank() {
        this.balance = 0;
    }

    private synchronized void addMoney(int count){
        balance = balance + count;
    }

    private synchronized void popMoney(int count){
        balance = balance - count;
    }

    public synchronized void doTransact(Task task, String managerName){
        boolean ans = false;
        if (task.task == Operations.REPAYMENT) {
            ans = true;
            addMoney(task.moneyCount);
        } else {
            if (balance >= task.moneyCount) {
                ans = true;
                popMoney(task.moneyCount);
            }
        }

        if (ans) {
            System.out.println("Бэк система: Заявка"+task+"УСПЕШНО ВЫПОЛНЕНА. Получена от "+managerName+". Баланс банка: "+balance);
        } else {
            System.out.println("Бэк система: Заявка"+task+"НЕ ВЫПОЛНЕНА. Получена от "+managerName+". Сумма больше баланса. Баланс банка: "+balance);
        }
    }
}
