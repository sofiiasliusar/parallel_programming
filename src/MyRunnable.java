public class MyRunnable implements Runnable {

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println("Runnable Thread");
        System.out.println("Name: " + thread.getName());
        System.out.println("Priority: " + thread.getPriority());
        System.out.println("Thread Group Name: " + thread.getThreadGroup().getName());
        System.out.println();
    }
}
