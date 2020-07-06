package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceSolution {
    private final int numOfThreads;
    private final Calculator calculator;

    public ExecutorServiceSolution(int numOfThreads, Calculator calculator) {
        this.numOfThreads = numOfThreads;
        this.calculator = calculator;
    }

    public long execute() throws ExecutionException, InterruptedException {
        List<MyCallable> callableList = new ArrayList<>();
        while (callableList.size() < numOfThreads) {
            callableList.add(new MyCallable());
        }
        CalculatorManager.shareCalculatorBetweenThreads(calculator, callableList);
        ExecutorService executorService = Executors.newFixedThreadPool(numOfThreads);
        List<Future<Long>> future = executorService.invokeAll(callableList);
        long result = 0;
        for (Future<Long> f : future) {
            result += f.get();
        }
        executorService.shutdown();
        return result;
    }
}
