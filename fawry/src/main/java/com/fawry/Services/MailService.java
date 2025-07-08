package com.fawry.Services;


import com.fawry.Services.Interfaces.IDeliveryService;
import com.fawry.model.BookRelated.Abstraction.IProduct;

public class MailService implements IDeliveryService {
    @Override
    public void deliver(IProduct book, int quantity, String email) {
        System.out.printf("Quantum book store: Emailing %d copies of %s to %s%n",quantity, book.getTitle(), email);
    }

}


