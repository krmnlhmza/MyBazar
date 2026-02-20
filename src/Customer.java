import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Customer extends Person {
    private int customerID;
    private String password;
    private double balance;
    private Status status;
    private ShoppingCart cart;
    private List<Order> orderHistory;


    public static final double SILVER_LIMIT = 1000;
    public static final double GOLDEN_LIMIT = 5000;



    public Customer(int customerID, String name, String email, Date dateOfBirth, double balance, String password) {
        super(name, email, dateOfBirth);
        this.customerID = customerID;
        this.balance = balance;
        this.password = password;
        this.status = Status.CLASSIC;

        this.cart = new ShoppingCart();
        this.orderHistory = new ArrayList<>();
    }


    public ShoppingCart getCart() { return cart; }
    public List<Order> getOrderHistory() { return orderHistory; }


    public int getCustomerID() {
        return customerID;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public Status getStatus() {
        return status;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean changePassword(String oldPass, String newPass) {
        if (this.password.equals(oldPass)) {
            this.password = newPass;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Customer name: " + name + " ID: " + customerID + " e-mail: " + email +
                " Date of Birth: " + dateOfBirth + " Status: " + status;
    }
}