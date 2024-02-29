package view;

import model.Book;
import model.BookByReader;
import model.Reader;
import repository.BookRepository;
import repository.BookByReaderRepository;
import repository.ReaderRepository;
import service.LiberyService;
import util.MyLinkedList;

public class Main {

    public static void main(String[] args) {
/*        MyLinkedList<Book> books = new MyLinkedList<>();
        MyLinkedList<Reader> readers = new MyLinkedList<>();
        MyLinkedList<BookByReader> bookByReader = new MyLinkedList<>();

        Book book = new Book("Ksdada");
        Book book1 = new Book( "Ksdыфвфыada");

        books.add(book);
        books.add(book1);

        Reader reader = new Reader("Name");
        Reader reader1 = new Reader("Sergey");

        readers.add(reader);
        readers.add(reader1);

        System.out.println(reader);


        BookRepository bookRepository = new BookRepository(books);
        ReaderRepository readerRepository = new ReaderRepository(readers);

        System.out.println("Список книг:");
        for (int i = 0; i < books.size(); i++) {
            Book currentBook = books.get(i);
            System.out.println(currentBook);
        }

        System.out.println("Список читателей:");
        for (int i = 0; i < readers.size(); i++) {
            Reader currentReader = readers.get(i);
            System.out.println(currentReader);
        }

        System.out.println("test");
        System.out.println(bookRepository.findById(2));
        System.out.println("test");

        System.out.println("test");
        System.out.println(bookRepository.findByTitle("Ksdada"));
        System.out.println("test");

        BookByReaderRepository booksByReaders = new BookByReaderRepository(new MyLinkedList<>());
        booksByReaders.takeBook(book,reader);
        booksByReaders.takeBook(book1,reader1);

*/
        MyLinkedList<Book> books = new MyLinkedList<>();
        MyLinkedList<Reader> readers = new MyLinkedList<>();
        MyLinkedList<BookByReader> bookByReader = new MyLinkedList<>();
        Book book = new Book("Горе от ума");
        Book book1 = new Book( "Преступление и наказание");

        books.add(book);
        books.add(book1);
        BookRepository bookRepository = new BookRepository(books);

        Reader reader = new Reader("Vasya");
        Reader reader1 = new Reader("Petya");

        readers.add(reader);
        readers.add(reader1);

        ReaderRepository readerRepository = new ReaderRepository(readers);

        BookByReaderRepository booksByReaders = new BookByReaderRepository(new MyLinkedList<>());

        LiberyService liberyService= new LiberyService(bookRepository,readerRepository,booksByReaders);

        System.out.println(liberyService.getAllBooks());
        System.out.println(liberyService.getAllReaders());
        liberyService.takeBook(book,reader);
        liberyService.takeBook(book1,reader1);
        liberyService.readedBooks();
        liberyService.freeBooks();

    }
}
