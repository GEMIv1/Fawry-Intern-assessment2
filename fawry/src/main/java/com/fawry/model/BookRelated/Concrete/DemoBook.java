package com.fawry.model.BookRelated.Concrete;

import com.fawry.model.BookRelated.Abstraction.Book;


public class DemoBook extends Book {
    public DemoBook(String isbn, String title, String author, String content, int yearPublished) {
        super(isbn, title, author, content, yearPublished);
    }
}
