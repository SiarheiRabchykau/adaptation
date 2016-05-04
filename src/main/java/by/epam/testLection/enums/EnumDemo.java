package main.java.by.epam.testLection.enums;

public class EnumDemo {
    public static void main(String[] args) {


        for(Browser browser : Browser.values()){
            browser.open();
            //System.out.println("support : " + browser.name());
        }
    }
}
