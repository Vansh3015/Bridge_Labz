import java.util.ArrayList;
import java.util.List;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void displayProduct() {
        System.out.println("Product: " + name + ", Price: $" + price);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Order {
    private String orderId;
    private List<Product> products = new ArrayList<>();

    public Order(String orderId) {
        this.orderId = orderId;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void displayOrder() {
        System.out.println("Order ID: " + orderId);
        for (Product p : products) {
            p.displayProduct();
        }
    }

    public double getTotalAmount() {
        double total = 0;
        for (Product p : products) {
            total += p.getPrice();
        }
        return total;
    }
}

class Customer {
    private String name;
    private List<Order> orders = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println(name + " placed order: " + order.orderId);
    }

    public void displayCustomerOrders() {
        System.out.println("Customer: " + name);
        for (Order o : orders) {
            o.displayOrder();
            System.out.println("Total Amount: $" + o.getTotalAmount());
            System.out.println();
        }
    }
}

public class E_commerce_Platforms {
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 1200.00);
        Product p2 = new Product("Smartphone", 800.00);
        Product p3 = new Product("Headphones", 150.00);

        Order order1 = new Order("O1001");
        order1.addProduct(p1);
        order1.addProduct(p3);

        Order order2 = new Order("O1002");
        order2.addProduct(p2);
        order2.addProduct(p3);

        Customer customer = new Customer("Alice");
        customer.placeOrder(order1);
        customer.placeOrder(order2);

        customer.displayCustomerOrders();
    }
}
