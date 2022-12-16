package service.Impl;

import model.Book;
import service.BookService;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BookImpl implements BookService {
    List<Book> books = new LinkedList<>();

    @Override
    public List<Book> createBooks(List<Book> books) {
        this.books.addAll(books);
        return this.books;
    }

    @Override
    public List<Book> getAllBooks() {
        return this.books;
    }

    @Override
    public List<Book> getBooksByGenre(String genre) {
        List<Book> books1 = new LinkedList<>();
        for (Book book : this.books) {
            if (book.getGenre().name().equals(genre)) {
                books1.add(book);
            }
        }
        return books1;
    }

    @Override
    public Book removeBookById(Long id) {
        for (Book book : this.books) {
            if (book.getId().longValue() == id) {
                this.books.remove(book);
            }
        }
        return null;
    }

    @Override
    public List<Book> sortBooksByPriceInDescendingOrder() {
        this.books.sort(compare);
        return this.books;
    }

    @Override
    public List<Book> filterBooksByPublishedYear() {

        LocalDate i = LocalDate.ofEpochDay(LocalDate.now().getYear() - 10);
        List<Book> books1 = this.books.stream().filter(b -> b.getPublishedYear().isAfter(i)).toList();
        return books1;
    }

    @Override
    public List<Book> getBookByInitialLetter() {
        List<Book> books1 = new LinkedList<>();
        String letter = new Scanner(System.in).nextLine();
        for (Book book : this.books) {
            if (book.getName().startsWith(letter)) {
                books1.add(book);
            }
        }
        return books1;
    }

    @Override
    public Book maxPriceBook() {
        System.out.println(this.books.stream().mapToInt(x -> x.getPrice().intValue()).max());
        return null;
    }

    Comparator<Book> compare = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            return o2.getPrice().compareTo(o1.getPrice());
        }
    };
}

