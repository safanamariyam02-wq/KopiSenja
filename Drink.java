// Drink class: represents a drink sold at Kopi Senja, with its details,
// price, quantity and availability. All attributes are private (encapsulation).

public class Drink {

    // Seven private attributes to store drink information.
    private String drinkID;       // Stores the unique drink ID.
    private String drinkName;     // Stores the name of the drink.
    private double price;         // Stores the price of the drink.
    private String size;          // Stores the drink size.
    private String temperature;   // Stores Hot or Iced.
    private int quantity;         // Stores the quantity ordered.
    private boolean available;    // Stores drink availability.

    public Drink() {    // Default constructor initializes a drink with default values.
        this("D000", "Unknown", 0.0,
             "Medium", "Iced", 1, false);
    }

    public Drink(String drinkID, String drinkName,
                 double price, String size,             // Parameterized constructor initializes a drink
                 String temperature, int quantity,      // using values provided when the object is created.
                 boolean available) {

        // Assigns parameter values to the object's attributes.
        this.drinkID = drinkID;
        this.drinkName = drinkName;
        this.price = price;
        this.size = size;
        this.temperature = temperature;
        this.quantity = quantity;
        this.available = available;
    }

    // Getter methods retrieve private attribute values.

    public String getDrinkID() {
        return drinkID; // Returns the drink ID.
    }

    public String getDrinkName() {
        return drinkName; // Returns the drink name.
    }

    public double getPrice() {
        return price; // Returns the drink price.
    }

    public String getSize() {
        return size; // Returns the drink size.
    }

    public String getTemperature() {
        return temperature; // Returns Hot or Iced.
    }

    public int getQuantity() {
        return quantity; // Returns the quantity ordered.
    }

    public boolean isAvailable() {
        return available; // Returns the availability status.
    }

    // Setter methods modify private attribute values.

    public void setDrinkID(String drinkID) {
        this.drinkID = drinkID; // Updates the drink ID.
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName; // Updates the drink name.
    }

    public void setPrice(double price) {

        // Checks whether the price is zero or positive.
        if (price >= 0) {
            this.price = price; // Accepts a valid price.
        } else {
            this.price = 0; // Prevents a negative price.
        }
    }

    public void setSize(String size) {
        this.size = size; // Updates the drink size.
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature; // Updates Hot or Iced.
    }

    public void setQuantity(int quantity) {

        // Checks whether the quantity is zero or positive.
        if (quantity >= 0) {
            this.quantity = quantity; // Accepts a valid quantity.
        } else {
            this.quantity = 0; // Prevents a negative quantity.
        }
    }

    public void setAvailable(boolean available) {
        this.available = available; // Updates availability.
    }

    // Calculates the total drink price.
    public double calculateTotalPrice() {

        // Multiplies the drink price by its quantity.
        return price * quantity;
    }

    // Checks drink availability.
    public void checkAvailability() {

        // Displays a message based on availability status.
        if (available) {
            System.out.println(drinkName + " is available.");
        } else {
            System.out.println(drinkName + " is unavailable.");
        }
    }
}
