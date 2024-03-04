package repository;

import model.Book;
import util.MyLinkedList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class BookRepository {
    private final MyLinkedList<Book> books;

    public BookRepository() {
        this.books = new MyLinkedList<>();
        addBooksFromFiles();
    }

    public void add(Book newBook) {books.add(newBook);}

    public MyLinkedList<Book> findAll() {return books;}

    public void addBooksFromFiles ()
    {
        String filePath = "Books.txt";

        File file = new File(filePath);

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] bookTitleAndAuthor = line.split("\\|");
                Book newBook = new Book(bookTitleAndAuthor[0], bookTitleAndAuthor[1]);
                books.add(newBook);
            }

            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MyLinkedList<Book> findReservedBooks(){
        MyLinkedList<Book> reservedBooks = new MyLinkedList<>();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).isBookStatus())
            {
                reservedBooks.add(books.get(i));
            }
        }
        return reservedBooks;
    }
    public MyLinkedList<Book> findfreeBooks() {
        MyLinkedList<Book> freeBooks = new MyLinkedList<>();
        for (int i = 0; i < books.size(); i++) {
            if (!books.get(i).isBookStatus())
            {
                freeBooks.add(books.get(i));
            }
        }
        return freeBooks;
    }

    public Book findById(Integer bookId){
        for (int i = 0; i < books.size(); i++) {
            Book currentBook = books.get(i);
            if (currentBook.getBookId().equals(bookId)) {
                return currentBook;
            }
        }
        return null;
    }

    public MyLinkedList<Book> findByTitle(String title) {
        String lowercaseTitle = title.toLowerCase();
        MyLinkedList<Book> booksFindAllByTitle = new MyLinkedList<>();
        for (int i = 0; i < books.size(); i++) {
            Book currentBook = books.get(i);
            String lowercaseBookTitle = currentBook.getBookTitle().toLowerCase();
            if (lowercaseBookTitle.contains(lowercaseTitle)) {
                booksFindAllByTitle.add(currentBook);
            }
        }

        return booksFindAllByTitle;
    }

    public MyLinkedList<Book> findByAuthor(String author) {
        String lowercaseTitle = author.toLowerCase();
        MyLinkedList<Book> booksFindAllByAuthor = new MyLinkedList<>();
        for (int i = 0; i < books.size(); i++) {
            Book currentBook = books.get(i);
            String lowercaseAuthorTitle = currentBook.getBookAuthor().toLowerCase();
            if (lowercaseAuthorTitle.contains(lowercaseTitle)) {
                booksFindAllByAuthor.add(currentBook);
            }
        }

        return booksFindAllByAuthor;
    }



    public Book[] sortBooksByTitle (){
        MyLinkedList<Book> sorterBooks = findAll();
        Book[] bookArray1 = sorterBooks.toArray();
        Arrays.sort(bookArray1, Comparator.comparing(Book::getBookTitle));
        return bookArray1;
    }
    public Book[] sortBooksByAuthor (){
        MyLinkedList<Book> sorterBooks = findAll();
        Book[] bookArray1 = sorterBooks.toArray();
        Arrays.sort(bookArray1, Comparator.comparing(Book::getBookAuthor));
        return bookArray1;
    }

}
