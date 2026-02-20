public class Campaign {
    private String startDate;
    private String endDate;
    private String itemType;
    private int discountRate;

    public Campaign(String startDate, String endDate, String itemType, int discountRate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.itemType = itemType;
        this.discountRate = discountRate;
    }

    public String getItemType() {
        return itemType;
    }

    public int getDiscountRate() {
        return discountRate;
    }
}