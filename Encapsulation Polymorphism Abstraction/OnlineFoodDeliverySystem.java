package Encapsulation_Polymorphism_Abstraction;
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    // Constructor
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Encapsulation: Getters only (order details should not be directly modified)
    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price per unit: " + price);
        System.out.println("Quantity: " + quantity);
    }

    // Abstract method
    public abstract double calculateTotalPrice();
}

// Interface Discountable
interface Discountable {
    double applyDiscount(double totalAmount);
    String getDiscountDetails();
}

// VegItem subclass
class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity(); // No extra charge
    }

    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount * 0.90; // 10% discount
    }

    @Override
    public String getDiscountDetails() {
        return "10% discount applied on Veg items.";
    }
}

// NonVegItem subclass
class NonVegItem extends FoodItem implements Discountable {
    private double nonVegCharge = 20; // additional charge per item

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() + nonVegCharge) * getQuantity();
    }

    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount * 0.95; // 5% discount
    }

    @Override
    public String getDiscountDetails() {
        return "5% discount applied on Non-Veg items.";
    }
}

public class OnlineFoodDeliverySystem {
    // Polymorphism: process different food items
    public static void processOrder(FoodItem[] items) {
        double grandTotal = 0;

        for (FoodItem item : items) {
            item.getItemDetails();
            double total = item.calculateTotalPrice();
            System.out.println("Total before discount: " + total);

            if (item instanceof Discountable) {
                Discountable d = (Discountable) item;
                double discountedPrice = d.applyDiscount(total);
                System.out.println(d.getDiscountDetails());
                System.out.println("Total after discount: " + discountedPrice);
                grandTotal += discountedPrice;
            } else {
                grandTotal += total;
            }

            System.out.println("----------------------");
        }

        System.out.println("Final Grand Total: " + grandTotal);
    }

    public static void main(String[] args) {
        FoodItem[] order = {
            new VegItem("Paneer Butter Masala", 150, 2),
            new NonVegItem("Chicken Biryani", 200, 3)
        };

        processOrder(order);
    }
}
