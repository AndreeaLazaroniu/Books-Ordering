package org.loose.fis.sre.model;

import org.dizitart.no2.objects.Id;

public class Book {
    @Id
    private String title;
    private String author;
    private String price;
    private String pageNumber;
    private String genre;

    public Book(String title, String author, String price, String pageNumber, String genre){
        this.title = title;
        this.author = author;
        this.price = price;
        this.pageNumber = pageNumber;
        this.genre = genre;
    }

    public Book() {
    }

    public String getTitle() { return title; }

    public void setBookTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }

    public void setAuthor(String author) { this.author = author; }

    public String getPrice() { return price; }

    public void setPrice(String price) { this.price = price; }

    public String getPageNumber() {return pageNumber; }

    public void setPageNumber(String pageNumber) { this.pageNumber = pageNumber; }

    public String getGenre() { return genre; }

    public void setGenre(String genre) { this.genre = genre; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        if (price != null ? !price.equals(book.price) : book.price != null) return false;
        if (pageNumber != null ? !pageNumber.equals(book.pageNumber) : book.pageNumber != null) return false;
        return genre != null ? genre.equals(book.genre) : book.genre == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (pageNumber != null ? pageNumber.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        return result;
    }

}
