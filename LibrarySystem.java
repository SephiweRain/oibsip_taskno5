import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibrarySystem {

    // Book class to represent a book with title, author, and availability status.
    static class Book {
        String title;
        String author;
        boolean isAvailable;

        Book(String title, String author) {
            this.title = title;
            this.author = author;
            this.isAvailable = true; // Books are available by default
        }
    }

    // LibrarySystem class methods and data storage
    private final List<Book> books = new ArrayList<>();

    // Method to add a book to the library
    public void addBook(String title, String author) {
        books.add(new Book(title, author));
        System.out.println("Book added: " + title + " by " + author);
    }

    // Method to search for books by title
    public void searchBooks(String title) {
        System.out.println("Search results for '" + title + "':");
        for (Book book : books) {
            if (book.title.toLowerCase().contains(title.toLowerCase())) {
                System.out.println(" - " + book.title + " by " + book.author + " | Available: " + (book.isAvailable ? "Yes" : "No"));
            }
        }
    }

    // Method to issue a book to a user
    public void issueBook(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title) && book.isAvailable) {
                book.isAvailable = false;
                System.out.println("Book issued: " + book.title);
                return;
            }
        }
        System.out.println("Book not available or not found.");
    }

    // Method to return a book to the library
    public void returnBook(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title) && !book.isAvailable) {
                book.isAvailable = true;
                System.out.println("Book returned: " + book.title);
                return;
            }
        }
        System.out.println("Book not found or already returned.");
    }

    // Main method to run the LibrarySystem program
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Library System Commands: ADD, SEARCH, ISSUE, RETURN, EXIT");

        while (true) {
            System.out.print("Enter command: ");
            command = scanner.nextLine().trim().toUpperCase();

            switch (command) {
                case "ADD" -> {
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    library.addBook(title, author);
                }

                case "SEARCH" -> {
                    System.out.print("Enter title to search: ");
                    String title = scanner.nextLine();
                    library.searchBooks(title);
                }

                case "ISSUE" -> {
                    System.out.print("Enter title to issue: ");
                    String title = scanner.nextLine();
                    library.issueBook(title);
                }

                case "RETURN" -> {
                    System.out.print("Enter title to return: ");
                    String title = scanner.nextLine();
                    library.returnBook(title);
                }

                case "EXIT" -> {
                    System.out.println("Exiting Library System.");
                    scanner.close();
                    return;
                }

                default -> System.out.println("Invalid command. Try again.");
            }
        }
    }
}

