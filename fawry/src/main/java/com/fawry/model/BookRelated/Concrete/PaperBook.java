package com.fawry.model.BookRelated.Concrete;

import com.fawry.model.BookRelated.Abstraction.Book;
import com.fawry.model.BookRelated.Abstraction.IPricable;
import com.fawry.model.BookRelated.Abstraction.IShippable;
import com.fawry.model.BookRelated.Abstraction.IStockable;

public class PaperBook extends Book implements IShippable, IStockable, IPricable{

    private double weight;
    private double price;
    private int quantity;

    public PaperBook(String isbn, String title, String contet ,String author, int year, double  weight, double price, int quantity) {
        super(isbn, title, author, contet, year);
        this.weight = weight;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public void setWeight(double w) {
        this.weight = w;
    }

    
    public void setQuantity(int q) {
        this.quantity = q;
    }

    @Override
    public void setPrice(double p) {
        this.price = p;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    
    public void reduceQuantity(int amount) {
        if (amount < 0 || amount > quantity) {
            throw new IllegalArgumentException("Invalid quantity to reduce");
        }
        quantity -= amount;
    }

}
