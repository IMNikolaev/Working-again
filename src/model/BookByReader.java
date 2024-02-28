package model;

public class BookByReader {

    private Integer bookId;
    private Integer readerId;


    public BookByReader(Integer bookId, Integer readerId) {
        this.bookId = bookId;
        this.readerId = readerId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    @Override
    public String toString() {
        return "BookByReader{" +
                "bookId=" + bookId +
                ", readerId=" + readerId +
                '}';
    }
}
