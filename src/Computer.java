public class Computer extends Electronic {
    protected String operatingSystem;
    protected String cpuType;
    protected int ramCapacity;
    protected int hddCapacity;

    public Computer(double price, int stock, String manufacturer, String brand, int maxVolt, int maxWatt,
                    String operatingSystem, String cpuType, int ramCapacity, int hddCapacity) {
        super(price, stock, manufacturer, brand, maxVolt, maxWatt);
        this.operatingSystem = operatingSystem;
        this.cpuType = cpuType;
        this.ramCapacity = ramCapacity;
        this.hddCapacity = hddCapacity;
    }
}