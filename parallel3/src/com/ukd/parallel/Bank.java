package com.ukd.parallel;

public interface Bank {
    void transfer() throws InterruptedException;
    int totalBalance();
}