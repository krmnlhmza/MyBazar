import java.util.Date;

public class Admin extends Employee {
    private String password;

    public Admin(String name, String email, Date dateOfBirth, double salary, String password) {
        super(name, email, dateOfBirth, salary);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }


    @Override
    public void displayPersonalData() {
        System.out.println("Admin info");
        System.out.println("Admin name: " + name);
        System.out.println("Admin e-mail: " + email);
        System.out.println("Admin date of birth: " + dateOfBirth);
    }
}