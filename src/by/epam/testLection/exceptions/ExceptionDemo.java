package by.epam.testLection.exceptions;

/**
 * Created by Siarhei_Rabchykau on 4/25/2016.
 */
public class ExceptionDemo {
    public static class MyLoverException extends RuntimeException {

        public MyLoverException(String message) {
            super(message);
        }

        public MyLoverException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public void test1() {
        test2();
    }

    public void test2() throws MyLoverException{
            throw new MyLoverException("Just for fun!");
    }

    public static void main(String[] args){
        new ExceptionDemo().test1();
        System.out.println("Done");
    }
}
