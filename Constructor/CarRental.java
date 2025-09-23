public class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double costPerDay = 50.0; // Example cost per day

    // Default constructor
    public CarRental() {
        this.customerName = "Unknown";
        this.carModel = "Generic";
        this.rentalDays = 1;
    }

    // Parameterized constructor
    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    public double calculateTotalCost() {
        return rentalDays * costPerDay;
    }

    public void display() {
        System.out.println("Customer: " + customerName + ", Car: " + carModel + 
                           ", Days: " + rentalDays + ", Total Cost: " + calculateTotalCost());
    }
}