class Item {
    int itemCode;
    String itemName;
    double price;

    Item(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    void displayDetails(int quantity) {
        double total = price * quantity;
        System.out.println("Code: " + itemCode + ", Name: " + itemName + ", Price: " + price + ", Total: " + total);
    }

    public static void main(String[] args) {
        Item i = new Item(1001, "Laptop", 60000);
        i.displayDetails(2);
    }
}