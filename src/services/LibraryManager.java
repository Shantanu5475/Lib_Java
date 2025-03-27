package services;

import models.Book;
import java.util.*;

public class LibraryManager {
    private Map<String, Book> bookCatalog = new HashMap<>();

    // Add a book
    public void addBook(Book book) {
        if (bookCatalog.containsKey(book.getBookId())) {
            throw new IllegalArgumentException("Book ID must be unique!");
        }
        bookCatalog.put(book.getBookId(), book);
        System.out.println("Book added successfully!");
    }

    // View all books
    public void viewAllBooks() {
        if (bookCatalog.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book book : bookCatalog.values()) {
                System.out.println(book);
            }
        }
    }

    // Search book by ID or Title
    public Book searchBook(String searchKey) {
        for (Book book : bookCatalog.values()) {
            if (book.getBookId().equalsIgnoreCase(searchKey) || book.getTitle().equalsIgnoreCase(searchKey)) {
                return book;
            }
        }
        return null;
    }

    // Update book details
    public void updateBook(String bookId, String newTitle, String newAuthor, String newGenre, Boolean availability) {
        if (!bookCatalog.containsKey(bookId)) {
            System.out.println("Book not found!");
            return;
        }
        
        // Get the existing book
        Book book = bookCatalog.get(bookId);
        
        // Keep old values if new ones are null or empty
        String updatedTitle = (newTitle != null && !newTitle.trim().isEmpty()) ? newTitle : book.getTitle();
        String updatedAuthor = (newAuthor != null && !newAuthor.trim().isEmpty()) ? newAuthor : book.getAuthor();
        String updatedGenre = (newGenre != null && !newGenre.trim().isEmpty()) ? newGenre : book.getGenre();
        Boolean updatedAvailability = (availability != null) ? availability : book.isAvailable(); 
        
        // Update the book in the catalog
        bookCatalog.put(bookId, new Book(bookId, updatedTitle, updatedAuthor, updatedGenre, updatedAvailability));
    
        System.out.println("Book updated successfully!");
    }
    
    // Delete a book
    public void deleteBook(String bookId) {
        if (bookCatalog.remove(bookId) != null) {
            System.out.println("Book removed successfully!");
        } else {
            System.out.println("Book not found!");
        }
    }
}
