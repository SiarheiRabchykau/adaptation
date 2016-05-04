package main.java.by.epam.testLection.sameTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by User on 26.04.2016.
 */
public class Rexep {

    public static final String TEXT = "Мне очень нравится Тайланд. Таиланд это то место куда бы я поехал. тайланд - мечты сбываются!";

    public static void main(String[] args) {

        System.out.println(TEXT.replaceAll("[Тт]а[ий]ланд", "Украина"));

        System.out.println(test("trololo.com"));     //true
        System.out.println(test("trololo.ua "));     //false
        System.out.println(test("trololo.ua"));      //true
        System.out.println(test("trololo/ua"));      //false
        System.out.println(test("i love java because it is cool.ru"));      //true
        System.out.println(test("BACON.ru"));        //true
        System.out.println(test("BACON.de"));        //false

    }

    public static boolean test(String testString) {
        Pattern p = Pattern.compile(".+\\.(com|ua|ru)");
        Matcher m = p.matcher(testString);
        return m.matches();

    }
}