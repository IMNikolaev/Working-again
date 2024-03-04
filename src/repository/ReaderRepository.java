package repository;

import model.Book;
import model.Reader;
import model.Role;
import model.User;
import util.MyLinkedList;

public class ReaderRepository {

    private final MyLinkedList<Reader> readers;

    public ReaderRepository() {
        this.readers = new MyLinkedList<>();
        init();
    }

    private void init() {
        Reader admin = new Reader("Admin", 1);
        readers.add(admin);
    }

    public Reader findById(Integer readerId){
        for (int i = 0; i < readers.size(); i++) {
            Reader currentReader = readers.get(i);
            if (currentReader.getReaderId().equals(readerId)) {
                return currentReader;
            }
        }
        return null;
    }

    public void add(Reader newReader) {
        readers.add(newReader);
    }

    public MyLinkedList<Reader> findAll() {
        return readers;
    }
}
