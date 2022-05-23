import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.loose.fis.sre.exceptions.TitleAlreadyExistsException;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.model.Book;
import org.loose.fis.sre.model.User;
import org.loose.fis.sre.services.FileSystemService;
import org.loose.fis.sre.services.BookService;
import org.loose.fis.sre.services.UserService;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.testfx.assertions.api.Assertions.assertThat;


public class BookServiceTest {

    public static final String TITLE = "title";
    public static final String AUTHOR = "author";
    public static final String PRICE = "price";
    public static final String PAGENUMBER = "pagenumber";
    public static final String GENRE = "Romance";

    public static final String TITLE2 = "title2";
    public static final String PRICE2 = "price2";

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before Class");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After Class");
    }

    @AfterEach
    void tearDown() {
        System.out.println("After each");
    }

    @BeforeEach
    void setUp() throws Exception {
        FileSystemService.APPLICATION_FOLDER = ".registration-example";
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomeFolder().toFile());
        BookService.initDatabase();
    }

    @Test
    void testDatabaseIsInitializedAndNoUserIsPersisted() {
        org.assertj.core.api.Assertions.assertThat(BookService.getBooks()).isNotNull();
        org.assertj.core.api.Assertions.assertThat(BookService.getBooks()).isEmpty();
    }

    @Test
    void testUserIsAddedToDatabase() throws TitleAlreadyExistsException {
        BookService.addBook(TITLE, AUTHOR, PRICE, PAGENUMBER, GENRE);
        assertThat(BookService.getBooks()).isNotEmpty();
        assertThat(BookService.getBooks()).size().isEqualTo(1);
        Book book = BookService.getBooks().get(0);
        assertThat(book).isNotNull();
        assertThat(book.getTitle()).isEqualTo(TITLE);
        assertThat(book.getAuthor()).isEqualTo(AUTHOR);
        assertThat(book.getPrice()).isEqualTo(PRICE);
        assertThat(book.getPageNumber()).isEqualTo(PAGENUMBER);
        assertThat(book.getGenre()).isEqualTo(GENRE);
    }

    @Test
    void testDeleteBook() throws TitleAlreadyExistsException{
        BookService.addBook(TITLE, AUTHOR, PRICE, PAGENUMBER, GENRE);
        assertThat(BookService.getBooks()).size().isEqualTo(1);
        BookService.deleteBook(TITLE);
        assertThat(BookService.getBooks()).size().isEqualTo(0);
    }

    @Test
    void testEditBook() throws TitleAlreadyExistsException{
        BookService.addBook(TITLE, AUTHOR, PRICE, PAGENUMBER, GENRE);
        assertThat(BookService.getBooks()).size().isEqualTo(1);
        BookService.editBook(TITLE, PRICE2);
        assertThat(BookService.getBooks()).size().isEqualTo(1);
        Book book = BookService.getBooks().get(0);
        assertThat(book.getPrice()).isEqualTo(PRICE2);
    }

    @Test
    void testGetBookPrice() throws TitleAlreadyExistsException{
        BookService.addBook(TITLE, AUTHOR, PRICE, PAGENUMBER, GENRE);
        org.assertj.core.api.Assertions.assertThat(BookService.getBookPrice(TITLE)).isEqualTo(PRICE);
    }

    @Test
    void testGetBookPrice2() throws TitleAlreadyExistsException{
        BookService.addBook(TITLE, AUTHOR, PRICE, PAGENUMBER, GENRE);
        org.assertj.core.api.Assertions.assertThat(BookService.getBookPrice(TITLE2)).isEqualTo("");
    }

    @Test
    void testBookCanNotBeAddedTwice() {
        assertThrows(TitleAlreadyExistsException.class, () -> {
            BookService.addBook(TITLE, AUTHOR, PRICE, PAGENUMBER, GENRE);
            BookService.addBook(TITLE, AUTHOR, PRICE, PAGENUMBER, GENRE);
        });
    }
}
