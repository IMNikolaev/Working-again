package view;

import model.*;
import repository.*;
import service.LiberyService;
import service.UserService;
import util.MyLinkedList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
/*

        libraryService.addBook("Дядя Ваня", "Антон Чехов");
        libraryService.addBook("Отцы и дети", "Иван Тургенев");
        libraryService.addBook("Детство", "Лев Толстой");
        libraryService.addBook("Преступление и наказание", "Федор Достоевский");
        libraryService.addBook("Евгений Онегин", "Александр Пушкин");
        libraryService.addBook("Вишневый сад", "Антон Чехов");
        libraryService.addBook("Дворянское гнездо", "Иван Тургенев");
        libraryService.addBook("Анна Каренина", "Лев Толстой");
        libraryService.addBook("Идиот", "Федор Достоевский");
        libraryService.addBook("Пиковая дама", "Александр Пушкин");
        libraryService.addBook("Хаджи-Мурат", "Лев Толстой");
        libraryService.addBook("Братья Карамазовы", "Федор Достоевский");
        libraryService.addBook("Дама с собачкой", "Антон Чехов");
        libraryService.addBook("Пиковая дама", "Александр Пушкин");
        libraryService.addBook("Кавказский пленник", "Лев Толстой");
        libraryService.addBook("Бесы", "Федор Достоевский");
        libraryService.addBook("Три сестры", "Антон Чехов");
        libraryService.addBook("Война и мир", "Лев Толстой");
        libraryService.addBook("Преступление и наказание", "Федор Достоевский");
        libraryService.addBook("Толстый и тонкий", "Антон Чехов");
        libraryService.addBook("Анна Каренина", "Лев Толстой");
        libraryService.addBook("Идиот", "Федор Достоевский");
        libraryService.addBook("Вишневый сад", "Антон Чехов");
        libraryService.addBook("Отцы и дети", "Иван Тургенев");
        libraryService.addBook("Евгений Онегин", "Александр Пушкин");
        libraryService.addBook("Воскресение", "Лев Толстой");
        libraryService.addBook("Братья Карамазовы", "Федор Достоевский");
        libraryService.addBook("Дама с собачкой", "Антон Чехов");
        libraryService.addBook("Дворянское гнездо", "Иван Тургенев");
        libraryService.addBook("Пиковая дама", "Александр Пушкин");
        libraryService.addBook("Хаджи-Мурат", "Лев Толстой");
        libraryService.addBook("Бесы", "Федор Достоевский");
        libraryService.addBook("Три сестры", "Антон Чехов");
        libraryService.addBook("Накануне", "Иван Тургенев");
        libraryService.addBook("Медный всадник", "Александр Пушкин");
        libraryService.addBook("Казаки", "Лев Толстой");
        libraryService.addBook("Игрок", "Федор Достоевский");
*/

        String filePath = "Books.txt";
        
        File file = new File(filePath);

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] bookTitleAndAuthor = line.split("\\|");
                libraryService.addBook(bookTitleAndAuthor[0], bookTitleAndAuthor[1]);
            }

            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Menu menu = new Menu(libraryService, userService);


        menu.run();
    }
}
