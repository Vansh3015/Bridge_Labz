package Encapsulation_Polymorphism_Abstraction;
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    // Constructor
    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    // Encapsulation: Getters & Setters
    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    protected void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    protected void setRatePerKm(double ratePerKm) {
        this.ratePerKm = ratePerKm;
    }

    // Concrete method
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per Km: " + ratePerKm);
    }

    // Abstract method
    public abstract double calculateFare(double distance);
}

// Interface GPS
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Subclass Car
class Car extends Vehicle implements GPS {
    private String currentLocation;

    public Car(String vehicleId, String driverName, double ratePerKm, String initialLocation) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = initialLocation;
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance; // normal fare
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        currentLocation = newLocation;
        System.out.println("Car location updated to: " + currentLocation);
    }
}

// Subclass Bike
class Bike extends Vehicle implements GPS {
    private String currentLocation;

    public Bike(String vehicleId, String driverName, double ratePerKm, String initialLocation) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = initialLocation;
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance * 0.8; // Bikes are 20% cheaper
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        currentLocation = newLocation;
        System.out.println("Bike location updated to: " + currentLocation);
    }
}

// Subclass Auto
class Auto extends Vehicle implements GPS {
    private String currentLocation;

    public Auto(String vehicleId, String driverName, double ratePerKm, String initialLocation) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = initialLocation;
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance * 0.9; // Autos are 10% cheaper
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        currentLocation = newLocation;
        System.out.println("Auto location updated to: " + currentLocation);
    }
}
public class RideHailingApp {
    // Polymorphism: process all vehicles
    public static void processRides(Vehicle[] vehicles, double distance) {
        for (Vehicle v : vehicles) {
            v.getVehicleDetails();
            System.out.println("Current Fare for " + distance + " km: ₹" + v.calculateFare(distance));

            if (v instanceof GPS) {
                GPS gpsVehicle = (GPS) v;
                System.out.println("Current Location: " + gpsVehicle.getCurrentLocation());
                gpsVehicle.updateLocation("Downtown"); // Update location
                System.out.println("Updated Location: " + gpsVehicle.getCurrentLocation());
            }

            System.out.println("-------------------------");
        }
    }

    public static void main(String[] args) {
        Vehicle car = new Car("C101", "Alice", 15, "Airport");
        Vehicle bike = new Bike("B202", "Bob", 10, "Mall");
        Vehicle auto = new Auto("A303", "Charlie", 12, "Station");

        Vehicle[] vehicles = {car, bike, auto};
        processRides(vehicles, 10); // calculate fares for 10 km ride
    }
}
