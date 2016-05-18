package by.epam.testLection.encapsulation;

public class Runner {
    public static void main (String[] args) {
        Employee encap = new Employee();
        encap.setName("Vasya");
        encap.setAge(20);
        encap.setIdNum("123few");

        System.out.print("Name " + encap.getName() + " "
                + "Age " + encap.getAge() + " "
                + "Id " + encap.getIdNum());
    }
}
