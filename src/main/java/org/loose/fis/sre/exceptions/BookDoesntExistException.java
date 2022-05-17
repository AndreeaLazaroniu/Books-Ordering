package org.loose.fis.sre.exceptions;

public class BookDoesntExistException extends Exception {

    private String title;

    public BookDoesntExistException(String title) {
        super(String.format("This book %d doesn't exist!", title));
        this.title = title;
    }

    public String getBookTitle() {
        return title;
    }
}
