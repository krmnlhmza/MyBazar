public class HairCare extends Cosmetic {
    private boolean isMedicated;

    public HairCare(double price, int stock, String manufacturer, String brand, String expirationDate, int weight, boolean isOrganic, boolean isMedicated) {
        super(price, stock, manufacturer, brand, expirationDate, weight, isOrganic);
        this.isMedicated = isMedicated;
    }
}