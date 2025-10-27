package com.ukd.parallel;

public class Main {
    public static void main(String[] args) {

//        Bank bank = new Bank(500, 500);
//        Bank bank = new BankReentrantLock(500, 500);
//        Bank bank = new BankSynchronizedMethod(500, 500);
        Bank bank = new BankSynchronizedBlock(500, 500);
        System.out.println("Starting total balance: " + bank.totalBalance());

        Thread thread1 = new TransferThread(bank);
        Thread thread2 = new TransferThread(bank);
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final total balance: " + bank.totalBalance());
    }
}
