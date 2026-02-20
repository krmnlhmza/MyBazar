import java.util.Date;

public class Employee extends Person {
    protected double salary;

    public Employee(String name, String email, Date dateOfBirth, double salary) {
        super(name, email, dateOfBirth);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void listItems() {

    }

    public void showVIP() {

    }
}