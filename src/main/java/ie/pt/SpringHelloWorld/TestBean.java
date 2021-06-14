package ie.pt.SpringHelloWorld;

public class TestBean {

    protected String message = "Default Message";
    public TestBean() {

    }
    public TestBean(String message) {
        this.message = message;
    }
    public void display() {
        System.out.println(message);
    }
}
