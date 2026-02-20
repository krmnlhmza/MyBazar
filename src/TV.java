public class TV extends Electronic {
    private int screenSize;

    public TV(double price, int stock, String manufacturer, String brand, int maxVolt, int maxWatt, int screenSize) {
        super(price, stock, manufacturer, brand, maxVolt, maxWatt);
        this.screenSize = screenSize;
    }
}