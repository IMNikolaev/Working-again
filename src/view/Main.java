package view;

import model.*;
import repository.*;
import service.LiberyService;
import service.UserService;
import util.MyLinkedList;

public class Main {
    public static final String RESET_COLOR = "\u001B[0m";
    public static final String COLOR_BLACK = "\u001B[30m";
    public static final String COLOR_RED = "\u001B[31m";
    public static final String COLOR_GREEN = "\u001B[32m";
    public static final String COLOR_YELLOW = "\u001B[33m";
    public static final String COLOR_BLUE = "\u001B[34m";
    public static final String COLOR_PURPLE = "\u001B[35m";
    public static final String COLOR_CYAN = "\u001B[36m";
    public static final String COLOR_WHITE = "\u001B[37m";

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
        BookRepository bookRepository = new BookRepository(books);
        ReaderRepository readerRepository = new ReaderRepository(readers);
        MyLinkedList<User> users = new MyLinkedList<>();
        UserRepository userRepository = new UserRepository(users);
        BookByReaderRepository booksByReaders = new BookByReaderRepository(new MyLinkedList<>());
        LiberyService libraryService = new LiberyService(bookRepository, readerRepository, booksByReaders);
        UserService userService = new UserService(userRepository, libraryService);

        libraryService.addBook("Антон Чехов", "Дядя Ваня");
        libraryService.addBook("Иван Тургенев", "Отцы и дети");
        libraryService.addBook("Лев Толстой", "Детство");
        libraryService.addBook("Федор Достоевский", "Преступление и наказание");
        libraryService.addBook("Александр Пушкин", "Евгений Онегин");
        libraryService.addBook("Антон Чехов", "Вишневый сад");
        libraryService.addBook("Иван Тургенев", "Дворянское гнездо");
        libraryService.addBook("Лев Толстой", "Анна Каренина");
        libraryService.addBook("Федор Достоевский", "Идиот");
        libraryService.addBook("Александр Пушкин", "Пиковая дама");
        libraryService.addBook("Антон Чехов", "Толстый и тонкий");
        libraryService.addBook("Иван Тургенев", "Отцы и дети");
        libraryService.addBook("Лев Толстой", "Хаджи-Мурат");
        libraryService.addBook("Федор Достоевский", "Братья Карамазовы");
        libraryService.addBook("Антон Чехов", "Дама с собачкой");
        libraryService.addBook("Иван Тургенев", "Дворянское гнездо");
        libraryService.addBook("Александр Пушкин", "Пиковая дама");
        libraryService.addBook("Лев Толстой", "Кавказский пленник");
        libraryService.addBook("Федор Достоевский", "Бесы");
        libraryService.addBook("Антон Чехов", "Три сестры");
        libraryService.addBook("Лев Толстой", "Война и мир");
        libraryService.addBook("Федор Достоевский", "Преступление и наказание");
        libraryService.addBook("Антон Чехов", "Толстый и тонкий");
        libraryService.addBook("Лев Толстой", "Анна Каренина");
        libraryService.addBook("Федор Достоевский", "Идиот");
        libraryService.addBook("Антон Чехов", "Вишневый сад");
        libraryService.addBook("Иван Тургенев", "Отцы и дети");
        libraryService.addBook("Александр Пушкин", "Евгений Онегин");
        libraryService.addBook("Лев Толстой", "Воскресение");
        libraryService.addBook("Федор Достоевский", "Братья Карамазовы");
        libraryService.addBook("Антон Чехов", "Дама с собачкой");
        libraryService.addBook("Иван Тургенев", "Дворянское гнездо");
        libraryService.addBook("Александр Пушкин", "Пиковая дама");
        libraryService.addBook("Лев Толстой", "Хаджи-Мурат");
        libraryService.addBook("Федор Достоевский", "Бесы");
        libraryService.addBook("Антон Чехов", "Три сестры");
        libraryService.addBook("Иван Тургенев", "Накануне");
        libraryService.addBook("Александр Пушкин", "Медный всадник");
        libraryService.addBook("Лев Толстой", "Казаки");
        libraryService.addBook("Федор Достоевский", "Игрок");

        Menu menu = new Menu(libraryService, userService);
        menu.run();
        //libraryService.getAllBooks();
    }
}
