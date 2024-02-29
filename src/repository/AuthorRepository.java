package repository;

import model.Author;
import util.MyLinkedList;

public class AuthorRepository {

    private final MyLinkedList<Author> authors;


    public void add(Author newAuthor) {authors.add(newAuthor);}

    public AuthorRepository(MyLinkedList<Author> authors) {
        this.authors = authors;
    }

    public boolean existsByName(String name) {
        for (int i = 0; i < authors.size(); i++) {
            Author author = new Author(name);
            if (author.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    private void init() {
        Author author1 = new Author("Лев Толстой");
        Author author2 = new Author("Федор Достоевский");
        Author author3 = new Author("Николай Гоголь");
        Author author4 = new Author("Иван Тургенев");
        Author author5 = new Author("Антон Чехов");
        Author author6 = new Author("Александр Пушкин");
        Author author7 = new Author("Михаил Лермонтов");
        Author author8 = new Author("Иван Гончаров");
        Author author9 = new Author("Николай Лесков");
        Author author10 = new Author("Михаил Булгаков");
        Author author11 = new Author("Анна Ахматова");
        Author author12 = new Author("Марина Цветаева");
        Author author13 = new Author("Джон Рональд Руэл Толкин");
        Author author14 = new Author("Джоан Роулинг");
        Author author15 = new Author("Эрнест Хемингуэй");
        Author author16 = new Author("Марк Твен");
        Author author17 = new Author("Тарас Шевченко");
        Author author18 = new Author("Леся Українка");
        Author author19 = new Author("Иван Франко");
        Author author20 = new Author("Михайло Коцюбинський");
        authors.addAll(author1,author2,author3,author4,author5,author6,author7,author8,author9,author10,author11,author12,author13,author14,author15,author16,author17,author18,author19,author20);
    }

}
