package view;

import model.Book;
import model.BookByReader;
import model.Reader;
import util.MyLinkedList;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Book> books = new MyLinkedList<>();
        MyLinkedList<Reader> readers = new MyLinkedList<>();
        MyLinkedList<BookByReader> bookByReader = new MyLinkedList<>();

        Book book = new Book(1, "Ksdada");
        Book book1 = new Book(2, "Ksdыфвфыada");

        System.out.println(book);

        Reader reader = new Reader(1, "Name");
        Reader reader1 = new Reader(2, "Sergey");

        System.out.println(reader);

        BookByReader bookByReader1 = new BookByReader(book.getBookId(), reader.getReaderId());
        BookByReader bookByReader2 = new BookByReader(book1.getBookId(), reader1.getReaderId());
        System.out.println(bookByReader1.getBookId());
        System.out.println(bookByReader2.getBookId());



    }
}
