package com.ukd.parallel;

public class MessageBox {
    private String message;
    private boolean empty = true;

    public synchronized void put(String msg) {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        message = msg;
        empty = false;
        System.out.println("Produced: " + msg);
        notifyAll();
    }

    public synchronized String take() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        String msg = message;
        empty = true;
        System.out.println("Consumed: " + msg);
        notifyAll();
        return msg;
    }
}
