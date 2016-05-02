package by.epam.motogarage.exceptions;

public class MyException1 extends Exception{
    public MyException1 (String er) {
        super(er);
    }

    public MyException1 (String msg, Throwable csuse) {
        super(msg, csuse);
    }
}
