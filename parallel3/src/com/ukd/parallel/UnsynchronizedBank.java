package com.ukd.parallel;

public class UnsynchronizedBank implements Bank{
    private int account1, account2;
    public UnsynchronizedBank(int acc1, int acc2) {
        account1 = acc1;
        account2 = acc2;
    }
    public void transfer() throws InterruptedException {
        int amount = (int)(Math.random()*500);
        if(account1 > amount) {
            account1 = account1 - amount;
            Thread.sleep(2000);
            account2 = account2 + amount;
        } else {
            account1 = account1 + amount;
            Thread.sleep(2000);
            account2 = account2 - amount;
        }
        System.out.println("Account #1: " + account1 + "\t" +
                "Account #2: " + account2 + "\t" +
                "Total balance: " + totalBalance() + "\t");
    }

    public int totalBalance() {
        return account1 + account2;
    }
}
