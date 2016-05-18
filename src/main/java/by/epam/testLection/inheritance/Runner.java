package by.epam.testLection.inheritance;

public class  Runner {
    public static void main(String[] args) {

        Person mother = new Person("Irina", "Ivanova");
        Person father = new Person("Ivan","Ivanov");

        Person child = new Child("Vasya", "Ivanov", mother, father);
        System.out.println(child.getInfo());

    }
}
