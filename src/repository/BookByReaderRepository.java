package repository;

import util.MyLinkedList;

public class BookByReaderRepository {

    private final MyLinkedList<BookByReaderRepository> booksByReaders;

    public BookByReaderRepository(MyLinkedList<BookByReaderRepository> booksByReaders) {
        this.booksByReaders = booksByReaders;
    }




}
