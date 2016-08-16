package net.company.my.bean;

/**
 *
 * @author Kostya
 */
public class Book extends Entity {

    private String title;
    private Author author;
    private int year;
    private int qtyTotal;
    private int qtyAvailable;

    public Book() {
    }

    public Book(int id, String title, Author author, int year, int qtyTotal, int qtyAvailable) {
        super(id);
        this.title = title;
        this.author = author;
        this.year = year;
        this.qtyTotal = qtyTotal;
        this.qtyAvailable = qtyAvailable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getQtyTotal() {
        return qtyTotal;
    }

    public void setQtyTotal(int qtyTotal) {
        this.qtyTotal = qtyTotal;
    }

    public int getQtyAvailable() {
        return qtyAvailable;
    }

    public void setQtyAvailable(int qtyAvailable) {
        this.qtyAvailable = qtyAvailable;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + getId() + ", title=" + title + ", author="
                + author + ", year=" + year + ", qtyTotal=" + qtyTotal
                + ", qtyAvailable=" + qtyAvailable + '}';
    }
}
