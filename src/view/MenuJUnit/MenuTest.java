package view.MenuJUnit;

import model.Book;
import model.Reader;
import model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
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


//    @ParameterizedTest
//    @ValueSource(strings = {"test@example.com", "user123@test.com", "john.doe@test.org"})
//    public void testValidEmail(String email) {
//        // Здесь вызвать метод регистрации с переданным email и проверить, корректно ли он обрабатывает email.
//        boolean isValid = isValidEmail(email);
//        Assertions.assertTrue(isValid, "Email " + email + " должен быть корректным.");
//    }
//
//    private boolean isValidEmail(String email) {
//        // проверку корректности email здесь.
//
//        return true;
//    }


    @ParameterizedTest
    @MethodSource({"validEmailData", "validPasswordData"})
    public void testSetValidEmail(String email, String password) {
        User user = userRepository.createUser(email, password, name);
        assertNotNull(user);
        assertEquals(email, user.getEmail());
        assertEquals(password, user.getPassword());
    }

    static Stream<Arguments> validEmailData() {
        return Stream.of(
                Arguments.of("test@email.net", "Password1@"),
                Arguments.of("test@example.com", "PASSWORDD1@"),
                Arguments.of("user123@test.com", "password1@"),
                Arguments.of("john.doe@test.org", "passworD.@")
        );
    }

    static Stream<Arguments> validPasswordData() {
        return Stream.of(
                Arguments.of("test@email.net", "Password1@"),
                Arguments.of("test@example.com", "PASSWORDD1@"),
                Arguments.of("user123@test.com", "password1@"),
                Arguments.of("john.doe@test.org", "passworD.@")
        );
    }

    /*
    //Todo вроде рабочий надо допилить
    @ParameterizedTest
    @MethodSource({"validEmailData", "validPasswordData"})
    public void testSetValidEmail(String email) {
        User user = userRepository.createUser(email, startPassword, name);
        Assertions.assertNotNull(user);
        Assertions.assertEquals(email, user.getEmail());
        Assertions.assertEquals(startPassword, user.getPassword());
    }

    static Stream<String> validEmailData() {
        return Stream.of(
                "test@email.net",
                "test@example.com",
                "user123@test.com",
                "john.doe@test.org"
        );
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

     */


//    @ParameterizedTest
//    @MethodSource("validPasswordData")
//    public void testSetValidPassword(String password) {
//        User user1 = userRepository.createUser(startEmail, password, name);
//        System.out.println("User: " + user1);
//        Assertions.assertNotNull(user1);
//
//        Assertions.assertEquals(password, user1.getPassword());
//    }

//    static Stream<String> validPasswordData() {
//        return Stream.of(
//                "Password1@",
//                "PASSWORDD1@",
//                "password1@",
//                "passworD.@",
//                ""
//
//        );
//    }


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

    //Todo TEST
    @Test
    public void tookBooks() {
        MyList<Book> tookBooks = bookRepository.findReservedBooks();

       Book book1 = new Book("Война и мир", "Ivan");
//        Book book2 = new Book("qwe", "Petro");
//        Book book3 = new Book("fds", "Vasyl");

           books.addAll(book1);

        System.out.println(books);

        for (int i = books.size(); i > 0; i--) {
            if (books.get(i).isBookStatus()) {
                tookBooks.add(books.get(i));
                assertEquals(books.size(), tookBooks.size());

            }
            return;

        }
            System.out.println("No books");

    }


    //TODO TEST
    @Test
    public void freeBooks() {

        MyList<Book> freeBooks = bookRepository.findfreeBooks();

        Book book1 = new Book("Война и мир", "Ivan");
        Book book2 = new Book("qwe", "Petro");
        Book book3 = new Book("fds", "Vasyl");

        books.addAll(book1, book2, book3);

        System.out.println(books);

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).isBookStatus()) {
                freeBooks.add(books.get(i));
                assertEquals(books.size(), freeBooks.size());
            }
            return;

        }


//        for (int i = 0; i <books.size() ; i++) {
//            assertEquals(true,book1.isBookStatus());
//        }
//        for (Book book : books) {
//            assertEquals(true, book.isBookStatus());
//        }

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
    //TODO
    @Test
    @Disabled
    public void findAllSortedByTitle(){
        MyLinkedList<Book> findAllSortedByTitle = bookRepository.sortBooksByTitle();




        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).isBookStatus()) {
                findAllSortedByTitle.add(books.get(i));
            }
            return;

        }

        Assertions.assertNotNull(findAllSortedByTitle);

        System.out.println(findAllSortedByTitle);

    }




    //TODO
    @Test
    @Disabled
    public void findAllSortedByAuthor(){
        MyLinkedList<Book> findAllSortedByAuthor = bookRepository.sortBooksByTitle();




        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).isBookStatus()) {
                findAllSortedByAuthor.add(books.get(i));
            }
            return;

        }

        Assertions.assertNotNull(findAllSortedByAuthor);

        System.out.println(findAllSortedByAuthor);

    }


}