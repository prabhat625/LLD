package LibraryManagement;


public class Lending {
    private Book book;
    private Member member;
    private String dateOfIssue;
    private LendingStatus lendingStatus;

    public Lending(Book book, Member member, String dateOfIssue, LendingStatus lendingStatus) {
        this.book = book;
        this.member = member;
        this.dateOfIssue = dateOfIssue;
        this.lendingStatus = lendingStatus;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setDateOfIssue(String dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public String getDateOfIssue() {
        return dateOfIssue;
    }
}
