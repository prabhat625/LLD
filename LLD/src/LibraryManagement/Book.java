package LibraryManagement;

public abstract class Book {
    private String title;
    private Author author;
    private Barcode barcode;

    public Book(String title, Author author, Barcode barcode) {
        setAuthor(author);
        setBarcode(barcode);
        setTitle(title);
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setBarcode(Barcode barcode) {
        this.barcode = barcode;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public Barcode getBarcode() {
        return barcode;
    }
}

class BookItem extends Book {
    public BookItem(String title, Author author, Barcode barcode) {
        super(title, author, barcode);
    }
}

