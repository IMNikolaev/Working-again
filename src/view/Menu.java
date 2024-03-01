package view;

import model.Reader;
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
            System.out.println(COLOR_RED + "Вход для АДМИНА" + RESET_COLOR);

            //запрашиваем выбор пользователя
            System.out.println(COLOR_YELLOW + "\nСделайте выбор пункта:" + RESET_COLOR);
            int input = scanner.nextInt();
            scanner.nextLine();

            if (input == 0) break;
            handleUserMenuChoice(input);
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


/*// ПРОВЕРКА НА КОРЕКТНОСТЬ ДАННЫХ
                User registerUser = service.registerUser(email, password);
                if (registerUser == null) {
                    System.out.println("Вы ввели некорректный email или password");
                } else {
                    System.out.println("Вы успешно зарегистрировались в системе");
                    System.out.println("Для начала работу пройдите авторизацию");
                }
                registMenu();// ПЕРЕХОД НА МЕНЮ ЗАРЕГЕСТРИРОВАННОГО ПОЛЬЗОВАТЕЛЯ
                waitRead();
                break;*/
            case 99:
                adminMenu();
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
            System.out.println(COLOR_YELLOW + "6" + RESET_COLOR + "->" + boldTextStart + "Список книг, которые сейчас у пользователя" + boldTextEnd);
            System.out.println(COLOR_YELLOW + "7" + RESET_COLOR + "->" + boldTextStart + "Получить список книг, которые взяты" + boldTextEnd);
            System.out.println(COLOR_YELLOW + "8" + RESET_COLOR + "->" + boldTextStart + "Редактирование информации о книге" + boldTextEnd);
            System.out.println(COLOR_YELLOW + "0" + RESET_COLOR + "->" + boldTextStart + "ВЫХОД" + boldTextEnd);

            //запрашиваем выбор пользователя
            System.out.println(COLOR_YELLOW + "\nСделайте выбор пункта:" + RESET_COLOR);
            int input = scanner.nextInt();
            scanner.nextLine();

            //проверка не выбран ли пункт выход
            if (input == 0) {
                System.out.println(COLOR_GREEN + "До свидания! Ждем вас снова!" + RESET_COLOR);
                System.exit(0); // завершение работа приложения
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
                // TODO нужно еще добавить автора
                liberyService.addBook(scanner.nextLine(), scanner.nextLine());
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
                //TODO ПОДУМАТЬ
                //libraryService.takeBook();
                break;
            case 6:// МЕТОД - Список книг, которые сейчас у пользователя
                //
                break;
            case 7:// МЕТОД - Получить список книг, которые взяты
                liberyService.readedBooks();
                waitRead();
                break;
            case 8:// МЕТОД - Редактирование информации о книге
                //
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
            System.out.println(COLOR_YELLOW + "0" + RESET_COLOR + "->" + boldTextStart + " ВЫХОД" + boldTextEnd);

            System.out.println(COLOR_YELLOW + "\nСделайте выбор пункта:" + RESET_COLOR);

            int input = scanner.nextInt();
            scanner.nextLine();

            //проверка не выбран ли пункт выход
            if (input == 0) {
                System.out.println(COLOR_GREEN + "До свидания! Ждем вас снова!" + RESET_COLOR);
                System.exit(0); // завершение работа приложения
                // break;
            }

            //обрабатываем пользовательский ввод
            //liberyService.takeReaderById(userService.activeUser().getId())
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
                // TODO Дописать вывод всех книг а не одной!!!
                liberyService.findByTitle(scanner.nextLine());
                waitRead();
                break;
            case 3:// МЕТОД - Взятие книги из библиотеки
                liberyService.freeBooks();
                System.out.println(COLOR_GREEN + " === Выберете книгу по номеру: " + RESET_COLOR);
                int numberBookToAdd = scanner.nextInt();
                liberyService.takeBookById(numberBookToAdd, reader);
                System.out.print(COLOR_GREEN + "Вы взяли книгу " + RESET_COLOR + liberyService.getBookById(numberBookToAdd));
                // TODO СПРОСИТЬ!!!
                waitRead();
                break;
            case 4:// МЕТОД - Возврат книги в библиотеку
                // TODO ДОПИСАТЬ
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
                // TODO ДОПИСАТЬ
                // listBorrowedBooks()
                break;
            case 7:// МЕТОД - Список всех книг, отсортированный по автору
                // TODO ДОПИСАТЬ
                // listBooksSortedByAuthor()
                break;
            case 8:// МЕТОД - Список всех книг, отсортированный по названию книги
                liberyService.findAllSortedByTitle();
                waitRead();
                break;

            default:
                System.out.println(COLOR_RED + "Ваш выбор не корректен, попробуйте еще раз!" + RESET_COLOR);
                waitRead();

        }
    }

    private void waitRead() {
        System.out.println("\nДля продолжения нажмите " + COLOR_RED + "Enter ..." + RESET_COLOR);
        scanner.nextLine();
    }
}