//package Projects;

import java.util.ArrayList;
import java.util.Scanner;

// Base Class: ElectronicItem
class ElectronicItem {
    private String id;
    private String name;
    private double price;
    private int quantity;

    // Constructor
    public ElectronicItem(String id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters (Encapsulation)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Display item details
    public void displayDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Price: $" + price + ", Quantity: " + quantity);
    }
}

// Subclass: Laptop
class Laptop extends ElectronicItem {
    private String processor;

    public Laptop(String id, String name, double price, int quantity, String processor) {
        super(id, name, price, quantity);
        this.processor = processor;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Processor: " + processor);
    }
}

// Subclass: Mobile
class Mobile extends ElectronicItem {
    private String operatingSystem;

    public Mobile(String id, String name, double price, int quantity, String operatingSystem) {
        super(id, name, price, quantity);
        this.operatingSystem = operatingSystem;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Operating System: " + operatingSystem);
    }
}

// Main Class: Inventory Management
public class InventoryManagement {
    private static ArrayList<ElectronicItem> inventory = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Inventory Management System ---");
            System.out.println("1. Add Item");
            System.out.println("2. Display Inventory");
            System.out.println("3. Update Quantity");
            System.out.println("4. Search Item");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addItem(scanner);
                    break;
                case 2:
                    displayInventory();
                    break;
                case 3:
                    updateQuantity(scanner);
                    break;
                case 4:
                    searchItem(scanner);
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    // Add an item to the inventory
    public static void addItem(Scanner scanner) {
        System.out.println("Enter item type (1 for Laptop, 2 for Mobile): ");
        int type = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();

        if (type == 1) {
            scanner.nextLine(); // Consume newline
            System.out.print("Enter Processor: ");
            String processor = scanner.nextLine();
            inventory.add(new Laptop(id, name, price, quantity, processor));
        } else if (type == 2) {
            scanner.nextLine(); // Consume newline
            System.out.print("Enter Operating System: ");
            String os = scanner.nextLine();
            inventory.add(new Mobile(id, name, price, quantity, os));
        } else {
            System.out.println("Invalid item type.");
        }

        System.out.println("Item added successfully!");
    }

    // Display all items in the inventory
    public static void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("\n--- Inventory Details ---");
            for (ElectronicItem item : inventory) {
                item.displayDetails();
                System.out.println("--------------------------------");
            }
        }
    }

    // Update quantity of an item
    public static void updateQuantity(Scanner scanner) {
        System.out.print("Enter Item ID to update quantity: ");
        String id = scanner.next();
        for (ElectronicItem item : inventory) {
            if (item.getId().equals(id)) {
                System.out.print("Enter new quantity: ");
                int quantity = scanner.nextInt();
                item.setQuantity(quantity);
                System.out.println("Quantity updated successfully!");
                return;
            }
        }
        System.out.println("Item not found.");
    }

    // Search for an item by ID
    public static void searchItem(Scanner scanner) {
        System.out.print("Enter Item ID to search: ");
        String id = scanner.next();
        for (ElectronicItem item : inventory) {
            if (item.getId().equals(id)) {
                item.displayDetails();
                return;
            }
        }
        System.out.println("Item not found.");
    }
}

