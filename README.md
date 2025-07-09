# Quantum Bookstore

A simple Java console application demonstrating a bookstore management system, built as part of the Fawry Internship Assessment 2.  
---

## Architecture

### Model Layer

#### Book‑Related Classes

##### Abstraction

- **IProduct**  
  A generic contract for anything you can “sell.” Any new product type in the system (books, courses, gift cards, etc.) implements this interface.

- **Book**  
  An abstract base class that implements `IProduct` and holds the common fields and methods (ISBN, title, author, year, content) for all book‑type products.

- **IPricable**  
  Products that have a price implement this interface.

- **IEmailable**  
  Products delivered via email (e‑books, PDFs, etc.) implement this interface; exposes methods for file type and email payload.

- **IShippable**  
  Products that can be shipped (paperbacks, hardcovers, merch) implement this interface; exposes methods for weight and shipping calculations.

- **IStockable**  
  Products that track inventory levels implement this interface; exposes methods for stock quantity and restocking.

##### Concrete

- **Ebook**  
  Extends `Book`; implements `IEmailable` and `IPricable`. Represents a digital book delivered by email.

- **PaperBook**  
  Extends `Book`; implements `IShippable`, `IStockable`, and `IPricable`. Represents a physical book shipped to the customer.

- **DemoBook**  
  Extends `Book`; no delivery interfaces. A read‑only preview copy—cannot be purchased.

#### Inventory

- **Inventory**  
  Manages your products in memory.  
  - `add(IProduct)` — adds any product  
  - `removeOutdated(int years)` — removes all items published before (current year − years)  
  - `findByIsbn(String)` — looks up a product by its ISBN  
---

