
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Product {
    int id;
    String name;
    int quantity;
    double price;

    Product(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    void display() {
        System.out.println(id + "\t" + name + "\t"
                + quantity + "\t" + price);
    }
}

public class InventoryTracker {

    static ArrayList<Product> inventory = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);


    static void addProduct() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        inventory.add(new Product(id, name, quantity, price));

        System.out.println("Product added successfully!");
    }


    static void displayProducts() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty!");
            return;
        }

        System.out.println("\nID\tName\tQuantity\tPrice");

        for (Product p : inventory) {
            p.display();
        }
    }


    static void searchProduct() {
        System.out.print("Enter Product ID to search: ");
        int id = sc.nextInt();

        for (Product p : inventory) {
            if (p.id == id) {
                System.out.println("Product Found!");
                p.display();
                return;
            }
        }

        System.out.println("Product not found!");
    }


    static void sortByPrice() {
        Collections.sort(inventory,
            Comparator.comparingDouble(p -> p.price));

        System.out.println("Products sorted by price!");
        displayProducts();
    }


    static void sortByName() {
        Collections.sort(inventory,
            Comparator.comparing(p -> p.name.toLowerCase()));

        System.out.println("Products sorted by name!");
        displayProducts();
    }


    static void updateQuantity() {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        for (Product p : inventory) {
            if (p.id == id) {
                System.out.print("Enter New Quantity: ");
                p.quantity = sc.nextInt();

                System.out.println("Quantity updated!");
                return;
            }
        }

        System.out.println("Product not found!");
    }


    static void deleteProduct() {
        System.out.print("Enter Product ID to delete: ");
        int id = sc.nextInt();

        for (Product p : inventory) {
            if (p.id == id) {
                inventory.remove(p);
                System.out.println("Product deleted!");
                return;
            }
        }

        System.out.println("Product not found!");
    }


    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== SIMPLE INVENTORY TRACKER =====");
            System.out.println("1. Add Product");
            System.out.println("2. Display Products");
            System.out.println("3. Search Product");
            System.out.println("4. Sort by Price");
            System.out.println("5. Sort by Name");
            System.out.println("6. Update Quantity");
            System.out.println("7. Delete Product");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addProduct();
                    break;

                case 2:
                    displayProducts();
                    break;

                case 3:
                    searchProduct();
                    break;

                case 4:
                    sortByPrice();
                    break;

                case 5:
                    sortByName();
                    break;

                case 6:
                    updateQuantity();
                    break;

                case 7:
                    deleteProduct();
                    break;

                case 8:
                    System.out.println("Thank you for using Inventory Tracker!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 8);

        sc.close();
    }
}
