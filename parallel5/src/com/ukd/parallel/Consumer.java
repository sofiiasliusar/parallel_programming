package com.ukd.parallel;

public class Consumer extends Thread {
    private MessageBox box;

    public Consumer(MessageBox box) {
        this.box = box;
    }

    @Override
    public void run() {
        String msg;
        do {
            msg = box.take();
        } while (!msg.equals("Done"));
        System.out.println("Consumer finished");
    }
}
