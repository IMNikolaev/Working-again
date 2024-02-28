package repository;

import model.Book;
import util.MyLinkedList;

public class BookRepository {
    private final MyLinkedList<Book> books;

    public BookRepository(MyLinkedList<Book> books) {
        this.books = books;

    }
}
