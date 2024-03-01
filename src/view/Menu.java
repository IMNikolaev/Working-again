package view;

import model.Reader;
import model.Role;
import model.User;
import service.LiberyService;
import service.UserService;

import java.util.Scanner;

public class Menu {


    private final Scanner scanner = new Scanner(System.in);
    private final LiberyService liberyService;
    private final UserService userService;

    public Menu(LiberyService liberyService, UserService userService) {
        this.liberyService = liberyService;
        this.userService = userService;
    }

    String boldTextStart = "\033[1m";
    String boldTextEnd = "\033[0m";
    public static final String RESET_COLOR = "\u001B[0m";
    public static final String COLOR_BLACK = "\u001B[30m";
    public static final String COLOR_RED = "\u001B[31m";
    public static final String COLOR_GREEN = "\u001B[32m";
    public static final String COLOR_YELLOW = "\u001B[33m";
    public static final String COLOR_BLUE = "\u001B[34m";
    public static final String COLOR_PURPLE = "\u001B[35m";
    public static final String COLOR_CYAN = "\u001B[36m";
    public static final String COLOR_WHITE = "\u001B[37m";

    // ================ГЛАВНОЕ МЕНЮ====================
    public void run() {
        showMenu();
    }

    private void showMenu() { // ГЛАВНОЕ МЕНЮ
        while (true) {
            System.out.println(COLOR_BLUE + "=============ПРИВЕТСТВУЕМ В БИЛИОТЕКЕ=============" + RESET_COLOR);
            System.out.println(COLOR_YELLOW + "1" + RESET_COLOR + "->" + boldTextStart + "Авторизация" + boldTextEnd);
            System.out.println(COLOR_YELLOW + "2" + RESET_COLOR + "->" + boldTextStart + "Регистрация" + boldTextEnd);
            System.out.println(COLOR_YELLOW + "0" + RESET_COLOR + " ->" + boldTextStart + "ВЫХОД" + boldTextEnd);

            //запрашиваем выбор пользователя
            System.out.println(COLOR_YELLOW + "\nСделайте выбор пункта:" + RESET_COLOR);
            int input = scanner.nextInt();
            scanner.nextLine();

            if (input == 0) {
                System.out.println("До свидания");
                System.exit(0); // завершение работа приложения
            }
        }
    }


    private void handleUserMenuChoice(int input) {
        System.out.println("=========Введите ваши данные для входа в систему!===========");
        switch (input) {
            case 1:
                System.out.println(COLOR_GREEN + "Введите ваш email:" + RESET_COLOR);
                String email = scanner.nextLine();

                System.out.println(COLOR_GREEN + "Введи Ваш пароль:" + RESET_COLOR);
                String password = scanner.nextLine();


                if (userService.userAuthorize(email, password) != null) {
                    System.out.println(COLOR_GREEN + "Вы успешно вошли в систему!" + RESET_COLOR);
                    if (userService.activeUser() != null) {
                        if (userService.activeUser().getRole().equals(Role.BLOCKED)){
                            System.out.println(COLOR_RED + "Вы ЗАБЛОКИРОВАННЫ" + RESET_COLOR);
                            userService.activeUserFalse();
                            run();
                        }
                        registMenu(userService.activeUser());
                    }
                } else {
                    liberyService.getAllReaders();
                    System.out.println(COLOR_RED + "Неверный ввод!" + RESET_COLOR);
                    showMenu();
                }

                break;
// РЕГИСТРАЦИЯ В СИСТЕМЕ
            case 2:
                System.out.println(COLOR_GREEN + "Введите ваш email:" + RESET_COLOR);
                String emailNew = scanner.nextLine();

                System.out.println(COLOR_GREEN + "Введи Ваш пароль:" + RESET_COLOR);
                String passwordNew = scanner.nextLine();

                System.out.println(COLOR_GREEN + "Введи Ваше Имя:" + RESET_COLOR);
                String nameNew = scanner.nextLine();

                userService.createUser(emailNew, passwordNew, nameNew);
                break;

            default:
                System.out.println(COLOR_RED + "\nНе верный ввод попробуйте еще раз" + RESET_COLOR);
                waitRead();
                break;
        }

    }

