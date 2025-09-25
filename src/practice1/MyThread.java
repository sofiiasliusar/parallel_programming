public class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Thread Thread");
        System.out.println("Name: " + getName());
        System.out.println("Priority: " + getPriority());
        System.out.println("Thread Group Name: " + getThreadGroup().getName());
        System.out.println();
    }
}