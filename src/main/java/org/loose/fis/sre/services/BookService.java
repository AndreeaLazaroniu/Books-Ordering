package org.loose.fis.sre.services;

import javafx.collections.FXCollections;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.jetbrains.annotations.NotNull;
import org.loose.fis.sre.exceptions.BookDoesntExistException;
import org.loose.fis.sre.exceptions.TitleAlreadyExistsException;
import org.loose.fis.sre.model.Book;
import javafx.collections.ObservableList;
import java.util.Objects;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class BookService {

    private static ObjectRepository<Book> bookRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("books-BookShop.db").toFile())
                .openOrCreate("test_book", "test_book");

        bookRepository = database.getRepository(Book.class);
    }

    public static void addBook(String title, String author, String price, String pageNumber, String genre) throws TitleAlreadyExistsException {
        checkBookDoesNotAlreadyExist(title);
        bookRepository.insert(new Book(title, author, price, pageNumber, genre));
    }

    public static void deleteBook(String title) {
        for (Book book : bookRepository.find()) {
            if (Objects.equals(title, book.getTitle())) {
                bookRepository.remove(book);
            }
        }
    }

    @NotNull
    public static Book[] arrBooks(String[] titles){
        Book[] books = new Book[5];
        for(int i=0; i<5; i++)
        {
            for (Book book : bookRepository.find()) {
                if (Objects.equals(titles[i], book.getTitle()))
                {
                    books[i] = book;
                }
            }
        }
        return books;
    }

    public static Double totalOrder(Book[] books) {
        double totalPrice=0.0;
        for(int i = 0; i < 5; i++)
        {
            totalPrice = totalPrice + Double.parseDouble(books[i].getPrice());
        }
        return totalPrice;
    }


    @NotNull
    public static ObservableList<Book> getBooks() {
        ObservableList<Book> books = FXCollections.observableArrayList();
        for (Book book : bookRepository.find()) {
            books.add(new Book(book.getTitle(), book.getAuthor(), book.getPrice(), book.getPageNumber(), book.getGenre()));
        }
        return books;
    }

    public static void editBook(String title, String price) {
        for (Book book : bookRepository.find()) {
            if (Objects.equals(title, book.getTitle()))
                book.setPrice(price);
                bookRepository.update(book);
        }
    }


    private static void checkBookDoesNotAlreadyExist(String title) throws TitleAlreadyExistsException {
        for (Book book : bookRepository.find()) {
            if (Objects.equals(title, book.getTitle()))
                throw new TitleAlreadyExistsException(title);
        }
    }

    private static void checkBookDoesExist(String title) throws BookDoesntExistException {
        for (Book book : bookRepository.find()) {
            if (Objects.equals(title, book.getTitle()))
                throw new BookDoesntExistException(title);
        }
    }
}