    /*
     */
    //===============МЕНЮ АДМИНИСТРАТОРА====================
    public void adminMenu() {
        System.out.println(COLOR_BLUE + "============МЕНЮ АДМИНИСТРАТОРА============" + RESET_COLOR);
        while (true) {
            System.out.println(COLOR_YELLOW + "1" + RESET_COLOR + "->" + boldTextStart + "Список всех пользователей" + boldTextEnd);
            System.out.println(COLOR_YELLOW + "2" + RESET_COLOR + "->" + boldTextStart + "Добавление книги" + boldTextEnd);
            System.out.println(COLOR_YELLOW + "3" + RESET_COLOR + "->" + boldTextStart + "Список всех книг" + boldTextEnd);
            System.out.println(COLOR_YELLOW + "4" + RESET_COLOR + "->" + boldTextStart + "Список всех свободных книг" + boldTextEnd);
            System.out.println(COLOR_YELLOW + "5" + RESET_COLOR + "->" + boldTextStart + "Посмотреть у кого находится книга" + boldTextEnd);
            System.out.println(COLOR_YELLOW + "6" + RESET_COLOR + "->" + boldTextStart + "Получить список книг, которые взяты" + boldTextEnd);
            System.out.println(COLOR_YELLOW + "7" + RESET_COLOR + "->" + boldTextStart + "Редактирование информации о книге (Название)" + boldTextEnd);
            System.out.println(COLOR_YELLOW + "8" + RESET_COLOR + "->" + boldTextStart + "Редактирование информации о книге (Автор)" + boldTextEnd);
            System.out.println(COLOR_YELLOW + "9" + RESET_COLOR + "->" + boldTextStart + "Заблокировать пользователя по ID" + boldTextEnd);
            System.out.println(COLOR_YELLOW + "0" + RESET_COLOR + "->" + boldTextStart + "Вернутся в меню Юзера" + boldTextEnd);

            //запрашиваем выбор пользователя
            System.out.println(COLOR_YELLOW + "\nСделайте выбор пункта:" + RESET_COLOR);
            int input = scanner.nextInt();
            scanner.nextLine();

            //проверка не выбран ли пункт выход
            if (input == 0) {
                registMenu(userService.activeUser()); // завершение работа приложения
                break;
            }
//обрабатываем пользовательский ввод
            adminMenuOpen(input);

        }

    }

    private void adminMenuOpen(int input) {
        System.out.println("==========================================");
        switch (input) {
            case 1:// МЕТОД - Список всех пользователей
                liberyService.getAllReaders();
                waitRead();
                break;
            case 2:// МЕТОД - Добавление книги
                System.out.println(COLOR_YELLOW + "Введите название книги"+ RESET_COLOR);
                String newBookTitle= scanner.nextLine();
                System.out.println(COLOR_YELLOW + "Введите автора книги"+ RESET_COLOR);
                String newBookAuthor= scanner.nextLine();
                liberyService.addBook(newBookTitle, newBookAuthor);
                break;
            case 3:// МЕТОД - Список всех книг
                liberyService.getAllBooks();
                waitRead();
                break;
            case 4:// МЕТОД - Список всех свободных книг
                liberyService.freeBooks();
                waitRead();
                break;
            case 5:// МЕТОД - Посмотреть у кого находится книга
                liberyService.readedBooks();
                System.out.println(COLOR_GREEN + " === Выберете книгу по номеру: " + RESET_COLOR);
                int numberBook = scanner.nextInt();
                System.out.println(COLOR_YELLOW + "Книгу взял : "+ RESET_COLOR);
                liberyService.whoReadThisBook(numberBook);
                break;
            case 6:// МЕТОД - Получить список книг, которые взяты
                liberyService.readedBooks();
                waitRead();
                break;
            case 7:// МЕТОД - Редактирование информации о title
                liberyService.getAllBooks();
                System.out.println(COLOR_YELLOW + "Введите ID книги"+ RESET_COLOR);
                Integer RenamedBookIdByTitle= scanner.nextInt();
                scanner.nextLine();
                System.out.println(COLOR_YELLOW + "Введите новое название книги"+ RESET_COLOR);
                String RenamedBookTitleByTitle= scanner.nextLine();
                liberyService.renameBookbyTitle(RenamedBookIdByTitle, RenamedBookTitleByTitle);
                waitRead();
                break;
            case 8:// МЕТОД - Редактирование информации о author
                liberyService.getAllBooks();
                System.out.println(COLOR_YELLOW + "Введите ID книги"+ RESET_COLOR);
                Integer RenamedBookIdByAuthor = scanner.nextInt();
                scanner.nextLine();
                System.out.println(COLOR_YELLOW + "Введите нового автора книги"+ RESET_COLOR);
                String RenamedBookAuthorByAuthor= scanner.nextLine();
                liberyService.renameBookbyAuthor(RenamedBookIdByAuthor, RenamedBookAuthorByAuthor);
                waitRead();
                break;
            case 9:// МЕТОД - Блокировки пользователей
                liberyService.getAllReaders();
                System.out.println(COLOR_YELLOW + "Введите ID пользователя"+ RESET_COLOR);
                Integer blockedUserId = scanner.nextInt();
                userService.blockUser(blockedUserId);
                waitRead();
                break;
            default:
                System.out.println(COLOR_RED + "Ваш выбор не корректен попробуйте еще раз?" + RESET_COLOR);
                waitRead();

        }
    }


///===============МЕНЮ ПОЛЬЗОВАТЕЛЯ ПОСЛЕ РЕГИСТРАЦИИ======================

