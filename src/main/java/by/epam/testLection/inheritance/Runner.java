package main.java.by.epam.testLection.inheritance;

/**
 * Created by User on 23.04.2016.
 */
public class  Runner {
    public static void main(String[] args) {

        Person mother = new Person("Irina", "Ivanova");
        Person father = new Person("Ivan","Ivanov");

        Person child = new Child("Vasya", "Ivanov", mother, father);
        System.out.println(child.getInfo());

    }
}
