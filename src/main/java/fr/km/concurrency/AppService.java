package fr.km.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class AppService {

    public static void main(String[] args) {
        //final ExecutorService executorService = Executors.newFixedThreadPool(4); // pool with 4 thread
        final ExecutorService executor = Executors.newSingleThreadExecutor(); // pool with 1 thread

        Callable<String> callableTask = () -> "Task's execution";

        Future<String> future = executor.submit(callableTask);
        try {
            System.out.println(future.get());  // the get () method blocks, as long as the thread is not finish
            // or this
            System.out.println(future.get(200, TimeUnit.MILLISECONDS));
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }

        executor.shutdown();

    }
}
