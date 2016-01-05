import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
//        ExecutorService executor = Executors.newFixedThreadPool(5);

//        Executor executor = new ThreadPerTaskExecutor();
//
//        for (int i = 0; i < 5; i++){
//            executor.execute(new WorkerThread("thread: " + i));
//        }

//        executor.shutdown();

//        while (!executor.isTerminated()) {
//        }
//        System.out.println("Finished all threads");

        RejectedExecutionHandler rejectionHandler = new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println(r.toString() + " is rejected");
            }
        };

        ThreadFactory threadFactory = Executors.defaultThreadFactory();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2), threadFactory, rejectionHandler);

        threadPoolExecutor.execute(new WorkerThread("newwThread"));

        Future<?> future = threadPoolExecutor.submit(new WorkerThread("submitNewwThread"));

        System.out.println("completed: " + threadPoolExecutor.getCompletedTaskCount());
    }
}
