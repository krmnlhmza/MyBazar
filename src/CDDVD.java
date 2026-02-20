public class CDDVD extends OfficeSupplies {
    private String composer;
    private String songs;

    public CDDVD(double price, int stock, String releaseDate, String coverTitle, String composer, String songs) {
        super(price, stock, releaseDate, coverTitle);
        this.composer = composer;
        this.songs = songs;
    }
}