public class Book extends OfficeSupplies {
    private String publisher;
    private String author;
    private int pages;

    public Book(double price, int stock, String releaseDate, String coverTitle, String publisher, String author, int pages) {
        super(price, stock, releaseDate, coverTitle);
        this.publisher = publisher;
        this.author = author;
        this.pages = pages;
    }
}