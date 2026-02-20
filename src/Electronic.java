public class Electronic extends Item {
    protected String manufacturer;
    protected String brand;
    protected int maxVolt;
    protected int maxWatt;

    public Electronic(double price, int stock, String manufacturer, String brand,
                      int maxVolt, int maxWatt) {
        super(price, stock);
        this.manufacturer = manufacturer;
        this.brand = brand;
        this.maxVolt = maxVolt;
        this.maxWatt = maxWatt;
    }
}