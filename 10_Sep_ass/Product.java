//package com.bridgelabz.oops.inbuiltfunction;

public class Product {
    private static double discount = 0.0;
    private final String productID;
    private String productName;
    private double price;
    private int quantity;

    public Product(String productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public static void updateDiscount(double newDiscount) {
        if (newDiscount >= 0.0 && newDiscount <= 100.0) {
            discount = newDiscount;
        } else {
            System.err.println("Invalid discount percentage. Enter a value between 0 and 100.");
        }
    }

    public double getDiscountedPrice() {
        return price - (price * discount / 100);
    }

    public void displayProductDetails() {
        System.out.printf(
            "Product ID: %s%nProduct Name: %s%nPrice: $%.2f%nQuantity: %d%nDiscount: %.1f%%%nPrice after Discount: $%.2f%n%n",
            productID, productName, price, quantity, discount, getDiscountedPrice()
        );
    }

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
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

    public static void main(String[] args) {
        Product.updateDiscount(10.0);
        Product product1 = new Product("P001", "Laptop", 1200.00, 5);
        Product product2 = new Product("P002", "Smartphone", 800.00, 10);
        product1.displayProductDetails();
        product2.displayProductDetails();
    }
}