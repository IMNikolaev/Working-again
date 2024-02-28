package model;

public class Book {

    private static int nextId = 1;

    private Integer bookId;
    private String bookTitle;
    private Author bookAuthor;
    private boolean bookStatus;


    public Book(String bookTitle) {
        this.bookId = nextId++;
        this.bookTitle = bookTitle;
        this.bookStatus = false;
        //this.bookAuthor = bookAuthor;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public Author getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(Author bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookAuthor=" + bookAuthor +
                '}';
    }
}
