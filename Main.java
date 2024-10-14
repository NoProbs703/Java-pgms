class Book {
   
    private String name;
    private String author;
    private double price;
    private int numPages;

    
    public Book(String name, String author, double price, int numPages) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.numPages = numPages;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    
    @Override
    public String toString() {
        return "Book{" +
                "Name='" + name + '\'' +
                ", Author='" + author + '\'' +
                ", Price=" + price +
                ", Number of Pages=" + numPages +
                '}';
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> books = new ArrayList<>();

        System.out.print("Enter the number of books: ");
        int n = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name of book " + (i + 1) + ": ");
            String name = scanner.nextLine();
            System.out.print("Enter author of book " + (i + 1) + ": ");
            String author = scanner.nextLine();
            System.out.print("Enter price of book " + (i + 1) + ": ");
            double price = scanner.nextDouble();
            System.out.print("Enter number of pages of book " + (i + 1) + ": ");
            int numPages = scanner.nextInt();
            scanner.nextLine();

            
            Book book = new Book(name, author, price, numPages);
            books.add(book);
        }

        
        System.out.println("\nDetails of the books:");
        for (Book book : books) {
            System.out.println(book);
        }

        scanner.close();
    }
}
