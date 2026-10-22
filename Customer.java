// Customer class: represents a Kopi Senja customer, with their personal details,
// membership status and loyalty points. All attributes are private (encapsulation).

public class Customer {

    // Seven private attributes to store customer information.
    private String customerID;    // Stores the unique customer ID.
    private String customerName;  // Stores the customer's name.
    private String phoneNumber;   // Stores the customer's phone number.
    private String email;         // Stores the customer's email address.
    private int age;              // Stores the customer's age.
    private boolean member;       // Stores the membership status.
    private int loyaltyPoints;    // Stores the accumulated loyalty points.

    // Default constructor initializes a customer with default values.
    public Customer() {
        this("C000", "Guest", "Not Provided",
             "Not Provided", 0, false, 0);
    }

    // Parameterized constructor initializes customer attributes
    // using the values provided when creating the object.
    public Customer(String customerID, String customerName,
                    String phoneNumber, String email,
                    int age, boolean member, int loyaltyPoints) {

        // Assigns parameter values to the object's attributes.
        this.customerID = customerID;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.age = age;
        this.member = member;
        this.loyaltyPoints = loyaltyPoints;
    }

    // Getter methods retrieve private customer information.

    public String getCustomerID() {
        return customerID; // Returns the customer ID.
    }

    public String getCustomerName() {
        return customerName; // Returns the customer name.
    }

    public String getPhoneNumber() {
        return phoneNumber; // Returns the phone number.
    }

    public String getEmail() {
        return email; // Returns the email address.
    }

    public int getAge() {
        return age; // Returns the customer's age.
    }

    public boolean isMember() {
        return member; // Returns the membership status.
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints; // Returns the loyalty points.
    }

    // Setter methods modify private customer information.

    public void setCustomerID(String customerID) {
        this.customerID = customerID; // Updates the ID.
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName; // Updates the name.
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber; // Updates the phone number.
    }

    public void setEmail(String email) {
        this.email = email; // Updates the email address.
    }

    public void setAge(int age) {

        // Checks whether the age is zero or positive.
        if (age >= 0) {
            this.age = age; // Accepts a valid age.
        } else {
            this.age = 0; // Prevents a negative age.
        }
    }

    public void setMember(boolean member) {
        this.member = member; // Updates the membership status.
    }

    public void setLoyaltyPoints(int loyaltyPoints) {

        // Checks whether loyalty points are zero or positive.
        if (loyaltyPoints >= 0) {
            this.loyaltyPoints = loyaltyPoints;
        } else {
            this.loyaltyPoints = 0; // Prevents negative points.
        }
    }

    // Calculates membership discount.
    public double calculateDiscount(double totalPrice) {

        // Members receive a 10% discount.
        if (member) {
            return totalPrice * 0.10;
        } else {
            return 0; // Non-members receive no discount.
        }
    }

    // Adds loyalty points after purchase.
    public void addLoyaltyPoints(double amountSpent) {

        // Checks if customer is a member and has spent money.
        if (member && amountSpent > 0) {

            // Calculates one point for every full RM10 spent.
            int pointsEarned = (int) (amountSpent / 10);

            // Adds earned points to existing loyalty points.
            loyaltyPoints += pointsEarned;
        }
    }
}
