package service;

import model.Author;
import model.Book;
import model.BookByReader;
import model.Reader;
import repository.AuthorRepository;
import repository.BookByReaderRepository;
import repository.BookRepository;
import repository.ReaderRepository;
import util.MyLinkedList;

public class LiberyService {

    private BookRepository bookRepository;
    private ReaderRepository readerRepository;
    private BookByReaderRepository bookByReaderRepository;
    private AuthorRepository authorRepository;

    public LiberyService(BookRepository bookRepository, ReaderRepository readerRepository,BookByReaderRepository booksByReaders) {
        this.bookRepository = bookRepository;
        this.readerRepository = readerRepository;
        this.bookByReaderRepository = booksByReaders;
    }

    public void addBook (String title){
        Book book = new Book(title);
        bookRepository.add(book);
    }

    public void getAllBooks() {
        System.out.println("Список всех книг");
        System.out.println(bookRepository.findAll());
    }

    public void getAllReaders(){
        System.out.println("Список всех зарегистрированных читателей");
        System.out.println(readerRepository.findAll());
        }

    public void readedBooks (){
        System.out.println("Список книг, которые взяты:");
        System.out.println(bookRepository.findReservedBooks());
    }

    public void freeBooks(){
        System.out.println("Список книг, которые можно взять:");
        System.out.println(bookRepository.findfreeBooks());
    }
    public void takeBook(Book book, Reader reader) {
        // Проверяем, есть ли книга в данный момент у другого читателя
        if (book.isBookStatus()){
            System.out.println("Книга уже занята!");
            return;
        }

        // Если книга доступна, берем ее
        bookByReaderRepository.takeBook(book, reader);
    }

    public MyLinkedList<Book> getBooksByReader(Reader reader){
        MyLinkedList<Book> booksByReader = new MyLinkedList<>();
        MyLinkedList<BookByReader> booksByReaders = bookByReaderRepository.getBooksByReaders();
        for (int i = 0; i < booksByReaders.size(); i++) {
            BookByReader bookByReader = booksByReaders.get(i);
            booksByReader.add(bookByReader.getBook());
        }
        return booksByReader;
    }

    public void checkBookStatus (Book book){
        if (book.isBookStatus()){
            MyLinkedList<Book> booksByReader = new MyLinkedList<>();
            MyLinkedList<BookByReader> booksByReaders = bookByReaderRepository.getBooksByReaders();
            for (int i = 0; i < booksByReaders.size(); i++) {
                BookByReader bookByReader = booksByReaders.get(i);
                if(bookByReader.getBook().equals(book)){
                    Reader reader = bookByReader.getReader();
                    System.out.println("Книга " + book.getBookTitle() + " находится у " + reader.getReaderName());
                }
            }
        }
        else {System.out.println("Книга " + book.getBookTitle() + " свободна");}
    }

    public void findAllSortedByTitle(){
        System.out.println("Отсортированный по названию список книг");
        System.out.println(bookRepository.sortBooks());
    }
    public void findByTitle(String bookTitle){
        System.out.println(bookRepository.findByTitle(bookTitle));
    }
    public void addAuthor(String name) {
        // Проверяем, существует ли автор с таким именем
        if (!authorRepository.existsByName(name)) {
            // Если не существует, добавляем нового автора
            Author newAuthor = new Author(name);
            authorRepository.add(newAuthor);
            System.out.println("Добавлен новый автор: " + name);
        } else {
            System.out.println("Автор с именем " + name + " уже существует.");
        }
    }
}


