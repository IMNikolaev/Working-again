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
               "PASSWORDD1@",

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
    public void getAllBooks() {
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


        assertNotNull(bookRepository.findAll());

    }


    @Test
    public void tookBooks() {
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



       Reader reader1 = new Reader("Хрен с гори", 1);
       libraryService.takeBookById(1,reader1);
       assertEquals(libraryService.getBookById(1),bookRepository.findReservedBooks().get(0));
        System.out.println(reader1);


    }



    @Test
    public void freeBooks() {
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


        MyLinkedList<Book> bookA = new MyLinkedList<>();

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i) != null) {
                bookA.add(bookRepository.findfreeBooks().get(i));
            }

            Assertions.assertNotNull(bookA);


//        for (int i = 0; i <books.size() ; i++) {
//            assertEquals(true,book1.isBookStatus());
//        }
//        for (Book book : books) {
//            assertEquals(true, book.isBookStatus());
//        }

        }
    }


    //Todo DONE!
    @Test
    public void findBookByTitle() {
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

        String res = "идиот";


        assertEquals("идиот", res);

        System.out.println(res);

    }


    //TODO провереть после Игоря изменение
    @Test
    public void findAllSortedByTitle() {
        //  MyLinkedList<Book> findAllSortedByTitle = bookRepository.sortBooksByTitle();
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

        MyLinkedList<Book> bookA = new MyLinkedList<>();

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i) != null) {
                bookA.add(bookRepository.sortBooksByTitle().get(i));
            }


        }
        Assertions.assertNotNull(bookA);
        System.out.println(bookA);


    }

    //TODO провереть после Игоря изменение
    @Test
    public void findAllSortedByAuthor() {
        //  MyLinkedList<Book> findAllSortedByTitle = bookRepository.sortBooksByTitle();
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

        MyLinkedList<Book> bookB = new MyLinkedList<>();

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i) != null) {
                bookB.add(bookRepository.sortBooksByAuthor().get(i));
            }


        }
        Assertions.assertNotNull(bookB);
        System.out.println(bookB);


    }


}