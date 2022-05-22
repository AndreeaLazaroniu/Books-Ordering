import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.loose.fis.sre.model.Book;

public class BookTest {
    @Test
    public void getTitleTest() {
        Book b = new Book("Title", "author", "price", "pageNumber", "genre");
        Assertions.assertEquals("Title", b.getTitle());
    }

    @Test
    public void getAuthorTest() {
        Book b = new Book("Title", "author", "price", "pageNumber", "genre");
        Assertions.assertEquals("author", b.getAuthor());
    }

    @Test
    public void getPriceTest() {
        Book b = new Book("Title", "author", "price", "pageNumber", "genre");
        Assertions.assertEquals("price", b.getPrice());
    }

    @Test
    public void getPageNumberTest() {
        Book b = new Book("Title", "author", "price", "pageNumber", "genre");
        Assertions.assertEquals("pageNumber", b.getPageNumber());
    }

    @Test
    public void getGenreTest() {
        Book b = new Book("Title", "author", "price", "pageNumber", "genre");
        Assertions.assertEquals("genre", b.getGenre());
    }

    @Test
    public void setTitleTest() {
        Book b = new Book();
        String s = "title";
        b.setBookTitle(s);
        Assertions.assertEquals(s, b.getTitle());
    }

    @Test
    public void setAuthorTest() {
        Book b = new Book();
        String s = "author";
        b.setAuthor(s);
        Assertions.assertEquals(s, b.getAuthor());
    }

    @Test
    public void setPriceTest() {
        Book b = new Book();
        String s = "price";
        b.setPrice(s);
        Assertions.assertEquals(s, b.getPrice());
    }

    @Test
    public void setPageNumberTest() {
        Book b = new Book();
        String s = "pageNumber";
        b.setPageNumber(s);
        Assertions.assertEquals(s, b.getPageNumber());
    }

    @Test
    public void setGenreTest() {
        Book b = new Book();
        String s = "genre";
        b.setGenre(s);
        Assertions.assertEquals(s, b.getGenre());
    }

    @Test
    public void equalsTest1() {
        Book b1 = new Book();
        Book b2 = new Book();
        Assertions.assertEquals(true, b1.equals(b2));
    }

    @Test
    public void equalsTest2() {
        Book b1 = new Book("Title1", "author1", "price1", "pageNumber1", "genre1");
        Book b2 = new Book("Title2", "author2", "price2", "pageNumber2", "genre2");
        Assertions.assertEquals(false, b1.equals(b2));
    }

    @Test
    public void hashCodeTest1() {
        Book b = new Book("Title", "author", "price", "pageNumber", "genre");
        Assertions.assertEquals(-2042632799 ,b.hashCode());
    }

    @Test
    public void hashCodeTest2() {
        Book b = new Book();
        Assertions.assertEquals(0 ,b.hashCode());
    }
}