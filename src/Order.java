import java.util.Date;
import java.util.List;

public class Order {
    private static int idCounter = 1; // Otomatik ID için
    private int orderID;
    private Date orderDate;
    private double totalCost;
    private int customerID;
    private List<Item> purchasedItems;

    public Order(int customerID, double totalCost, List<Item> purchasedItems) {
        this.orderID = idCounter++;
        this.orderDate = new Date(); // Şu anki zaman
        this.customerID = customerID;
        this.totalCost = totalCost;
        this.purchasedItems = purchasedItems;
    }

    public void displayOrder() {
        System.out.print("Order date: " + orderDate +
                " Customer ID: " + customerID +
                " Total Cost: " + totalCost +
                " Number of purchased items: ");
        if (purchasedItems != null) {
            System.out.println(purchasedItems.size());
        } else {
            System.out.println("0");
        }
    }
}