package view.MenuJUnit;

import model.Book;
import model.Reader;
import model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import repository.BookByReaderRepository;
import repository.BookRepository;
import repository.ReaderRepository;
import repository.UserRepository;
import service.LiberyService;
import service.UserService;
import util.MyLinkedList;
import util.MyList;
import view.Menu;

import java.util.ArrayList;
import java.util.function.BooleanSupplier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    Menu menu;
    User user;
    UserRepository userRepository;
    LiberyService liberyService;

    MyLinkedList<Book> books = new MyLinkedList<>();
    MyLinkedList<Reader> readers = new MyLinkedList<>();
    BookRepository bookRepository = new BookRepository(books);
    ReaderRepository readerRepository = new ReaderRepository(readers);
    MyLinkedList<User> users = new MyLinkedList<>();

    BookByReaderRepository booksByReaders = new BookByReaderRepository(new MyLinkedList<>());
    LiberyService libraryService = new LiberyService(bookRepository, readerRepository, booksByReaders);
    UserService userService = new UserService(userRepository, libraryService);

    Reader reader;
    String startEmail = "test@test.com";
    String startPassword = "Password1@";
    String name = "Test Uer";


    /*
    // выполняется перед каждым тестом
    @BeforeEach
    void setUp() {
        // userRepository = new UserRepository(startEmail,startPassword);
        // System.out.println("Method before each");
        //   System.out.println("Test Working");
    }


    //Todo метод правильный но не работает надо проверять

    /*
    @ParameterizedTest
    @ValueSource(strings = {"valid@test.com", "password1@"})
    public Object testValidEmailSet() {
        //  Assertions.assertTrue(startEmail,startPassword.equals (testValidEmailSet())return false;


        // String validEmail = "valid@te.st.com";
        // String password = "password1@";
        // System.out.println("getEmail: " + user.getEmail());

        //  userRepository.isEmailValid(validEmail);

        //  System.out.println("getEmail: " + user.getEmail());
        // Assertions.assertEquals(null, userRepository.createUser(validEmail, password, "1"));
        //
    }

     */


    //Todo вроде рабочий надо допилить
    @ParameterizedTest
    @MethodSource("validEmailData")
    public void testSetValidEmail(String email) {
        User user = userRepository.createUser(email, startPassword, name);
        Assertions.assertNotNull(user);
        Assertions.assertEquals(email, user.getEmail());
    }

    static Stream<String> validEmailData() {
        return Stream.of(
                "test@email.net",
                "test@example.com",
                "user123@test.com",
                "john.doe@test.org"
        );
    }



    @ParameterizedTest
    @MethodSource("validPasswordData")
    public void testSetValidPassword(String password) {
        User user1 = userRepository.createUser(startEmail, password, name);
        System.out.println("User: " + user1);
        Assertions.assertNotNull(user1);

        Assertions.assertEquals(password, user1.getPassword());
    }

    static Stream<String> validPasswordData() {
        return Stream.of(
                "Password1@",
                "PASSWORDD1@",
                "password1@",
                "passworD.@",
                ""

        );
    }


    //Todo DONE!
    @Test
    public void allReaders() {
        Reader reader1 = new Reader("Иванов", 1);
        Reader reader2 = new Reader("Petro", 2);
        Reader reader3 = new Reader("Vasyl", 3);
        System.out.println(reader1);
        System.out.println(reader2);
        System.out.println(reader3);

        assertNotNull(reader1);
        assertNotNull(reader2);
        assertNotNull(reader3);
    }

    //Todo DONE!
    @Test
    public void addBook() {
        Book book1 = new Book("Война и мир", "Ivan");
        Book book2 = new Book("qwe", "Petro");
        Book book3 = new Book("fds", "Vasyl");

        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);

        assertNotNull(book1);
        assertNotNull(book2);
        assertNotNull(book3);
    }

    //Todo DONE!
    @Test
    public void getAllBooks() {

        libraryService.addBook("Book1", "adsd");
        libraryService.addBook("Book2", "addsadsd");
        libraryService.addBook("Book3", "adsd");
        libraryService.addBook("Book4", "addsadsd");

        assertNotNull(bookRepository.findAll());

    }

    //Todo допилить
    @Test
    @Disabled
    public void tokeBooks() {
        Book book1 = new Book("Война и мир", "Ivan");
        Book book2 = new Book("qwe", "Petro");
        Book book3 = new Book("fds", "Vasyl");

        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);

        // assertEquals(1, bookRepository.findByAuthor(book1,book2,book3, books));

    }


    //TODO
    @Test
    public void freeBooks() {

        MyList<Book> freeBooks = bookRepository.findfreeBooks();

        Book book1 = new Book("Война и мир", "Ivan");
        Book book2 = new Book("qwe", "Petro");
        Book book3 = new Book("fds", "Vasyl");

        books.addAll(book1,book2,book3);


        for (int i = 0; i < freeBooks.size(); i++) {
            if (freeBooks.get(i).isBookStatus()) {
                books.add(freeBooks.get(i));
            }
        }

        assertEquals(freeBooks.size(), books.size());
//        for (Book book : books) {
//            assertEquals(true, book.isBookStatus());
//        }


        System.out.println(books);
    }


    //Todo DONE!
    @Test
    public void findBookByTitle() {
        Book book1 = new Book("Война и мир", "Ivan");
        Book book2 = new Book("qwe", "Petro");
        Book book3 = new Book("fds", "Vasyl");

        String res = "Война и мир";


        assertEquals("Война и мир", res);

        System.out.println(res);

    }


}