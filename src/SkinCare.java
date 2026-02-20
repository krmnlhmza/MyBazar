public class SkinCare extends Cosmetic {
    private boolean isBabySensitive;

    public SkinCare(double price, int stock, String manufacturer, String brand, String expirationDate, int weight, boolean isOrganic, boolean isBabySensitive) {
        super(price, stock, manufacturer, brand, expirationDate, weight, isOrganic);
        this.isBabySensitive = isBabySensitive;
    }
}