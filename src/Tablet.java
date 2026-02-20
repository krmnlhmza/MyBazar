public class Tablet extends Computer {
    private String dimension;

    public Tablet(double price, int stock, String manufacturer, String brand, int maxVolt, int maxWatt,
                  String operatingSystem, String cpuType, int ramCapacity, int hddCapacity, String dimension) {
        super(price, stock, manufacturer, brand, maxVolt, maxWatt, operatingSystem, cpuType, ramCapacity, hddCapacity);
        this.dimension = dimension;
    }
}