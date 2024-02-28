package repository;

import model.Reader;
import util.MyLinkedList;

public class ReaderRepository {

    private final MyLinkedList<Reader> readers;

    public ReaderRepository(MyLinkedList<Reader> readers) {
        this.readers = readers;

    }
}
