package repository;

import model.Book;
import model.Reader;
import util.MyLinkedList;

public class ReaderRepository {

    private final MyLinkedList<Reader> readers;

    public ReaderRepository(MyLinkedList<Reader> readers) {
        this.readers = readers;

    }
    public void add(Reader newReader) {readers.add(newReader);}

}
