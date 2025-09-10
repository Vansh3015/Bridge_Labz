import java.util.Scanner;

public class TriangularParkRun {
    public static int calculateRounds(double a, double b, double c, double distance) {
        double perimeter = a + b + c;
        return (int)Math.ceil(distance / perimeter);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter side1: ");
        double a = sc.nextDouble();
        System.out.print("Enter side2: ");
        double b = sc.nextDouble();
        System.out.print("Enter side3: ");
        double c = sc.nextDouble();
        int rounds = calculateRounds(a, b, c, 5000);
        System.out.println("The athlete needs to complete " + rounds + " rounds to finish 5 km.");
    }
}
