import java.util.Scanner;
public class SplitStringDemo {
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
    public static String[] customSplit(String str) {
        int len = customLength(str);
        int spaces = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') spaces++;
        }
        String[] words = new String[spaces + 1];
        int wordIndex = 0;
        String current = "";
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                words[wordIndex++] = current;
                current = "";
            } else {
                current += str.charAt(i);
            }
        }
        words[wordIndex] = current;
        return words;
    }
    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        String[] custom = customSplit(text);
        String[] builtin = text.split(" ");
        System.out.println("Comparison: " + compareArrays(custom, builtin));
    }
}