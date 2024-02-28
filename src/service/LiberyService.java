package service;

import model.Book;
import repository.BookRepository;
import repository.ReaderRepository;
import util.MyLinkedList;

public class LiberyService {

    private BookRepository bookRepository;
    private ReaderRepository readerRepository;


    public MyLinkedList<Book> getAllBooks() {
        return bookRepository.findAll();
    }


}
