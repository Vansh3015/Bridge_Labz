import java.util.Scanner;
public class SplitStringWithLength {
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
    public static String[][] wordsWithLength(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(customLength(words[i]));
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        String[] words = customSplit(text);
        String[][] data = wordsWithLength(words);
        System.out.println("Word\tLength");
        for (String[] row : data) {
            System.out.println(row[0] + "\t" + Integer.parseInt(row[1]));
        }
    }
}