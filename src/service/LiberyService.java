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


    public void addNewReader (String name, Integer id){
        Reader reader = new Reader(name, id);
        readerRepository.add(reader);
    }

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
    public Book getBookById (Integer id){
        return bookRepository.findById(id);
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
    public void takeBookById(Integer id, Reader reader){
        takeBook(bookRepository.findById(id),reader);
    }

    public void removeBook(Book book, Reader reader){
        if (book.isBookStatus()){
            bookByReaderRepository.returnBook(book,reader);
        }
        else {
            System.out.println("Книга и так свободна!");
        }
    }

    public void removeBookbyId (Integer id, Reader reader){
        removeBook(bookRepository.findById(id),reader);
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

    public void booksThisReader (Reader reader){
        System.out.println(bookByReaderRepository.booksHaveReader(reader));
    }

    public Reader takeReaderById(int id) {
        return readerRepository.findById(id);
    }
}


