import enums.Gender;
import enums.Genre;
import enums.Language;
import model.Book;
import model.User;
import service.Impl.BookImpl;
import service.Impl.UserImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        List<User> users = Arrays.asList(new User(1L, "Nuriza", "Muratova", "@nurizm", "+996554488060", Gender.FEMALE, BigDecimal.valueOf(10000), null),
                new User(2L, "Adil", "Aitbaev", "@adi", "+996229754578", Gender.MALE, BigDecimal.valueOf(1000), null),
                new User(3L, "Eliz", "Ashyrova", "@eliz", "+996435678234", Gender.FEMALE, BigDecimal.valueOf(1000), null),
                new User(4L, "Atai", "Atakanov", "@atai", "+996772345683", Gender.MALE, BigDecimal.valueOf(2000), null),
                new User(5L, "Adilet", "Baiamanov", "@adil", "+996552763293", Gender.MALE, BigDecimal.valueOf(3000), null));

        List<Book> books = Arrays.asList(new Book(1L, "Bir gana sen", Genre.ROMANCE, BigDecimal.valueOf(300), "Nurjigit Kadyrbekov", Language.KYRGYZ, LocalDate.of(2021, 4, 6)),
                new Book(2L, "Bai atam, kedei atam", Genre.FANTASY, BigDecimal.valueOf(500), "Nick vuichich", Language.RUSSIAN, LocalDate.of(2020, 4, 6)),
                new Book(3L, "Jamilya", Genre.HISTORICAL, BigDecimal.valueOf(400), "CH.Aitmatov", Language.KYRGYZ, LocalDate.of(2018, 4, 7)),
                new Book(4L, "Kosmos", Genre.FANTASY, BigDecimal.valueOf(300), "Mayiuyirk", Language.ENGLISH, LocalDate.of(2000, 3, 2)),
                new Book(5L, "Live is good", Genre.DETECTIVE, BigDecimal.valueOf(700), "Martin", Language.ENGLISH, LocalDate.of(2003, 7, 3)));

        BookImpl book = new BookImpl();
        UserImpl user = new UserImpl();
        while (true) {
            int number = new Scanner(System.in).nextInt();
            System.out.println("""
                    1. Create books
                    2. Get all books
                    3. Get books genre
                    4. remove book by id
                    5. filter book by published year
                    6. get Book by initial letter
                    7. max price book
                    8. create user
                    9. find all user
                    10. find user by id
                    11. remove user by name
                    12. up date user
                    13. group user by gender
                    14. buy books
                    """);
            switch (number) {
                case 1 -> System.out.println(book.createBooks(books));
                case 2 -> System.out.println(book.getAllBooks());
                case 3 -> {
                    System.out.print("Write the genre: ");
                    String w = new Scanner(System.in).next();
                    System.out.println(book.getBooksByGenre(w));
                }
                case 4 -> {
                    System.out.print("Write the id: ");
                    long s = new Scanner(System.in).nextInt();
                    System.out.println(book.removeBookById(s));
                }
                case 5 -> System.out.println(book.filterBooksByPublishedYear());
                case 6 -> System.out.println(book.getBookByInitialLetter());
                case 7 -> System.out.println(book.maxPriceBook());
                case 8 -> System.out.println(user.createUser(users));
                case 9 -> System.out.println(user.findAllUsers());
                case 10 -> {
                    System.out.print("Write the id: ");
                    long s = new Scanner(System.in).nextInt();
                    System.out.println(user.findUserById(s));
                }
                case 11 -> {
                    System.out.print("Write the name: ");
                    String w = new Scanner(System.in).next();
                    System.out.println(user.removeUserByName(w));
                }
                case 12 -> {
                    System.out.print("Write the id: ");
                    long s = new Scanner(System.in).nextInt();
                    user.updateUser(s);
                }
                case 13 -> user.groupUsersByGender();
                case 14 -> {
                    System.out.print("Write the person name: ");
                    String i = new Scanner(System.in).nextLine();
                    user.buyBooks(i, book.getAllBooks());
                }
                default -> throw new Exception("No such input");
            }
        }
    }
}