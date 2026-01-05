import java.util.*;

class BookInventory {

    void add_book(String title){
        System.out.println("Write Book Name: " + title);
    }

    void add_book(String title, String author){
        System.out.println("Book Name Is: " + title + ", Write Author Name: " + author);
    }

    void add_book(String title, String author, int price){
        System.out.println("Book Name Is: " + title + ", Author Name Is: " + author + ", What Is The Price: " + price);
    }
}

public class book {
    public static void main(String args[]){
        BookInventory inventory = new BookInventory();
        Scanner sc = new Scanner(System.in);
        
        // Demonstrate method overloading
        inventory.add_book("Java Programming");
        inventory.add_book("Python Basics", "John Doe");
        inventory.add_book("Data Structures", "Jane Smith", 599);
        
        sc.close();
    }
}

