public class OfficeSupplies extends Item {
    protected String releaseDate;
    protected String coverTitle;

    public OfficeSupplies(double price, int stock, String releaseDate, String coverTitle) {
        super(price, stock);
        this.releaseDate = releaseDate;
        this.coverTitle = coverTitle;
    }
}