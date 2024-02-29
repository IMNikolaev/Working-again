package view;

import model.Author;
import model.Book;
import model.BookByReader;
import model.Reader;
import repository.AuthorRepository;
import repository.BookRepository;
import repository.BookByReaderRepository;
import repository.ReaderRepository;
import service.LiberyService;
import util.MyArrayList;
import util.MyLinkedList;
import util.MyList;

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


        // ВТОРЫЕ ТЕСТЫ


      /*  MyLinkedList<Book> books = new MyLinkedList<>();
        MyLinkedList<Reader> readers = new MyLinkedList<>();
        MyLinkedList<BookByReader> bookByReader = new MyLinkedList<>();
        Book book = new Book("Горе от ума");
        Book book1 = new Book( "Преступление и наказание");
        Book book2 = new Book( "Война и Мир");

        books.add(book);
        books.add(book1);
        books.add(book2);
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

        System.out.println("Поиск по строке или подстроке");
        System.out.println(bookRepository.findByTitle("Война"));*/


        // ТЕСТ 2


       /* MyLinkedList<Book> books = new MyLinkedList<>();
        MyLinkedList<Reader> readers = new MyLinkedList<>();

        // Создаем несколько книг
        Book book1 = new Book("Война и мир");
        Book book2 = new Book("Преступление и наказание");
        Book book3 = new Book("Горе от ума");

        // Добавляем книги в список книг
        books.add(book1);
        books.add(book2);
        books.add(book3);

        // Создаем несколько читателей
        Reader reader1 = new Reader("Иванов");
        Reader reader2 = new Reader("Петров");
        Reader reader3 = new Reader("Сидоров");

        // Добавляем читателей в список читателей
        readers.add(reader1);
        readers.add(reader2);
        readers.add(reader3);

        // Создаем репозитории книг и читателей КОСТЫЛЬ!!!!
        BookRepository bookRepository = new BookRepository(books);
        ReaderRepository readerRepository = new ReaderRepository(readers);
        BookByReaderRepository booksByReaders = new BookByReaderRepository(new MyLinkedList<>());

        // Создаем сервис библиотеки и передаем ему репозитории
        LiberyService libraryService = new LiberyService(bookRepository, readerRepository, booksByReaders);

        libraryService.getAllBooks(); // Получить список всех книг
        libraryService.getAllReaders(); // Получить список всех читателей
        libraryService.readedBooks(); // Получить список книг, которые взяты
        libraryService.freeBooks(); // Получить список всех свободных книг


        libraryService.takeBook(book1,reader1);
        libraryService.readedBooks(); // Получить список книг, которые взяты
        libraryService.takeBook(book1,reader2);

        MyLinkedList<Book> booksByReader = libraryService.getBooksByReader(reader1);

        System.out.println("Список книг, взятых читателем " + reader1.getReaderName() + ":");
        for (int i = 0; i < booksByReader.size(); i++) {
            Book readedBook = booksByReader.get(i);
            System.out.println(readedBook);
        }

        libraryService.checkBookStatus(book1);
        libraryService.checkBookStatus(book2);

        libraryService.findAllSortedByTitle();

        libraryService.findByTitle("война");*/

        // TEST 3

        MyLinkedList<Book> books = new MyLinkedList<>();
        MyLinkedList<Reader> readers = new MyLinkedList<>();
        MyLinkedList<Author> authors = new MyLinkedList<>();
        BookRepository bookRepository = new BookRepository(books);
        AuthorRepository authorRepository = new AuthorRepository(authors);
        ReaderRepository readerRepository = new ReaderRepository(readers);
        BookByReaderRepository booksByReaders = new BookByReaderRepository(new MyLinkedList<>());
        LiberyService libraryService = new LiberyService(bookRepository, readerRepository, booksByReaders);




    }
}
