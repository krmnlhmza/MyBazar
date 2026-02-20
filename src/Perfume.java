public class Perfume extends Cosmetic {
    private int lastingDuration;

    public Perfume(double price, int stock, String manufacturer, String brand, String expirationDate, int weight, boolean isOrganic, int lastingDuration) {
        super(price, stock, manufacturer, brand, expirationDate, weight, isOrganic);
        this.lastingDuration = lastingDuration;
    }
}