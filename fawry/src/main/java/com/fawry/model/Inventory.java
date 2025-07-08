package com.fawry.model;

import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.fawry.model.BookRelated.Abstraction.IProduct;

public class Inventory {
    private final Map<String, IProduct> products = new HashMap<>();

    public void add(IProduct book) {
        products.put(book.getIsbn(), book);
    }

    public List<IProduct> removeOutdated(int olderThanYears) {
        int cutoff = Year.now().getValue() - olderThanYears;
        List<IProduct> removed = new ArrayList<>();
        for (Iterator<IProduct> it = products.values().iterator(); it.hasNext(); ) {
            IProduct b = it.next();
            if (b.getYearPublished() < cutoff) {
                removed.add(b);
                it.remove();
                System.out.printf("Quantum book store: Removed outdated %s%n", b.getTitle());
            }
        }
        return removed;
    }

    public IProduct findByIsbn(String isbn) {
        return products.get(isbn);
    }
}
