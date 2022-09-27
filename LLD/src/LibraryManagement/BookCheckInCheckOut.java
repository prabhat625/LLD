package LibraryManagement;

import java.util.HashSet;
import java.util.Set;

public class BookCheckInCheckOut {
    private Catalog catalog;
    private Set<Lending> booksOnLends;
    private Set<Lending> booksReturned;
    private static BookCheckInCheckOut bookCheckinCheckout;

    public static BookCheckInCheckOut getBookCheckInCheckOut(Catalog catalog) {
        if (bookCheckinCheckout == null) {
            bookCheckinCheckout = new BookCheckInCheckOut(catalog);
        }
        return bookCheckinCheckout;
    }

    private BookCheckInCheckOut(Catalog catalog){
        setCatalog(catalog);
        booksOnLends = new HashSet<>();
        booksReturned = new HashSet<>();

    }

    public boolean addLendingBook(Lending lending) {
        return booksOnLends.add(lending);
    }

    public boolean isBookAvailableForLend(Book book) {
        for (Lending lending: booksOnLends) {
            if (book == lending.getBook()) {
                return false;
            }
        }
        return true;
    }

    public boolean removeLendingBook(Lending lending) {
        return booksOnLends.remove(lending) && booksReturned.add(lending);
    }

    private void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }
}
