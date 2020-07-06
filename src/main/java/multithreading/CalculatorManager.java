package multithreading;

import java.util.List;

public class CalculatorManager {

    public static void shareCalculatorBetweenThreads(
            Calculator calculator, List<MyCallable> threadList) {
        long bottom = calculator.getBottom();
        long top = calculator.getTop();
        long amount = top / threadList.size();

        for (MyCallable myCallable : threadList) {
            top = bottom + amount - 1;
            Calculator calc = new Calculator(bottom, top);
            myCallable.setCalculator((calc));
            bottom = top + 1;
        }
    }
}
