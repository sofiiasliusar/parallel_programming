package com.ukd.parallel;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MessageBox box = new MessageBox();
        Thread p = new Producer(box);
        Thread c = new Consumer(box);

        p.start();
        c.start();

        p.join();
        c.join();

        System.out.println("Program completed.");
    }
}
