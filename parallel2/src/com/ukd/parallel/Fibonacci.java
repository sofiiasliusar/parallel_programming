package com.ukd.parallel;

public class Fibonacci {
    public static void main(String[] args) throws InterruptedException {

        Thread fibonacciThread = getFibonacciThread();

        Thread monitorThread = new Thread(() -> {
            try {
                while (true) {
                    System.out.println(
                            "Монітор: " + fibonacciThread.getName() + " state = " + fibonacciThread.getState());
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "monitorThread");
        monitorThread.setDaemon(true);

        monitorThread.start();

        fibonacciThread.start();

        fibonacciThread.join();

        System.out.println("Головний потік завершився. Програма припиняється.");
    }

    private static Thread getFibonacciThread() {
        Thread fibonacciThread = new Thread(() -> {
            try {
                Thread innerThread = new Thread(() -> {
                    System.out.println("Запустився внутрішній потік, який спить 1 секунду...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Внутрішній потік завершився.");

                });
                innerThread.start();

                int n1 = 0, n2 = 1;
                for (int i = 1; i <= 10; i++) {
                    Thread.sleep(1000);
                    System.out.println("Фібоначчі " + i + ": " + n1);

                    Thread.yield();

                    int next = n1 + n2;
                    n1 = n2;
                    n2 = next;
                }

                innerThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "fibonacciThread");

        fibonacciThread.setPriority(Thread.NORM_PRIORITY);
        return fibonacciThread;
    }
}
