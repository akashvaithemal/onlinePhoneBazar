import java.util.Scanner;

public class OnlineBazar {
    public static void main(String[] args) {
        System.out.println("Welcome to Online Phone Bazar!");

        // Product inventory
        String[] products = { "Product 1", "Product 2", "Product 3" };
        double[] prices = { 10.99, 24.99, 15.50 };

        // Shopping cart
        String[] cartItems = new String[10];
        double[] cartPrices = new double[10];
        int cartSize = 0;

        // User input
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. View Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // View Products
                    System.out.println("\nAvailable Products:");
                    for (int i = 0; i < products.length; i++) {
                        System.out.println((i + 1) + ". " + products[i] + " - $" + prices[i]);
                    }
                    break;

                case 2:
                    // Add Product to Cart
                    System.out.print("\nEnter product number to add to cart: ");
                    int productNum = scanner.nextInt();
                    if (productNum >= 1 && productNum <= products.length) {
                        cartItems[cartSize] = products[productNum - 1];
                        cartPrices[cartSize] = prices[productNum - 1];
                        cartSize++;
                        System.out.println("Product added to cart.");
                    } else {
                        System.out.println("Invalid product number.");
                    }
                    break;

                case 3:
                    // View Cart
                    System.out.println("\nShopping Cart:");
                    if (cartSize == 0) {
                        System.out.println("Your cart is empty.");
                    } else {
                        double total = 0;
                        for (int i = 0; i < cartSize; i++) {
                            System.out.println((i + 1) + ". " + cartItems[i] + " - $" + cartPrices[i]);
                            total += cartPrices[i];
                        }
                        System.out.println("Total: $" + total);
                    }
                    break;

                case 4:
                    // Checkout
                    System.out.println("\nCheckout:");
                    if (cartSize == 0) {
                        System.out.println("Your cart is empty. Nothing to checkout.");
                    } else {
                        double total = 0;
                        for (int i = 0; i < cartSize; i++) {
                            System.out.println((i + 1) + ". " + cartItems[i] + " - $" + cartPrices[i]);
                            total += cartPrices[i];
                        }
                        System.out.println("Total: $" + total);
                        System.out.println("Thank you for shopping with us! Your order has been placed.");

                        // Reset shopping cart
                        cartItems = new String[10];
                        cartPrices = new double[10];
                        cartSize = 0;
                    }
                    break;

                case 5:
                    // Exit
                    System.out.println("\nThank you for shopping with us! Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
                }
            }
        }
    }
        