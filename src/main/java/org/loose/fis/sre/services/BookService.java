package org.loose.fis.sre.services;

import javafx.collections.FXCollections;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.jetbrains.annotations.NotNull;
import org.loose.fis.sre.exceptions.BookDoesntExistException;
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

    @NotNull
    public static ObservableList<Book> getBooks() {
        ObservableList<Book> books = FXCollections.observableArrayList();
        for (Book book : bookRepository.find()) {
            books.add(new Book(book.getTitle(), book.getAuthor(), book.getPrice(), book.getPageNumber(), book.getGenre()));
        }
        return books;
    }
}


