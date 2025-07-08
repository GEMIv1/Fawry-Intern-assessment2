package com.fawry;

import com.fawry.model.BookRelated.Concrete.DemoBook;
import com.fawry.model.BookRelated.Concrete.Ebook;
import com.fawry.model.BookRelated.Concrete.PaperBook;

public class QuantumBookStoreTest {
    public static void main(String[] args) {
        QuantumBookStore store = new QuantumBookStore();

        PaperBook paperBook = new PaperBook("ISBN-1", "c++", "Ahmed", "c++ by Ahmed", 2017,400.0, 1.5, 10 );

        Ebook eBook = new Ebook("ISBN-2", "java", "gemi", "Java by gemi", 2018,"pdf", 200.0);

        DemoBook demoBook = new DemoBook("ISBN-3", "Design Patterns", "Design by ahmed kamel", "For display only", 1994);

        store.addBook(paperBook);
        store.addBook(eBook);
        store.addBook(demoBook);

        System.out.println("\nRemoving outdated books (> 25 years old):");
        store.removeOutdated(25);

        System.out.println("\nBuying PaperBook:");
        store.buyBook("ISBN-1", 2, "ahmedPaperBook@example.com", "mokkatem");

        System.out.println("\nBuying EBook:");
        store.buyBook("ISBN-2", 1, "gemiEbook@example.com", "N/A");

        System.out.println("\nTrying to buy DemoBook:");
        try {
            store.buyBook("ISBN-3", 1, "ahmedKamelDemo@example.com", "N/A");
        } catch (Exception e) {
            System.out.println("Quantum book store: ERROR – " + e.getMessage());
        }
    }
}
