public class Laptop extends Computer {
    private int hasHDMI;

    public Laptop(double price, int stock, String manufacturer, String brand, int maxVolt, int maxWatt,
                  String operatingSystem, String cpuType, int ramCapacity, int hddCapacity, int hasHDMI) {
        super(price, stock, manufacturer, brand, maxVolt, maxWatt, operatingSystem, cpuType, ramCapacity, hddCapacity);
        this.hasHDMI = hasHDMI;
    }
}