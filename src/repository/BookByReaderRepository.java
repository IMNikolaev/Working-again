package repository;

import model.Book;
import model.BookByReader;
import model.Reader;
import util.MyLinkedList;

public class BookByReaderRepository {
    private final MyLinkedList<BookByReader> booksByReaders;

    public BookByReaderRepository(MyLinkedList<BookByReader> booksByReaders) {
        this.booksByReaders = booksByReaders;
    }

    //БЕЗ ПРОВЕРОК
/*    public void takeBook (Book book, Reader reader) {
        // Ищем запись о взятой книге у данного читателя
        for (BookByReader bookByReader : booksByReaders) {
            if (bookByReader.getBook().equals(book) && bookByReader.getReader().equals(reader)) {
                // Удаляем запись о взятии книги
                booksByReaders.remove(bookByReader);
                // Устанавливаем статус книги как доступную
                book.setBookStatus(false);
                break; // Выходим из цикла после удаления записи
            }

        }
    }*/
        public void takeBook (Book book, Reader reader){
            BookByReader bookByReader = new BookByReader(book, reader);
            booksByReaders.add(bookByReader);
            book.setBookStatus(true);
        }

    //БЕЗ ПРОВЕРОК
/*
    public void returnBook (Book book, Reader reader){
        BookByReader bookByReader = new BookByReader(book, reader);
        // Добавляем запись в список booksByReaders
        booksByReaders.add(bookByReader);
        // Устанавливаем статус книги как взятую
        book.setBookStatus(true);
    }
*/



    public void returnBook (Book book, Reader reader){
        for (int i = 0; i < booksByReaders.size(); i++) {
            BookByReader bookByReader = booksByReaders.get(i);
            if (bookByReader.getBook().equals(book) && bookByReader.getReader().equals(reader)) {
                booksByReaders.remove(bookByReader);
                book.setBookStatus(false);
                break;
            }
        }
    }

    public MyLinkedList<Book> booksHaveReader (Reader reader){
        MyLinkedList<Book> returnBooksHaveReader= new MyLinkedList<>();
        for (int i = 0; i < booksByReaders.size(); i++) {
            BookByReader bookByReader = booksByReaders.get(i);
            if (bookByReader.getReader().equals(reader)){
                returnBooksHaveReader.add(bookByReader.getBook());
            }
        }
        return returnBooksHaveReader;
    }

    @Override
    public String toString() {
        return "BooksByReaders{" +
                "booksByReaders=" + booksByReaders +
                '}';
    }

    public Reader whoReadBookById(int numberBook) {
        for (int i = 0; i < booksByReaders.size(); i++) {
            BookByReader bookByReader = booksByReaders.get(i);
            if (bookByReader.getBook().getBookId().equals(numberBook)){
                return bookByReader.getReader();
            }
        }
        return null;
    }
}
