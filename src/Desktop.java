public class Desktop extends Computer {
    private String boxColor;

    public Desktop(double price, int stock, String manufacturer, String brand, int maxVolt, int maxWatt,
                   String operatingSystem, String cpuType, int ramCapacity, int hddCapacity, String boxColor) {
        super(price, stock, manufacturer, brand, maxVolt, maxWatt, operatingSystem, cpuType, ramCapacity, hddCapacity);
        this.boxColor = boxColor;
    }
}