package repository;

import model.Book;
import util.MyLinkedList;

public class BookRepository {
    private final MyLinkedList<Book> books;

    public BookRepository(MyLinkedList<Book> books) {
        this.books = books;
    }

    public void add(Book newBook) {books.add(newBook);}

    public MyLinkedList<Book> findAll() {return books;}

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

    public Book findByTitle(String title) {
        String lowercaseTitle = title.toLowerCase();
        for (int i = 0; i < books.size(); i++) {
            Book currentBook = books.get(i);
            String lowercaseBookTitle = currentBook.getBookTitle().toLowerCase();
            if (lowercaseBookTitle.contains(lowercaseTitle)) {
                return currentBook;
            }
        }
        return null;
    }
}
