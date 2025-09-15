import java.util.Scanner;
public class ShortestLongestWord {
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
    public static int[] findShortestLongest(String[][] data) {
        int minIndex = 0, maxIndex = 0;
        for (int i = 1; i < data.length; i++) {
            int length = Integer.parseInt(data[i][1]);
            if (length < Integer.parseInt(data[minIndex][1])) minIndex = i;
            if (length > Integer.parseInt(data[maxIndex][1])) maxIndex = i;
        }
        return new int[]{minIndex, maxIndex};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        String[] words = customSplit(text);
        String[][] data = wordsWithLength(words);
        int[] result = findShortestLongest(data);
        System.out.println("Shortest: " + data[result[0]][0]);
        System.out.println("Longest: " + data[result[1]][0]);
    }
}