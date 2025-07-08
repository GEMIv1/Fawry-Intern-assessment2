package com.fawry.Services;

import com.fawry.Services.Interfaces.IDeliveryService;
import com.fawry.model.BookRelated.Abstraction.IProduct;

public class NoOpDeliveryService implements IDeliveryService {

    @Override
    public void deliver(IProduct book, int quantity, String destination) {
         System.out.printf("Quantum book store: “%s” is for display/demo only—no delivery action taken.%n",book.getTitle()
        );
    }

}
