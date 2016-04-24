package by.epam.testLection.inheritance;

public class Child extends Person {
    private Person mother;
    private Person father;

    public Child(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Child(String firstName, String lastName,
                 Person mother, Person father) {
        super(firstName, lastName);
        this.mother = mother;
        this.father = father;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public String getInfo() {
        return super.getInfo()
            + "\n Mother: " + this.mother.getInfo()
            + "\n Father: " + this.father.getInfo();
    }


}
