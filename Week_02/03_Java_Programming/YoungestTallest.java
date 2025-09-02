import java.util.Scanner;
public class YoungestTallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter age of Amar: ");
        int age1 = sc.nextInt();
        System.out.print("Enter height of Amar: ");
        int h1 = sc.nextInt();
        System.out.print("Enter age of Akbar: ");
        int age2 = sc.nextInt();
        System.out.print("Enter height of Akbar: ");
        int h2 = sc.nextInt();
        System.out.print("Enter age of Anthony: ");
        int age3 = sc.nextInt();
        System.out.print("Enter height of Anthony: ");
        int h3 = sc.nextInt();

        int youngestAge = Math.min(age1, Math.min(age2, age3));
        if (youngestAge == age1)
            System.out.println("Youngest is Amar");
        else if (youngestAge == age2)
            System.out.println("Youngest is Akbar");
        else
            System.out.println("Youngest is Anthony");

        int tallest = Math.max(h1, Math.max(h2, h3));
        if (tallest == h1)
            System.out.println("Tallest is Amar");
        else if (tallest == h2)
            System.out.println("Tallest is Akbar");
        else
            System.out.println("Tallest is Anthony");
    }
}