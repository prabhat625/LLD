package LibraryManagement;

import Exceptions.GeneralException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;

public class Catalog {
    private Map<Author, Set<Book>> authorListMap;
    private Map<Barcode, Book> barcodeBookMap;
    private static Catalog catalogInstance;

    public static Catalog getCatalog() {
        if (catalogInstance == null) {
            catalogInstance = new Catalog();
        }
        return catalogInstance;
    }
    private Catalog() {
        authorListMap = new HashMap<>();
        barcodeBookMap = new HashMap<>();
    }

    public void addBook(Book book) {
        addBookInBarcodeBookMap(book);
        addBookInAuthorListMap(book);
    }

    public void removeBook(Book book) {
        removeBookFromBarcodeBookMap(book);
        removeBookFromAuthorListMap(book);
    }

    public Set<Book> getBookByAuthor(Author author) {
        if (authorListMap.containsKey(author)) {
            return authorListMap.get(author);
        }
        throw new GeneralException("Book not found");
    }

    public Book getBookByBarcode(Barcode barcode) {
        if (barcodeBookMap.containsKey(barcode)) {
            return barcodeBookMap.get(barcode);
        }
        throw new GeneralException("Book not found");
    }

    private void addBookInAuthorListMap(Book book) {
        if (!authorListMap.containsKey(book.getAuthor())) {
            authorListMap.put(book.getAuthor(), new HashSet<>());
        }
        authorListMap.get(book.getAuthor()).add(book);
    }

    private void addBookInBarcodeBookMap(Book book) {
        if (!barcodeBookMap.containsKey(book.getBarcode())) {
            barcodeBookMap.put(book.getBarcode(), book);
            return;
        }
        throw new GeneralException("Two book with same barcode.");
    }

    private void removeBookFromAuthorListMap(Book book) {
        if (!authorListMap.containsKey(book.getAuthor()) || !authorListMap.get(book.getAuthor()).contains(book)) {
           throw new GeneralException("Book not found");
        }
        authorListMap.get(book.getAuthor()).remove(book);
    }

    private void removeBookFromBarcodeBookMap(Book book) {
        if (!barcodeBookMap.containsKey(book.getBarcode())) {
            throw new GeneralException("Book not found");
        }
        barcodeBookMap.remove(book.getBarcode());
    }
}
