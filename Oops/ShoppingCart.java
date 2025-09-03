import java.util.ArrayList;

class CartItem {
    String itemName;
    double price;
    int quantity;

    CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    double totalCost() {
        return price * quantity;
    }
}

class ShoppingCart {
    ArrayList<CartItem> items = new ArrayList<>();

    void addItem(CartItem item) {
        items.add(item);
    }

    void removeItem(String itemName) {
        items.removeIf(i -> i.itemName.equalsIgnoreCase(itemName));
    }

    void displayTotalCost() {
        double total = 0;
        for (CartItem i : items) {
            total += i.totalCost();
        }
        System.out.println("Total Cost: " + total);
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new CartItem("Shoes", 2000, 2));
        cart.addItem(new CartItem("Shirt", 1500, 1));
        cart.displayTotalCost();
        cart.removeItem("Shoes");
        cart.displayTotalCost();
    }
}