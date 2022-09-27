package LibraryManagement;

public class Library {
    private static Catalog catalog;
    private static BookCheckInCheckOut bookCheckinCheckout;
    private Library() {
    }
    public static Catalog getCatalog() {
        if (catalog == null) {
            catalog = Catalog.getCatalog();
        }
        return catalog;
    }
    public static BookCheckInCheckOut getBookCheckInCheckOut() {
        if (bookCheckinCheckout == null) {
            bookCheckinCheckout = BookCheckInCheckOut.getBookCheckInCheckOut(getCatalog());
        }
        return bookCheckinCheckout;
    }
}
