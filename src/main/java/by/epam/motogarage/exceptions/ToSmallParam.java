package main.java.by.epam.motogarage.exceptions;

public class ToSmallParam extends Exception{
    public ToSmallParam(String strEr) {
        super(strEr);
        System.out.println("I'M A SUPER EXCEPTION!");
    }
}
