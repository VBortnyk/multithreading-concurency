package multithreading;

import java.util.concurrent.RecursiveTask;

public class ForkJoinSolution extends RecursiveTask<Long> {
    private final long bottom;
    private final long top;
    private int numOfThreads;

    public ForkJoinSolution(long bottom, long top, int numOfThreads) {
        this.bottom = bottom;
        this.top = top;
        this.numOfThreads = numOfThreads;
    }

    @Override
    protected Long compute() {
        if (bottom - top <= top / numOfThreads) {
            Calculator calculator = new Calculator(bottom, top);
            return calculator.calculate();
        } else {
            long middle = (top + bottom) / 2;
            ForkJoinSolution firstHalf = new ForkJoinSolution(bottom, middle, numOfThreads);
            firstHalf.fork();
            ForkJoinSolution secondHalf = new ForkJoinSolution(middle + 1, top, numOfThreads);
            long secondValue = secondHalf.compute();
            return firstHalf.join() + secondValue;
        }
    }
}
