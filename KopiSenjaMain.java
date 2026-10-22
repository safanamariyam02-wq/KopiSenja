
import java.util.Scanner; // Imports the Scanner class to allow keyboard input.
public class KopiSenjaMain { // Main class that controls the coffee ordering system.

    public static void main(String[] args) { // Main method where program execution begins.

        Scanner input = new Scanner(System.in); // Creates a Scanner object to read user input.

        Drink drink1 = new Drink( // Creates the first Drink object with its details.
            "D001", "Iced Latte", 12.00,
            "Medium", "Iced", 1, true);

        Drink drink2 = new Drink( // Creates the second Drink object.
            "D002", "Cappuccino", 10.00,
            "Medium", "Hot", 1, true);

        Drink drink3 = new Drink( // Creates the third Drink object.
            "D003", "Americano", 8.00,
            "Medium", "Iced", 1, false);

        Customer customer = new Customer(); // Creates a Customer object using default constructor.

        System.out.println("==============================");
        System.out.println("       WELCOME TO");                    // Displays the welcome message.
        System.out.println("         KOPI SENJA");
        System.out.println("==============================");

        System.out.print("Enter your name: ");      // Asks the customer to enter their name.
        customer.setCustomerName(input.nextLine()); // Reads the name and updates it using the setter.

        System.out.print("Are you a member? (yes/no): "); // Asks whether the customer is a member.
        String membership = input.nextLine();   // Stores the customer's answer in a String variable.

        if (membership.equalsIgnoreCase("yes")) { // Checks membership status using if/else.
            customer.setMember(true); // Sets membership status to true.
        } else {
            customer.setMember(false); // Sets membership status to false.
        }

        double total = 0; // Stores the total price of all drinks ordered.
        int choice; // Declares an integer variable for the menu choice.
        do { // Starts a loop so customers can order multiple drinks.

            System.out.println("\n========== MENU ==========");
            System.out.printf("1. %-12s RM%.2f%n", drink1.getDrinkName(), drink1.getPrice());
            System.out.printf("2. %-12s RM%.2f%n", drink2.getDrinkName(), drink2.getPrice());
            System.out.printf("3. %-12s RM%.2f%n", drink3.getDrinkName(), drink3.getPrice());
            System.out.println("4. Checkout");
            System.out.println("==========================");

            System.out.print("Choose your drink: "); // Asks the customer to select a menu option.

            if (!input.hasNextInt()) {          // Checks whether the input is not a number.
                System.out.println("Please enter a number!");
                input.next();                   // Discards the invalid input.
                choice = 0;                     // Keeps the loop running.
                continue;                       // Goes back to show the menu again.
            }
            choice = input.nextInt(); // Reads the customer's menu choice.

            Drink selectedDrink = null; // Declares a Drink reference with no selected object.

            switch (choice) {   // Selects a drink based on the menu choice.

                case 1:                     // Selects the Iced Latte object.
                    selectedDrink = drink1;
                    break;                  // Exits the switch statement.

                case 2:         
                    selectedDrink = drink2; // Selects the Cappuccino object.
                    break;

                case 3:
                    selectedDrink = drink3; // Selects the Americano object.
                    break;

                case 4:                     // Displays a message before checkout.
                    System.out.println("Proceeding to checkout...");
                    break;

                default:                    // Displays an error for an invalid choice.
                    System.out.println("Invalid choice!");
            }

            if (selectedDrink != null) { // Checks whether a drink has been selected.

                if (selectedDrink.isAvailable()) { // Checks if the selected drink is available.

                    System.out.print("Enter quantity: "); // Asks for the number of drinks.
                    int quantity = input.nextInt(); // Reads the quantity entered by the customer.

                    if (quantity > 0) { // Ensures the quantity is greater than zero.

                        selectedDrink.setQuantity(quantity); // Updates quantity using the setter method.

                        double subtotal = // Calculates price using the Drink method.
                            selectedDrink.calculateTotalPrice(); 

                        total += subtotal;  // Adds the subtotal to the overall total.

                        System.out.println(
                            selectedDrink.getDrinkName()    // Displays the selected drink's name.
                            + " added to order.");

                        System.out.printf(
                            "Subtotal: RM%.2f%n", subtotal);    // Displays subtotal with two decimal places.

                    } else {
                        System.out.println(
                            "Quantity must be greater than 0."); // Rejects zero or negative quantities.
                    }

                } else {
                    selectedDrink.checkAvailability();  // Calls the method to show drink availability.
                }
            }

        } while (choice != 4);  // Repeats the menu until customer chooses checkout.

        double discount = customer.calculateDiscount(total);    // Calculates discount based on membership.
        double finalTotal = total - discount;                   // Calculates amount payable after discount.

        customer.addLoyaltyPoints(finalTotal);                  // Updates customer's loyalty points after purchase.

        System.out.println("\n==============================");
        System.out.println("         KOPI SENJA");
        System.out.println("           RECEIPT");               // Displays the receipt heading.
        System.out.println("==============================");

        System.out.println("Customer: "
                + customer.getCustomerName());      // Retrieves and displays the customer's name.

         if (customer.isMember()) {      // Checks membership status using if/else.
            System.out.println("Member: Yes"); // Displays customer membership using if/else.
        } else {
            System.out.println("Member: No");
        }                                       
        System.out.printf("Total: RM%.2f%n", total);            // Displays the original total price.
        System.out.printf("Discount: RM%.2f%n", discount);      // Displays the discount amount.
        System.out.printf("Final Total: RM%.2f%n", finalTotal); // Displays the final amount payable.

        System.out.println("Loyalty Points: "
                + customer.getLoyaltyPoints()); // Retrieves and displays updated loyalty points.

        System.out.println("==============================");
        System.out.println("Thank you for visiting Kopi Senja!");   // Displays a closing message.

        input.close();  // Closes the Scanner after input is complete.
    }
}
