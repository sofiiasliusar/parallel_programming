package com.ukd.parallel;

public class Producer extends Thread {
        private com.ukd.parallel.MessageBox box;

    public Producer(com.ukd.parallel.MessageBox box) {
            this.box = box;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                box.put("Message #" + i);
            }
            box.put("Done");
            System.out.println("Producer finished");
        }
}