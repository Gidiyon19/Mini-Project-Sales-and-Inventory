package miniprojectfull;

import java.util.List;
import java.util.Scanner;

public class InventorySystem {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();

        while (true) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    addProduct(productDAO);
                    break;
                case 2:
                    updateProduct(productDAO);
                    break;
                case 3:
                    displayInventory(productDAO);
                    break;
                case 4:
                    deleteProduct(productDAO);
                    break;
                case 5:
                    System.out.println("Exiting Inventory System. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n=== Inventory Sale and Purchase System ===");
        System.out.println("1. Add a new product");
        System.out.println("2. Update product details");
        System.out.println("3. Display inventory");
        System.out.println("4. Delete a product");
        System.out.println("5. Exit");
    }

    private static int getUserChoice() {
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        return choice;
    }

    private static void addProduct(ProductDAO productDAO) {
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        Product newProduct = new Product();
        newProduct.setProductName(productName);
        newProduct.setQuantity(quantity);
        newProduct.setPrice(price);

        productDAO.addProduct(newProduct);
        System.out.println("Product added successfully!");
    }

    private static void updateProduct(ProductDAO productDAO) {
        System.out.print("Enter the product ID to update: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Product productToUpdate = productDAO.getProductById(productId);

        if (productToUpdate == null) {
            System.out.println("Product with ID " + productId + " not found.");
            return;
        }

        System.out.print("Enter new product name: ");
        String productName = scanner.nextLine();

        System.out.print("Enter new quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter new price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        productToUpdate.setProductName(productName);
        productToUpdate.setQuantity(quantity);
        productToUpdate.setPrice(price);

        productDAO.updateProduct(productToUpdate);
        System.out.println("Product updated successfully!");
    }

    private static void deleteProduct(ProductDAO productDAO) {
        System.out.print("Enter the product ID to delete: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        productDAO.deleteProduct(productId);
        System.out.println("Product deleted successfully!");
    }

    private static void displayInventory(ProductDAO productDAO) {
        System.out.println("\n=== Inventory ===");
        for (Product product : productDAO.getAllProducts()) {
            System.out.println(product.getProductId() + " | " + product.getProductName() + " | Quantity: " + product.getQuantity() + " | Price: $" + product.getPrice());
        }
    }
}
