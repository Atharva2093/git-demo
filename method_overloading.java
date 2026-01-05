import java.util.Scanner;
import java.util.ArrayList;

class Book {
    String isbn;
    String title;
    String author;
    int quantity;

    Book(String isbn, String title, String author, int quantity) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    void display() {
        System.out.println(isbn + " | " + title + " | " + author + " | Qty: " + quantity);
    }
}

class BookInventory {
    ArrayList<Book> books = new ArrayList<>();

    // Add book - Method Overloading Example 1
    void addBook(String isbn, String title) {
        books.add(new Book(isbn, title, "Unknown", 1));
        System.out.println("✓ Added: " + title);
    }

    void addBook(String isbn, String title, String author, int quantity) {
        books.add(new Book(isbn, title, author, quantity));
        System.out.println("✓ Added: " + title + " by " + author);
    }

    // Search book - Method Overloading Example 2
    void searchBook(String isbn) {
        for (Book book : books) {
            if (book.isbn.equals(isbn)) {
                System.out.println("✓ Found:");
                book.display();
                return;
            }
        }
        System.out.println("✗ Book not found");
    }

    void searchByAuthor(String author) {
        System.out.println("Books by " + author + ":");
        for (Book book : books) {
            if (book.author.equalsIgnoreCase(author)) {
                book.display();
            }
        }
    }

    // Display inventory - Method Overloading Example 3
    void displayAll() {
        if (books.isEmpty()) {
            System.out.println("✗ No books in inventory");
            return;
        }
        System.out.println("\n===== ALL BOOKS =====");
        for (Book book : books) {
            book.display();
        }
        System.out.println("Total: " + books.size() + " books");
    }

    void displayByQuantity(int minQty) {
        System.out.println("\n===== Books with Qty >= " + minQty + " =====");
        for (Book book : books) {
            if (book.quantity >= minQty) {
                book.display();
            }
        }
    }

    // Update quantity - Method Overloading Example 4
    void updateQuantity(String isbn, int newQty) {
        for (Book book : books) {
            if (book.isbn.equals(isbn)) {
                book.quantity = newQty;
                System.out.println("✓ Quantity updated to " + newQty);
                return;
            }
        }
        System.out.println("✗ Book not found");
    }

    void updateQuantity(String isbn, int change, boolean add) {
        for (Book book : books) {
            if (book.isbn.equals(isbn)) {
                if (add) {
                    book.quantity += change;
                    System.out.println("✓ Added " + change + " books");
                } else {
                    book.quantity -= change;
                    System.out.println("✓ Removed " + change + " books");
                }
                return;
            }
        }
        System.out.println("✗ Book not found");
    }

    void removeBook(String isbn) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).isbn.equals(isbn)) {
                System.out.println("✓ Removed: " + books.get(i).title);
                books.remove(i);
                return;
            }
        }
        System.out.println("✗ Book not found");
    }
}

class BookInventorySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookInventory inventory = new BookInventory();
        
        // Add sample books
        System.out.println("Adding sample books...\n");
        inventory.addBook("101", "Java Programming");
        inventory.addBook("102", "Python Guide", "John Doe", 5);
        inventory.addBook("103", "Clean Code", "Robert Martin", 10);
        
        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book");
            System.out.println("3. Display Books");
            System.out.println("4. Update Quantity");
            System.out.println("5. Remove Book");
            System.out.println("6. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            
            if (choice == 1) {
                System.out.print("ISBN: ");
                String isbn = sc.nextLine();
                System.out.print("Title: ");
                String title = sc.nextLine();
                System.out.print("Author (press Enter to skip): ");
                String author = sc.nextLine();
                
                if (author.isEmpty()) {
                    inventory.addBook(isbn, title);
                } else {
                    System.out.print("Quantity: ");
                    int qty = sc.nextInt();
                    inventory.addBook(isbn, title, author, qty);
                }
                
            } else if (choice == 2) {
                System.out.println("1. Search by ISBN  2. Search by Author");
                int type = sc.nextInt();
                sc.nextLine();
                
                if (type == 1) {
                    System.out.print("ISBN: ");
                    inventory.searchBook(sc.nextLine());
                } else {
                    System.out.print("Author: ");
                    inventory.searchByAuthor(sc.nextLine());
                }
                
            } else if (choice == 3) {
                System.out.println("1. All Books  2. By Min Quantity");
                int type = sc.nextInt();
                
                if (type == 1) {
                    inventory.displayAll();
                } else {
                    System.out.print("Minimum Quantity: ");
                    inventory.displayByQuantity(sc.nextInt());
                }
                
            } else if (choice == 4) {
                System.out.print("ISBN: ");
                String isbn = sc.nextLine();
                System.out.println("1. Set New Qty  2. Add  3. Remove");
                int type = sc.nextInt();
                
                if (type == 1) {
                    System.out.print("New Quantity: ");
                    inventory.updateQuantity(isbn, sc.nextInt());
                } else {
                    System.out.print("Amount: ");
                    int amt = sc.nextInt();
                    inventory.updateQuantity(isbn, amt, type == 2);
                }
                
            } else if (choice == 5) {
                System.out.print("ISBN to remove: ");
                inventory.removeBook(sc.nextLine());
                
            } else if (choice == 6) {
                System.out.println("✓ Goodbye!");
                break;
            } else {
                System.out.println("✗ Invalid choice");
            }
        }
        
        sc.close();
    }
}