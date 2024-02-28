package repository;

import model.Book;
import model.BookByReader;
import model.Reader;
import util.MyLinkedList;

public class BookByReaderRepository {
    private final MyLinkedList<BookByReader> booksByReaders;

    public BookByReaderRepository(MyLinkedList<BookByReader> booksByReaders) {
        this.booksByReaders = booksByReaders;
    }

    //БЕЗ ПРОВЕРОК
    public void takeBook (Book book, Reader reader){
    }


    //БЕЗ ПРОВЕРОК
    public void returnBook (Book book, Reader reader){
    }

    @Override
    public String toString() {
        return "BooksByReaders{" +
                "booksByReaders=" + booksByReaders +
                '}';
    }
}
