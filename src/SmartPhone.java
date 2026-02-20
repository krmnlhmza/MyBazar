public class SmartPhone extends Electronic {
    private String screenType;

    public SmartPhone(double price, int stock, String manufacturer, String brand, int maxVolt, int maxWatt, String screenType) {
        super(price, stock, manufacturer, brand, maxVolt, maxWatt);
        this.screenType = screenType;
    }
}