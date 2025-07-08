package com.fawry.Services;

import com.fawry.Services.Interfaces.IDeliveryService;
import com.fawry.model.BookRelated.Abstraction.IProduct;


public class ShippingService implements IDeliveryService {

    @Override
    public void deliver(IProduct book, int quantity, String address) {
        System.out.printf("Quantum book store: Shipping %d copies of %s to %s%n",quantity, book.getTitle(), address);
    }
    
}

