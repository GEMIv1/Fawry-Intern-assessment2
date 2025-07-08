package com.fawry.model.BookRelated.Concrete;

import com.fawry.model.BookRelated.Abstraction.Book;
import com.fawry.model.BookRelated.Abstraction.IEmailable;
import com.fawry.model.BookRelated.Abstraction.IPricable;

public class Ebook extends Book implements IPricable, IEmailable{

    private double price;
    private String fileType;

    public Ebook(String isbn, String title, String author, String content,int year, String fileType ,double price) {
        super(isbn, title, author, content, year);
        this.price = price;
        this.fileType = fileType;
    } 

    @Override
    public void setPrice(double p) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getFileType() {
        return fileType;
    }

    @Override
    public void setFileType(String type) {
        this.fileType = type;
    }

}
