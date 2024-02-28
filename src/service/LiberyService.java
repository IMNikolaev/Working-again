package service;

import model.Book;
import repository.BookByReaderRepository;
import repository.BookRepository;
import repository.ReaderRepository;
import util.MyLinkedList;

public class LiberyService {

    private BookByReaderRepository bookByReaderRepository;
    private BookRepository bookRepository;
    private ReaderRepository readerRepository;

    public LiberyService(BookByReaderRepository bookByReaderRepository, BookRepository bookRepository, ReaderRepository readerRepository) {
        this.bookByReaderRepository = bookByReaderRepository;
        this.bookRepository = bookRepository;
        this.readerRepository = readerRepository;
    }

    public MyLinkedList<Book> getAllBooks() {
        return bookRepository.findAll();
    }


}
