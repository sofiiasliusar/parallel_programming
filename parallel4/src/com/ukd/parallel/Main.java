package com.ukd.parallel;

public class Main {

     static class Worker implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("Worker is running...");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Worker interrupted. Exiting...");
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread workerThread = new Thread(new Worker(), "WorkerThread");
        workerThread.start();

        Thread.sleep(5000);

        System.out.println("Main thread: interrupting worker...");
        workerThread.interrupt();

        workerThread.join();
        System.out.println("Worker thread has finished.");
    }


}
