import java.util.Scanner;
public class ToUpperCaseDemo {
    public static String convertToUpperCase(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z') {
                c = (char)(c - 32);
            }
            result += c;
        }
        return result;
    }
    public static boolean compareUsingCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        String upper1 = convertToUpperCase(text);
        String upper2 = text.toUpperCase();
        System.out.println("Comparison: " + compareUsingCharAt(upper1, upper2));
    }
}