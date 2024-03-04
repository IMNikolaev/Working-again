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

        BookRepository bookRepository = new BookRepository();
        ReaderRepository readerRepository = new ReaderRepository();
        UserRepository userRepository = new UserRepository();
        BookByReaderRepository booksByReaders = new BookByReaderRepository();
        LiberyService libraryService = new LiberyService(bookRepository, readerRepository, booksByReaders);
        UserService userService = new UserService(userRepository, libraryService);


        Menu menu = new Menu(libraryService, userService);


        menu.run();
    }
}
