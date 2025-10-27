package com.ukd.parallel;

public class BankSynchronizedBlock implements Bank {
    private int account1, account2;

    public BankSynchronizedBlock(int acc1, int acc2) {
        account1 = acc1;
        account2 = acc2;
    }

    public void transfer() throws InterruptedException {
        int amount = (int)(Math.random() * 500);
        synchronized(this) {
            if (account1 > amount) {
                account1 -= amount;
                Thread.sleep(2000);
                account2 += amount;
            } else {
                account1 += amount;
                Thread.sleep(2000);
                account2 -= amount;
            }
            System.out.println("Account #1: " + account1 + "\tAccount #2: " + account2 +
                    "\tTotal balance: " + totalBalance());
        }
    }

    public int totalBalance() {
        return account1 + account2;
    }
}
