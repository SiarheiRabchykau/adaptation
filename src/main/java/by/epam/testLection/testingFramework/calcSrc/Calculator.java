package by.epam.testLection.testingFramework.calcSrc;

public class Calculator {

    public long sum(long a, long b) {
        return a + b;
    }

    public long sub(long a, long b) {
        return a - b;
    }

    public  long mult(long a, long b) {
        return a * b;
    }

    public long div(long a, long b) {
        if(b == 0) {
            throw new NumberFormatException("Divide by zero!");
        }
        return a / b;
    }
    //
    public double sum(double a, double b) {
        return a + b;
    }

    public double sub(double a, double b) {
        return a - b;
    }

    public  double mult(double a, double b) {
        return a * b;
    }

    public double div(double a, double b) {
        if(b == 0) {
            throw new NumberFormatException("Divide by zero!");
        }
        return a / b;
    }

    //

    public long pow (long a, long b) {
        return a ^ b;
    }

    public double cos(long a) {
        return Math.cos(a);
    }

    public  double sin(double a) {
        return Math.sin(a);
    }

    public boolean isPositive(long val) {
        if (val == 0) {
            return false;
        }
        return val > 0 ? true : false;
    }

    public boolean isNegative(long val) {
        if (val == 0) {
            return false;
        }

        return val < 0 ? true : false;
    }




}
