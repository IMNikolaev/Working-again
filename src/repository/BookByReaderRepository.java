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

    public MyLinkedList<BookByReader> getBooksByReaders() {
        return booksByReaders;
    }

    //БЕЗ ПРОВЕРОК
    public void takeBook (Book book, Reader reader){
        BookByReader bookByReader = new BookByReader(book, reader);
        // Добавляем запись в список booksByReaders
        booksByReaders.add(bookByReader);
        book.setBookStatus(true);
    }

    public void returnBook (Book book, Reader reader){
        for (int i = 0; i < booksByReaders.size(); i++) {
            BookByReader bookByReader = booksByReaders.get(i);
            if (bookByReader.getBook().equals(book) && bookByReader.getReader().equals(reader)) {
                booksByReaders.remove(bookByReader);
                book.setBookStatus(false);
                break;
            }
        }
    }

    public MyLinkedList<BookByReader> getBooksByOtherReaders(Book book) {
        MyLinkedList<BookByReader> booksTakenByOthers = new MyLinkedList<>();
        for (int i = 0; i < booksByReaders.size(); i++) {
            BookByReader bookByReader = booksByReaders.get(i);
            if (!bookByReader.getBook().equals(book)) {
                booksTakenByOthers.add(bookByReader);
            }
        }
        return booksTakenByOthers;
    }


    @Override
    public String toString() {
        return "BooksByReaders{" +
                "booksByReaders=" + booksByReaders +
                '}';
    }
}
