import java.util.Scanner;
public class FizzBuzzArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        if (number <= 0) {
            System.out.println("Not a positive integer");
            return;
        }
        String[] arr = new String[number+1];
        for (int i = 1; i <= number; i++) {
            if (i % 3 == 0 && i % 5 == 0) arr[i] = "FizzBuzz";
            else if (i % 3 == 0) arr[i] = "Fizz";
            else if (i % 5 == 0) arr[i] = "Buzz";
            else arr[i] = String.valueOf(i);
        }
        for (int i = 1; i <= number; i++) {
            System.out.println("Position " + i + " = " + arr[i]);
        }
        sc.close();
    }
}