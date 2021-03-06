package by.epam.calculatorTest.src;

public class Calculator {

    public Calculator() {
    }

    public long sum(long a, long b) {
        return a + b;
    }

    public double sum(double a, double b) {
        return a + b;
    }

    public long sub(long a, long b) {
        return a - b;
    }

    public double sub(double a, double b) {
        return a - b;
    }

    public long mult(long a, long b) {
        return a * b;
    }

    public double mult(double a, double b) {
        return a * b;
    }

    public long div(long a, long b) {
        if (b == 0L) {
            throw new NumberFormatException("Attempt to divide by zero");
        } else {
            return a / b;
        }
    }

    public double div(double a, double b) {
        return a / b;
    }

    public double pow(double a, double b) {
        return Math.pow(a, b);
    }

    public double sqrt(double a) {
        return Math.sqrt(a);
    }

    public double tg(double a) {    //tg(a) = Sin(a)/Cos(a)
        return this.sin(a) / this.cos(a);
    }

    public double ctg(double a) {
        return this.cos(a) / this.sin(a);
    }

    public double cos(double a) {
        return Math.cos(a);
    }

    public double sin(double a) {
        return Math.sin(a);
    }

    public boolean isPositive(long val) {
        return val == 0L ? false : val > 0L;

    }

    public boolean isNegative(long val) {
        return val < 0L;
    }
}
