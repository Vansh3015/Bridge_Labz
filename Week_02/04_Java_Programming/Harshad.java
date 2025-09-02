import java.util.Scanner;
public class Harshad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int original = num, sum = 0;
        while (original != 0) {
            sum += original % 10;
            original /= 10;
        }
        if (num % sum == 0)
            System.out.println(num + " is a Harshad Number");
        else
            System.out.println(num + " is NOT a Harshad Number");
        sc.close();
    }
}