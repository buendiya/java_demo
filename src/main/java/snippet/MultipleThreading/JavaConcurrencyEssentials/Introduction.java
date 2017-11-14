package snippet.MultipleThreading.JavaConcurrencyEssentials;

import java.util.Random;

public class Introduction {
}

class MainThread {

    public static void main(String[] args) {
        long id = Thread.currentThread().getId();
        String name = Thread.currentThread().getName();
        int priority = Thread.currentThread().getPriority();
        Thread.State state = Thread.currentThread().getState();
        String threadGroupName = Thread.currentThread().getThreadGroup().getName();
        System.out.println("id="+id+"; name="+name+"; priority="+priority+"; state="+state+"; threadGroupName="+threadGroupName);
    }
}


class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Executing thread "+Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread("myThread");
        myThread.start();
    }
}


class MyRunnable implements Runnable {

    public void run() {
        System.out.println("Executing thread "+Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        Thread myThread = new Thread(new MyRunnable(), "myRunnable");
        myThread.start();
    }
}


class InterruptExample implements Runnable {

    public void run() {
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            System.out.println("["+Thread.currentThread().getName()+"] Interrupted by exception!");
        }

        while(!Thread.interrupted()) {
            // do nothing here
        }
        System.out.println("["+Thread.currentThread().getName()+"] Interrupted for the second time.");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread myThread = new Thread(new InterruptExample(), "myThread");
        myThread.start();

        System.out.println("["+Thread.currentThread().getName()+"] Sleeping in main thread for 5s...");
        Thread.sleep(5000);

        System.out.println("["+Thread.currentThread().getName()+"] Interrupting myThread");
        myThread.interrupt();

        System.out.println("["+Thread.currentThread().getName()+"] Sleeping in main thread for 5s...");
        Thread.sleep(5000);

        System.out.println("["+Thread.currentThread().getName()+"] Interrupting myThread");
        myThread.interrupt();
    }
}


class JoinExample implements Runnable {
    private Random rand = new Random(System.currentTimeMillis());

    public void run() {
        //simulate some CPU expensive task
        for(int i=0; i<500000000L; i++) {
            rand.nextInt();
        }
        System.out.println("["+Thread.currentThread().getName()+"] finished.");
    }

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        Thread[] threads = new Thread[5];
        for(int i=0; i<threads.length; i++) {
            threads[i] = new Thread(new JoinExample(), "joinThread-"+i);
            threads[i].start();
        }
        for(int i=0; i<threads.length; i++) {
            threads[i].join();
        }
        System.out.println("["+Thread.currentThread().getName()+"] All threads have finished.");

        long endTime = System.currentTimeMillis();
        System.out.println(String.format("it takes: %s ms.", (endTime - startTime)));
    }
}


// CPU占用比上面低很多
class JoinExampleWithSleep implements Runnable {
    private Random rand = new Random(System.currentTimeMillis());

    public void run() {
        //simulate some CPU expensive task
        for(int i=0; i<300000000L; i++) {
            try {
                Thread.sleep(1);
                rand.nextInt();
            } catch (InterruptedException e) {
                System.out.println("["+Thread.currentThread().getName()+"] Interrupted by exception!");
            }
        }
        System.out.println("["+Thread.currentThread().getName()+"] finished.");
    }

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        Thread[] threads = new Thread[5];
        for(int i=0; i<threads.length; i++) {
            threads[i] = new Thread(new JoinExampleWithSleep(), "joinThread-"+i);
            threads[i].start();
        }
        for(int i=0; i<threads.length; i++) {
            threads[i].join();
        }
        System.out.println("["+Thread.currentThread().getName()+"] All threads have finished.");

        long endTime = System.currentTimeMillis();
        System.out.println(String.format("it takes: %s ms.", (endTime - startTime)));
    }
}
