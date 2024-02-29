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



    // ===========ГЛАВНОЕ МЕНЮ===============================================
    public void run() {
        showMenu();
    }

    private void showMenu() { // ГЛАВНОЕ МЕНЮ
        while (true) {
            System.out.println("ПРИВЕТСТВУЕМ В БИЛИОТЕКЕ");
            System.out.println("1 -> Авторизация");
            System.out.println("2 -> Регистрация");
            System.out.println("0 -> ВЫХОД");

            //запрашиваем выбор пользователя
            System.out.println("\nСделайте выбор пункта:");
            int input = scanner.nextInt();
            scanner.nextLine();

            if (input == 0) break;
            handleUserMenuChoice(input);
        }
    }


    private void handleUserMenuChoice(int input) {
        switch (input) {
            case 1:
                System.out.println("Введите ваш email:");
                String email = scanner.nextLine();

                System.out.println("Введи Ваш пароль:");
                String password = scanner.nextLine();


                if (userService.userAuthorize(email,password) != null){
                    System.out.println("Вы успешно вошли в систему!");
                    if (userService.activeUser()!= null){
                        registMenu(userService.activeUser());
                    }
                }
                else {
                    liberyService.getAllReaders();
                    System.out.println("Неверный ввод!");
                    showMenu();
                }

                break;
// РЕГИСТРАЦИЯ В СИСТЕМЕ
            case 2:
                //Регистрация
                System.out.println("Введите ваш email:");
                String emailNew = scanner.nextLine();

                System.out.println("Введи Ваш пароль:");
                String passwordNew = scanner.nextLine();

                System.out.println("Введи Ваше Имя:");
                String nameNew = scanner.nextLine();

                userService.createUser(emailNew,passwordNew,nameNew);
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

            default:
                System.out.println("\nНе верный ввод");
                waitRead();
                break;
        }

    }
    /*
*/
    //=====================МЕНЮ АДМИНИСТРАТОРА=============================
    public void adminMenu() { // МЕНЮ АДМИНИСТРАТОРА
        while (true) {
            System.out.println("1 -> Список всех пользователей");
            System.out.println("2 -> Добавление книги");
            System.out.println("3 -> Список всех книг");
            System.out.println("4 -> Список всех свободных книг");
            System.out.println("5 -> Посмотреть у кого находится книга");
            System.out.println("6 -> Список книг, которые сейчас у пользователя");
            System.out.println("7 -> Получить список книг, которые взяты");
            System.out.println("8 -> Редактирование информации о книге");
            System.out.println("0 -> ВЫХОД");

            //запрашиваем выбор пользователя
            System.out.println("\nСделайте выбор пункта:");
            int input = scanner.nextInt();
            scanner.nextLine();

            //проверка не выбран ли пункт выход
            if (input == 0) {
                System.out.println("До свидания");
                System.exit(0); // завершение работа приложения
                break;
            }
//обрабатываем пользовательский ввод
            adminMenuOpen(input);

        }

    }

    private void adminMenuOpen(int input) {
        switch (input) {
            case 1:// МЕТОД - Список всех пользователей
                liberyService.getAllReaders();
                waitRead();
                break;
            case 2:// МЕТОД - Добавление книги
                // TODO нужно еще добавить автора
                liberyService.addBook(scanner.nextLine());
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
                System.out.println("Ваш выбор не корректен");
                waitRead();

        }
    }


///===============МЕНЮ ПОЛЬЗОВАТЕЛЯ ПОСЛЕ РЕГИСТРАЦИИ======================

    public void registMenu(User user) { // МЕНЮ ПОЛЬЗОВАТЕЛЯ
        while (true) {
            System.out.println("1 -> Список всех книг");
            System.out.println("2 -> Поиск книги по названию");
            System.out.println("3 -> Взятие книги из библиотеки по ID");
            System.out.println("4 -> Возврат книги в библиотеку");
            System.out.println("5 -> Список всех свободных книг");
            System.out.println("6 -> Поиск книги по автору (полное имя или часть имени)");
            System.out.println("7 -> Список всех книг, отсортированный по автору");
            System.out.println("8 -> Список всех книг, отсортированный по названию книги");
            System.out.println("0 -> ВЫХОД");
            System.out.println("\nСделайте выбор пункта:");

            int input = scanner.nextInt();
            scanner.nextLine();

            //проверка не выбран ли пункт выход
            if (input == 0) {
                System.out.println("До свидания");
                System.exit(0); // завершение работа приложения
                // break;
            }

            //обрабатываем пользовательский ввод
            //liberyService.takeReaderById(userService.activeUser().getId())
            regMenu(input, liberyService.takeReaderById(userService.activeUser().getId()));
        }
    }

    private void regMenu(int input, Reader reader) {
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
                System.out.println("Выберете книгу по номеру: ");
                int numberBookToAdd = scanner.nextInt();
                liberyService.takeBookById(numberBookToAdd, reader);
                System.out.print("Вы взяли книгу " + liberyService.getBookById(numberBookToAdd));
                // TODO СПРОСИТЬ!!!
                waitRead();
                break;
            case 4:// МЕТОД - Возврат книги в библиотеку
                // TODO ДОПИСАТЬ
                System.out.println("Список книг которые вы взяли");
                liberyService.booksThisReader(reader);
                int numberBookToRemove = scanner.nextInt();;
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
                System.out.println("Ваш выбор не корректен");
                waitRead();

        }
    }

    private void waitRead() {
        System.out.println("\nДля продолжения нажмите Enter ...");
        scanner.nextLine();
    }
}