//package Projects;

import java.util.ArrayList;
import java.util.Scanner;

import static Projects.InventoryManagement.addItem;

// Base class
class LibraryItems{
    private String id;
    private String publisher;

    // constructor..
    public LibraryItems(String id,String publisher){
        this.id = id;
        this.publisher = publisher;
    }
    //getters and setters (Encapsulation)

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String getPublisher() {
        return publisher;
    }
    // Displaying details...

    public void displayDetails(){
        System.out.print("ID: " + id + ", Publisher: " + publisher);
    }
}
//Subclass: Books

class Books extends LibraryItems{
    private String name;
    private String author;
    private String publicationDate;
    private int quantity;

    public Books(String id,String publisher,String name,String author,String publicationDate,int quantity){
        super(id, publisher);
        this.name = name;
        this.author = author;
        this.publicationDate = publicationDate;
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public String getAuthor() {
        return author;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }
    public String getPublicationDate() {
        return publicationDate;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getQuantity() {
        return quantity;
    }
    //Displaying Details

    public void displayDetails(){
        System.out.println("\n----- Book -----");
        super.displayDetails();
        System.out.print(", Name: " + name + ", Author: " + author + ", Publication Date: " + publicationDate+ ", Quantity: " + quantity);
    }
}

//Subclass: Magazine

class Magazine extends LibraryItems{
    private int issueNumber;
    private String month;
    private double rating;

    public Magazine(String id,String publisher,int issueNumber,String month,double rating){
        super(id, publisher);
        this.issueNumber = issueNumber;
        this.month = month;
        this.rating = rating;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }
    public int getIssueNumber() {
        return issueNumber;
    }

    public void setMonth(String month) {
        this.month = month;
    }
    public String getMonth() {
        return month;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
    public double getRating() {
        return rating;
    }

    //Displaying Details....
    public void displayDetails(){
        System.out.println("\n----- Magazine -----");
        super.displayDetails();
        System.out.print(", Issue Number: " + issueNumber + ", Publication Month: " + month + ", Rating: " + rating);
    }
}

public class LibraryManagement {
    private static ArrayList<LibraryItems> inventory = new ArrayList<>();


    public static void main(String[] args) {
        Scanner  get = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- Library Management System ---");
            System.out.println("Press 1. --> Add Item");
            System.out.println("Press 2. --> Display Library");
            System.out.println("Press 3. --> Update Publisher");
            System.out.println("Press 4. --> Search Item");
            System.out.println("Press 5. --> Exit");
            System.out.print("Enter your choice: ");
            choice = get.nextInt();
            switch (choice) {
                case 1:
                    addItem(get);
                    break;
                case 2:
                    displayItems();
                    break;
                case 3:
                    updatePublisher(get);
                    break;
                case 4:
                    searchItem(get);
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
    }
    //Method for Adding new Data...
    public static void addItem (Scanner get){
            System.out.print("Enter Item Type (1. Books , 2.Magazine): ");
            int type = get.nextInt();
            get.nextLine();
            System.out.print("Enter  Id: ");
            String id = get.nextLine();
            System.out.print("Enter Publisher Name: ");
            String publisher = get.nextLine();

            if (type == 1) {
                System.out.print("Enter Book Name: ");
                String name = get.nextLine();
                System.out.print("Enter Author Name: ");
                String author = get.nextLine();
                System.out.print("Publication Date: ");
                String publicationDate = get.nextLine();
                System.out.print("Enter Book Quantity: ");
                int quantity = get.nextInt();
                inventory.add(new Books(id,publisher,name,author,publicationDate,quantity));
            } else if (type == 2) {
                System.out.print("Enter Issue Number: ");
                int issueNumber = get.nextInt();
                get.nextLine();
                System.out.print("Enter Publication Month: ");
                String month = get.nextLine();
                System.out.print("Enter Magazine Rating: ");
                double rating = get.nextDouble();
                inventory.add(new Magazine(id,publisher,issueNumber,month,rating));
            } else {
                System.out.println("Invalid Item Type...");
            }
    }
    //Method for displaying Data...

    public static void displayItems(){
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("\n   Inventory Details    ");
        for (LibraryItems item : inventory) {
            item.displayDetails();
            System.out.println("\n--------------------------------");
        }
        }
    }
    // method for Update publisher

    public static void updatePublisher(Scanner get) {
        System.out.print("Enter Item ID to update Publisher: ");
        String id = get.next();
        get.nextLine();
        for (LibraryItems item : inventory) {
            if (item.getId().equals(id)) {
                System.out.print("Enter new Publisher: ");
                String publisher = get.nextLine();
                item.setPublisher(publisher);
                System.out.println("Publisher updated successfully!");
                return;
            }
        }
        System.out.println("Item not found.");
    }
    // Search for an item by ID
    public static void searchItem(Scanner scanner) {
        System.out.print("Enter Item ID to search: ");
        String id = scanner.next();
        for (LibraryItems item : inventory) {
            if (item.getId().equals(id)) {
                item.displayDetails();
                return;
            }
        }
        System.out.println("Item not found.");
    }
}