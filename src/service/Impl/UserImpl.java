package service.Impl;

import enums.Gender;
import model.Book;
import model.User;
import service.UserService;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class UserImpl implements UserService {
    List<User> users = new LinkedList<>();
    @Override
    public String createUser(List<User> users) {
        this.users.addAll(users);
        return "Users are successfully created!";
    }

    @Override
    public List<User> findAllUsers() {
        return this.users;
    }

    @Override
    public User findUserById(Long id) {
        for (User user : this.users) {
            if(user.getId().longValue()==id){
                return user;
            }
        }
        return null;
    }

    @Override
    public String removeUserByName(String name) {
        for (User user : this.users) {
            if(user.getName().equals(name)){
                this.users.remove(user);
            }
        }
        return "User is successfully removed!";
    }

    @Override
    public void updateUser(Long id) {
        Scanner s = new Scanner(System.in);
        System.out.print("Chose what you want to change: ");
        String word = s.nextLine();
        for (User user : this.users) {
            if(user.getId().longValue()==id){
                if(word.equals("id")) {
                    System.out.print("Write the new id: ");
                    user.setId(s.nextLong());
                }else if(word.equals("name")) {
                    System.out.print("Write the new name: ");
                    user.setName(s.nextLine());
                } else if (word.equals("surname")) {
                    System.out.print("Write the new surname: ");
                    user.setSurname(s.nextLine());
                } else if (word.equals("email")) {
                    System.out.print("Write the new email: ");
                    user.setEmail(s.nextLine());
                } else if (word.equals("phone number")) {
                System.out.print("Write the new phoneNumber: ");
                user.setPhoneNumber(s.nextLine());
                } else if (word.equals("gender")) {
                System.out.print("Write the new Gender: ");
                user.setGender(Gender.valueOf(s.nextLine()));
                } else if (word.equals("money")) {
                System.out.print("Write the new money: ");
                user.setMoney(s.nextBigDecimal());
                }
                else {
                    System.out.println("No such field!");
                }
            }
        }
    }

    @Override
    public void groupUsersByGender() {
        List<User> females = new LinkedList<>();
        List<User> males = new LinkedList<>();
        for (User user : this.users) {
            if(user.getGender().equals(Gender.FEMALE)){
                females.add(user);
            }else {
                males.add(user);
            }
        }
    }

    @Override
    public String buyBooks(String name, List<Book> books) {
        System.out.print("Write the book name that you want buy: ");
        String bookName = new Scanner(System.in).nextLine();
        for (User user : this.users) {
            for (Book book : books) {
                if (user.getName().equals(name)) {
                    if (book.getName().equals(bookName)) {
                        user.getBooks().add(book);
                        user.setMoney(user.getMoney().subtract(book.getPrice()));
                    }
                }
            }
        }
        return "Book is successfully bought!";
    }
}
