package service;

import model.Book;
import model.BookByReader;
import model.Reader;
import repository.BookByReaderRepository;
import repository.BookRepository;
import repository.ReaderRepository;
import util.MyLinkedList;

public class LiberyService {

    private BookRepository bookRepository;
    private ReaderRepository readerRepository;
    private BookByReaderRepository bookByReaderRepository;

    public LiberyService(BookRepository bookRepository, ReaderRepository readerRepository,BookByReaderRepository booksByReaders) {
        this.bookRepository = bookRepository;
        this.readerRepository = readerRepository;
        this.bookByReaderRepository = booksByReaders;
    }


    public MyLinkedList<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public MyLinkedList<Reader> getAllReaders(){return readerRepository.findAll();}

    public MyLinkedList<Book> readedBooks (){
        System.out.println("Список книг, которые взяты:");
        return bookRepository.findReservedBooks();
    }

    public MyLinkedList<Book> freeBooks(){
        System.out.println("Список книг, которые можно взять:");
        return bookRepository.findfreeBooks();
    }
    public void takeBook (Book book, Reader reader){
        bookByReaderRepository.takeBook(book,reader);
    }
}