    public void registMenu(User user) {
        System.out.println(COLOR_BLUE + "============МЕНЮ ПОЛЬЗОВАТЕЛЯ============" + RESET_COLOR);
        while (true) {
            System.out.println(COLOR_YELLOW + "1" + RESET_COLOR + "->" + boldTextStart + " Список всех книг" + boldTextEnd);
            System.out.println(COLOR_YELLOW + "2" + RESET_COLOR + "->" + boldTextStart + " Поиск книги по названию" + boldTextEnd);
            System.out.println(COLOR_YELLOW + "3" + RESET_COLOR + "->" + boldTextStart + " Взятие книги из библиотеки по ID" + boldTextEnd);
            System.out.println(COLOR_YELLOW + "4" + RESET_COLOR + "->" + boldTextStart + " Возврат книги в библиотеку" + boldTextEnd);
            System.out.println(COLOR_YELLOW + "5" + RESET_COLOR + "->" + boldTextStart + " Список всех свободных книг" + boldTextEnd);
            System.out.println(COLOR_YELLOW + "6" + RESET_COLOR + "->" + boldTextStart + " Поиск книги по автору (полное имя или часть имени)" + boldTextEnd);
            System.out.println(COLOR_YELLOW + "7" + RESET_COLOR + "->" + boldTextStart + " Список всех книг, отсортированный по автору" + boldTextEnd);
            System.out.println(COLOR_YELLOW + "8" + RESET_COLOR + "->" + boldTextStart + " Список всех книг, отсортированный по названию книги" + boldTextEnd);
            System.out.println(COLOR_YELLOW + "0" + RESET_COLOR + "->" + boldTextStart + " Выйти из аккаунта" + boldTextEnd);

            System.out.println(COLOR_YELLOW + "\nСделайте выбор пункта:" + RESET_COLOR);

            int input = scanner.nextInt();
            scanner.nextLine();

            //проверка не выбран ли пункт выход
            if (input == 0) {
                userService.activeUserFalse();
                run();
            }

            regMenu(input, liberyService.takeReaderById(userService.activeUser().getId()));
        }
    }

    private void regMenu(int input, Reader reader) {
        System.out.println("==========================================");
        switch (input) {
            case 1:// МЕТОД - Список всех книг+
                liberyService.getAllBooks();
                waitRead();
                break;
            case 2:// МЕТОД - Поиск книги по названию+
                System.out.println(COLOR_YELLOW + "Введите название книги"+ RESET_COLOR);
                liberyService.findByTitle(scanner.nextLine());
                waitRead();
                break;
            case 3:// МЕТОД - Взятие книги из библиотеки
                liberyService.freeBooks();
                System.out.println(COLOR_GREEN + " === Выберете книгу по номеру: " + RESET_COLOR);
                int numberBookToAdd = scanner.nextInt();
                scanner.nextLine();
                liberyService.takeBookById(numberBookToAdd, reader);
                System.out.print(COLOR_GREEN + "Вы взяли книгу " + RESET_COLOR + liberyService.getBookById(numberBookToAdd));
                waitRead();
                break;
            case 4:// МЕТОД - Возврат книги в библиотеку
                System.out.println(COLOR_GREEN + " === Список книг которые вы взяли" + RESET_COLOR);
                liberyService.booksThisReader(reader);
                int numberBookToRemove = scanner.nextInt();
                liberyService.removeBookbyId(numberBookToRemove, reader);
                waitRead();
                break;
            case 5:// МЕТОД - Список всех свободных книг
                liberyService.freeBooks();
                waitRead();
                break;
            case 6:// МЕТОД - Поиск книги по автору (полное имя или часть имени)
                System.out.println(COLOR_YELLOW + "Введите автора книги"+ RESET_COLOR);
                liberyService.findByAuthor(scanner.nextLine());
                waitRead();
                break;
            case 7:// МЕТОД - Список всех книг, отсортированный по автору
                liberyService.findAllSortedByAuthor();
                waitRead();
                break;
            case 8:// МЕТОД - Список всех книг, отсортированный по названию книги
                liberyService.findAllSortedByTitle();
                waitRead();
                break;
            case 99:
                if (isAdmin(reader)) {
                    adminMenu();
                }
            default:
                System.out.println(COLOR_RED + "Ваш выбор не корректен, попробуйте еще раз!" + RESET_COLOR);
                waitRead();

        }
    }

    private boolean isAdmin (Reader reader){
        if(userService.activeUser().getRole().equals(Role.ADMIN)){
            return true;}
        return false;
    }

    private void waitRead() {
        System.out.println("\nДля продолжения нажмите " + COLOR_RED + "Enter ..." + RESET_COLOR);
        scanner.nextLine();
    }
}