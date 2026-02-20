import java.util.Date;

public class Technician extends Employee {
    private boolean isSenior;

    public Technician(String name, String email, Date dateOfBirth, double salary, boolean isSenior) {
        super(name, email, dateOfBirth, salary);
        this.isSenior = isSenior;
    }

    public boolean isSenior() {
        return isSenior;
    }
}