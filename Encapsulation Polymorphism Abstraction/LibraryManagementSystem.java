package Encapsulation_Polymorphism_Abstraction;
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    private String borrower; // sensitive data (encapsulated)
    private boolean isAvailable;

    // Constructor
    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.isAvailable = true; // By default, available
    }

    // Encapsulation: Getters & Setters
    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    protected void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public String getBorrower() {
        return borrower;
    }

    protected void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No, borrowed by " + borrower));
    }

    // Abstract method
    public abstract int getLoanDuration();
}

// Interface Reservable
interface Reservable {
    void reserveItem(String borrowerName);
    void checkAvailability();
}

// Subclass Book
class Book extends LibraryItem implements Reservable {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 21; // Books can be borrowed for 21 days
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable()) {
            setBorrower(borrowerName);
            setAvailable(false);
            System.out.println(borrowerName + " reserved the Book: " + getTitle());
        } else {
            System.out.println("Book '" + getTitle() + "' is already borrowed.");
        }
    }

    @Override
    public void checkAvailability() {
        System.out.println("Book '" + getTitle() + "' availability: " + (isAvailable() ? "Available" : "Not Available"));
    }
}

// Subclass Magazine
class Magazine extends LibraryItem implements Reservable {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // Magazines can be borrowed for 7 days
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable()) {
            setBorrower(borrowerName);
            setAvailable(false);
            System.out.println(borrowerName + " reserved the Magazine: " + getTitle());
        } else {
            System.out.println("Magazine '" + getTitle() + "' is already borrowed.");
        }
    }

    @Override
    public void checkAvailability() {
        System.out.println("Magazine '" + getTitle() + "' availability: " + (isAvailable() ? "Available" : "Not Available"));
    }
}

// Subclass DVD
class DVD extends LibraryItem implements Reservable {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14; // DVDs can be borrowed for 14 days
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable()) {
            setBorrower(borrowerName);
            setAvailable(false);
            System.out.println(borrowerName + " reserved the DVD: " + getTitle());
        } else {
            System.out.println("DVD '" + getTitle() + "' is already borrowed.");
        }
    }

    @Override
    public void checkAvailability() {
        System.out.println("DVD '" + getTitle() + "' availability: " + (isAvailable() ? "Available" : "Not Available"));
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Create Library Items
        LibraryItem item1 = new Book("B101", "The Alchemist", "Paulo Coelho");
        LibraryItem item2 = new Magazine("M202", "National Geographic", "Various Authors");
        LibraryItem item3 = new DVD("D303", "Inception", "Christopher Nolan");

        // Store in array (Polymorphism)
        LibraryItem[] items = { item1, item2, item3 };

        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            if (item instanceof Reservable) {
                Reservable res = (Reservable) item;
                res.checkAvailability();
                res.reserveItem("John Doe");
                res.checkAvailability();
            }

            System.out.println("--------------------------");
        }
    }
}
