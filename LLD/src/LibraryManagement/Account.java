package LibraryManagement;

import Exceptions.GeneralException;

import java.util.List;

public abstract class Account {
    private String id;
}

class Member extends Account {
    private Person person;
    private List<Lending> booksLending;

    public boolean checkout(BookItem book) {
        if (isAnyExistingFine()) {
            return false;
        }
        BookCheckInCheckOut system = Library.getBookCheckInCheckOut();
        if (system.isBookAvailableForLend(book)) {
            Lending lending = new Lending(book,this,"dateOfIssue", LendingStatus.ON_LEND);
            system.addLendingBook(lending);
            booksLending.add(lending);
            return true;
        }
        return false;
    }

    public boolean returnBook(Book book) {
        if (isAnyExistingFine()) {
            System.out.println("Collect fine: "+ getFine());
        }
        BookCheckInCheckOut system = Library.getBookCheckInCheckOut();
        Lending lendingAgainstBook = geLendingForBook(book);
        return system.removeLendingBook(lendingAgainstBook);
    }

    public Lending geLendingForBook(Book book) {
        for (Lending lending : booksLending) {
            if (lending.getBook() == book) {
                return lending;
            }
        }
        throw new GeneralException("No lending found");
    }

    public boolean isAnyExistingFine() {
        return getFine() > 0;
    }

    public int getFine() {
        int fine = 0;
        for (Lending lending: booksLending) {
            Book book = lending.getBook();
            // Logic to check if this lending exceed Constants.MAX_DAYS_OF_LENDING
            // And then calculate fine accordingly
            fine += 1;
        }
        return fine;
    }
}