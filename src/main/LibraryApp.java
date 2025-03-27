package main;

import models.Book;
import services.LibraryManager;
import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        LibraryManager library = new LibraryManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Digital Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1: // Add Book
                    System.out.print("Enter Book ID: ");
                    String bookId = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Is the book available? (true/false): ");
                    boolean isAvailable = scanner.nextBoolean();
                    library.addBook(new Book(bookId, title, author, genre, isAvailable));
                    break;
                case 2: // View All Books
                    library.viewAllBooks();
                    break;
                case 3: // Search Book
                    System.out.print("Enter Book ID or Title: ");
                    String searchKey = scanner.nextLine();
                    Book foundBook = library.searchBook(searchKey);
                    System.out.println(foundBook != null ? foundBook : "Book not found.");
                    break;
                case 4: // Update Book
                    System.out.print("Enter Book ID to update: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Enter new Title (or press Enter to skip): ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new Author (or press Enter to skip): ");
                    String newAuthor = scanner.nextLine();
                    System.out.print("Enter new Genre (or press Enter to skip): ");
                    String newGenre = scanner.nextLine();
                    System.out.print("Is the book available? (true/false): ");
                    boolean newAvailability = scanner.nextBoolean();
                    library.updateBook(updateId, newTitle, newAuthor, newGenre, newAvailability);
                    break;
                case 5: // Delete Book
                    System.out.print("Enter Book ID to delete: ");
                    String deleteId = scanner.nextLine();
                    library.deleteBook(deleteId);
                    break;
                case 6: // Exit
                    System.out.println("Exiting Digital Library. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
