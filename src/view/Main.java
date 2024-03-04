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

        MyLinkedList<Book> books = new MyLinkedList<>();
        MyLinkedList<Reader> readers = new MyLinkedList<>();
        BookRepository bookRepository = new BookRepository(books);
        ReaderRepository readerRepository = new ReaderRepository(readers);
        MyLinkedList<User> users = new MyLinkedList<>();
        UserRepository userRepository = new UserRepository(users);
        BookByReaderRepository booksByReaders = new BookByReaderRepository(new MyLinkedList<>());
        LiberyService libraryService = new LiberyService(bookRepository, readerRepository, booksByReaders);
        UserService userService = new UserService(userRepository, libraryService);



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
