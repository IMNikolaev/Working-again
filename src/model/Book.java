package model;

public class Book {

    private static int nextId = 1;

    private Integer bookId;
    private String bookTitle;
    private String bookAuthor;
    private boolean bookStatus;


    public Book(String bookTitle, String bookAuthor) {
        this.bookId = nextId++;
        this.bookTitle = bookTitle;
        this.bookStatus = false;
        this.bookAuthor = bookAuthor;
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

    public String getBookAuthor() {return bookAuthor;}



    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    @Override
    public String toString() {
        return "ID" + bookId +
                " Название Книги " + bookTitle + " | " +
                " Автор " + bookAuthor + "\n";
    }
}
