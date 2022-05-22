package org.loose.fis.sre.exceptions;

public class TitleAlreadyExistsException extends Exception{

    private String title;

    public TitleAlreadyExistsException(String title) {
        super(String.format("A book with the title %s already exists!", title));
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
