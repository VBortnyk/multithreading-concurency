package multithreading;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Long> {
    private Calculator calculator;

    public MyCallable() {
    }

    @Override
    public Long call() {
        return calculator.calculate();
    }

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }
}
