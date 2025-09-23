import java.util.Scanner;
public class FeetConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter distance in feet: ");
        double feet = input.nextDouble();
        double yards = feet / 3;
        double miles = yards / 1760;
        System.out.println(feet + " feet is equal to " + yards +
                " yards and " + miles + " miles");
    }
}