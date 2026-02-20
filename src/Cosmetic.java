public class Cosmetic extends Item {
    protected String manufacturer;
    protected String brand;
    protected String expirationDate;
    protected int weight;
    protected boolean isOrganic;

    public Cosmetic(double price, int stock, String manufacturer, String brand,
                    String expirationDate, int weight, boolean isOrganic) {
        super(price, stock);
        this.manufacturer = manufacturer;
        this.brand = brand;
        this.expirationDate = expirationDate;
        this.weight = weight;
        this.isOrganic = isOrganic;
    }
}