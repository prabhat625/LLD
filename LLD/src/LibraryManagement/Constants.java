package LibraryManagement;

class Person {
    private String name;
    private String dob;
    private String phone;
    private Address address;

}

class Address {
    private String city;
    private String pin;
}

class Author{
    private String name;
}

enum AccountStatus {
    ACTIVE,
    DEACTIVATED,
    CLOSED
}

enum LendingStatus {
    ON_LEND,
    RETURNED
}
class Barcode {
    private String barcode;
}

public class Constants {
    public static int MAX_DAYS_OF_LENDING = 10;
    public static int MAX_BOOK_ISSUED = 5;
}