// package com.bridgelabz.oops.inbuiltfunction;

class Book {
    private static String libraryName;
    private String title;
    private String author;
    private final String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public static void setLibraryName(String name) {
        libraryName = name;
    }

    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    public void displayBookDetails() {
        System.out.printf("Title: %s%nAuthor: %s%nISBN: %s%n", title, author, isbn);
    }
}

public class Library {
    public static void main(String[] args) {
        Book.setLibraryName("Egmore Library");
        Book.displayLibraryName();

        Book book1 = new Book("Effective Java", "Joshua Bloch", "978-0134685991");
        book1.displayBookDetails();
    }
}