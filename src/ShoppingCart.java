import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Item> itemList;
    private double totalCost;

    public ShoppingCart() {
        this.itemList = new ArrayList<>();
        this.totalCost = 0.0;
    }

    public void addItem(Item item) {
        itemList.add(item);
        calculateTotal();
    }

    public void emptyCart() {
        itemList.clear();
        calculateTotal();
    }

    public List<Item> getItemList() {
        return itemList;
    }


    public double calculateTotal() {
        totalCost = 0;
        for (Item item : itemList) {
            totalCost += item.getPrice();
        }
        return totalCost;
    }

    public double getTotalCost() {
        return totalCost;
    }
}