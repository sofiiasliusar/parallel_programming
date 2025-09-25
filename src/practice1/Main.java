import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {
    public static void printInfo() {
        Thread thread = Thread.currentThread();
        System.out.println("Name: " + thread.getName());
        System.out.println("Priority: " + thread.getPriority());
        System.out.println("Thread Group Name: " + thread.getThreadGroup().getName());
        System.out.println();
    }

    public static void main(String[] args) {
        printInfo();


        Thread thread1 = new MyThread("Thread created with Thread");
        thread1.start();


        Thread thread2 = new Thread(new MyRunnable(), "Thread created with Runnable");
        thread2.start();


        new Thread(Main::printInfo, "Thread with Lambda").start();



        Callable<String> callableTask = () -> {
            Thread.sleep(3000);
            printInfo();
            return Thread.currentThread().getName();
        };


        FutureTask<String> futureTask = new FutureTask<>(callableTask);
        Thread thread4 = new Thread(futureTask, "Thread with Callable");
        thread4.start();


        try {
            String result = futureTask.get();
            System.out.println("Callable returned thread name: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("Кінець main");

    }
}

