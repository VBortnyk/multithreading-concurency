package multithreading;

public class Calculator {
    private final long bottom;
    private final long top;

    public Calculator(long bottom, long top) {
        this.bottom = bottom;
        this.top = top;
    }

    public long calculate() {
        long result = 0;
        for (long i = bottom; i <= top; i++) {
            result += i;
        }
        return result;
    }

    public long getBottom() {
        return bottom;
    }

    public long getTop() {
        return top;
    }
}
