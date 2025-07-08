package com.fawry;

import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.fawry.Services.Interfaces.IDeliveryService;
import com.fawry.Services.MailService;
import com.fawry.Services.NoOpDeliveryService;
import com.fawry.Services.ShippingService;
import com.fawry.model.BookRelated.Abstraction.IEmailable;
import com.fawry.model.BookRelated.Abstraction.IPricable;
import com.fawry.model.BookRelated.Abstraction.IProduct;
import com.fawry.model.BookRelated.Abstraction.IShippable;
import com.fawry.model.BookRelated.Abstraction.IStockable;

public class QuantumBookStore {
    private final Map<String, IProduct> inventory = new HashMap<>();
    private final IDeliveryService shippingSvc = new ShippingService();
    private final IDeliveryService mailSvc     = new MailService();
    private final IDeliveryService noOpSvc     = new NoOpDeliveryService();


    public void addBook(IProduct book) {
        inventory.put(book.getIsbn(), book);
    }


    public List<IProduct> removeOutdated(int olderThanYears) {
        int cutoff = Year.now().getValue() - olderThanYears;
        List<IProduct> removed = new ArrayList<>();
        Iterator<IProduct> it = inventory.values().iterator();
        while (it.hasNext()) {
            IProduct b = it.next();
            if (b.getYearPublished() < cutoff) {
                removed.add(b);
                it.remove();
                System.out.printf("Quantum book store: Removed outdated \"%s\" (%d)%n",b.getTitle(), b.getYearPublished());
            }
        }
        return removed;
    }

    
    public double buyBook(String isbn, int qty, String email, String address) {
        IProduct raw = inventory.get(isbn);
        if (raw == null) {
            throw new IllegalArgumentException("Book not found: " + isbn);
        }

        if (!(raw instanceof IPricable)) {
            throw new UnsupportedOperationException("This product is not for sale: " + raw.getTitle());
        }
        IPricable priced = (IPricable) raw;

        if (raw instanceof IStockable) {
            IStockable stockable = (IStockable) raw;
            if (stockable.getQuantity() < qty) {
                throw new UnsupportedOperationException("Insufficient stock for ISBN: " + isbn);
            }
            stockable.setQuantity(stockable.getQuantity() - qty);
        }

        double total = priced.getPrice() * qty;

        IDeliveryService svc = chooseDelivery(raw);
        String dest = (raw instanceof IEmailable)? email: address;
        svc.deliver(raw, qty, dest);

        System.out.printf("Quantum book store: Sale complete – paid %.2f%n", total);
        return total;
    }

    private IDeliveryService chooseDelivery(IProduct b) {
        if (b instanceof IShippable) {
            return shippingSvc;
        }
        if (b instanceof IEmailable) {
            return mailSvc;
        }
        return noOpSvc;
    }
}
