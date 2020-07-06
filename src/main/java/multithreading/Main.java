package multithreading;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int numOfThreads = Runtime.getRuntime().availableProcessors();
        Calculator calculator = new Calculator(1, 1_000_000_000L);

        ExecutorServiceSolution executorServiceSolution =
                new ExecutorServiceSolution(numOfThreads, calculator);
        System.out.println(executorServiceSolution.execute());

        ForkJoinSolution forkJoinSolution
                = new ForkJoinSolution(calculator.getBottom(), calculator.getTop(), numOfThreads);
        System.out.println(forkJoinSolution.compute());
    }
}
