package com.fawry.model.BookRelated.Abstraction;

public class Book implements IProduct {
    private String isbn;
    private String title;
    private String author;
    private String content;
    private int yearPublished;

    public Book(String isbn, String title, String author, String content, int yearPublished) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.content = content;
        this.yearPublished = yearPublished;
    }

    @Override
    public String getIsbn() {
        return isbn;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public int getYearPublished() {
        return yearPublished;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    

}
