package by.epam.testLection.enums;

public enum Browser {
    CHROME("chrome") {
        public void open() {
            System.out.println("Chrome SPECIFIC opening : " + alias);
        }
    },
    IE("ie");

    protected String alias;

    Browser() {

    }

    Browser(String alias) {
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }

    public void open() {
        System.out.println("opening : " + alias);
    }
}
