package snippet.MultipleThreading.JavaConcurrencyEssentials;


import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Concurrent {
}


class ThreadPoolExecutorExample implements Runnable {
    private static AtomicInteger counter = new AtomicInteger();
    private final int taskId;

    public int getTaskId() {
        return taskId;
    }

    public ThreadPoolExecutorExample(int taskId) {
        this.taskId = taskId;
    }

    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(10);
        ThreadFactory threadFactory = new ThreadFactory() {
            public Thread newThread(Runnable r) {
                int currentCount = counter.getAndIncrement();
                System.out.println("Creating new thread: " + currentCount);
                return new Thread(r, "mythread" + currentCount);
            }
        };
        RejectedExecutionHandler rejectedHandler = new RejectedExecutionHandler() {
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                if (r instanceof ThreadPoolExecutorExample) {
                    ThreadPoolExecutorExample example = (ThreadPoolExecutorExample) r;
                    System.out.println("Rejecting task with id " + example.getTaskId());
                }
            }
        };
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 1,
                TimeUnit.SECONDS, queue, threadFactory, rejectedHandler);
        for (int i = 0; i < 100; i++) {
            executor.execute(new ThreadPoolExecutorExample(i));
        }
        executor.shutdown();
    }
}


class ExecutorsExample implements Callable<Integer> {
    private static Random random = new Random(System.currentTimeMillis());

    public Integer call() throws Exception {
        Thread.sleep(1000);
        return random.nextInt(100);
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<Integer>[] futures = new Future[5];
        for (int i = 0; i < futures.length; i++) {
            futures[i] = executorService.submit(new ExecutorsExample());
        }
        for (int i = 0; i < futures.length; i++) {
            Integer retVal = futures[i].get();
            System.out.println(retVal);
        }
        executorService.shutdown();
    }
}
