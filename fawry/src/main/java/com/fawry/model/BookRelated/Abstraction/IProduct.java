package com.fawry.model.BookRelated.Abstraction;

// I made this because if we have diffrenet products not just books
public interface IProduct {
    String getIsbn();
    void setIsbn(String isbn);

    String getTitle();
    void setTitle(String title);

    String getAuthor();
    void setAuthor(String author);

    int getYearPublished();
    void setYearPublished(int year);

    String getContent();
    void setContent(String content);
}
