import java.util.Scanner;
public class StringLengthDemo {
    public static int customLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
            return count;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.next();
        System.out.println("Custom length: " + customLength(str));
        System.out.println("Built-in length: " + str.length());
    }
}