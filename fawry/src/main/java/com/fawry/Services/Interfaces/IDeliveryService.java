package com.fawry.Services.Interfaces;

import com.fawry.model.BookRelated.Abstraction.IProduct;

public interface IDeliveryService {
    void deliver(IProduct book, int quantity, String destination);
}

