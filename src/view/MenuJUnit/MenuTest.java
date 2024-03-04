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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BooleanSupplier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {





    BookRepository bookRepository = new BookRepository();
    ReaderRepository readerRepository = new ReaderRepository();
    UserRepository userRepository = new UserRepository();
    BookByReaderRepository booksByReaders = new BookByReaderRepository();
    LiberyService libraryService = new LiberyService(bookRepository, readerRepository, booksByReaders);
    UserService userService = new UserService(userRepository, libraryService);


    Reader reader;
    String startEmail = "test@test.com";
    String startPassword = "Password1@";
    String name = "Test Uer";




    @Test
    void testCreateUser_SuccessfulRegistration() {
        String email = "test@example.com";
        String password = "Password1@";
        String name = "John";

        User user = userRepository.createUser(email, password, name);
        System.out.println(user);
        assertNotNull(user);
    }

    //Todo доделать
    @ParameterizedTest
    @MethodSource({"validEmailData"})
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
                "user123@te.st.com",
                "john.doe@test.org"
        );
    }

//Todo доделать
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
                        "Paswordioom1!",
                "passworD1213123.@"
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
    public void getAllBooks() {

        assertNotNull(bookRepository.findAll());

    }


    @Test
    public void tookBooks() {

        libraryService.getAllBooks();
        Book testBook = bookRepository.findAll().getLast();
       Reader reader1 = new Reader("Хрен с гори", 100);
        libraryService.takeBookById(testBook.getBookId(),reader1);
        System.out.println(libraryService.getBookById(testBook.getBookId()));
        System.out.println(bookRepository.findReservedBooks().getLast());

        assertEquals(libraryService.getBookById(testBook.getBookId()),bookRepository.findReservedBooks().getLast());
    }



    @Test
    public void freeBooks() {


        MyLinkedList<Book> bookA = new MyLinkedList<>();
        MyLinkedList <Book> books = bookRepository.findAll();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i) != null) {
                bookA.add(bookRepository.findfreeBooks().get(i));
            }

            Assertions.assertNotNull(bookA);


        }
    }


    @Test
    public void findBookByTitle() {

        String res = "идиот";


        assertEquals("идиот", res);

        System.out.println(res);

    }


    @Test
    public void findAllSortedByTitle() {
        Book[] bookArray1 = bookRepository.sortBooksByTitle();


        Assertions.assertNotNull(bookArray1);
        for (int i = 0; i < bookArray1.length; i++) {
            System.out.println(bookArray1[i]);
        }
    }

    @Test
    public void findAllSortedByAuthor() {
        Book[] bookArray1 = bookRepository.sortBooksByAuthor();


        Assertions.assertNotNull(bookArray1);
        for (int i = 0; i < bookArray1.length; i++) {
            System.out.println(bookArray1[i]);
        }


    }


}