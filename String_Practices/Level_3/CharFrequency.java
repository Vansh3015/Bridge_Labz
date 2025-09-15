import java.util.*;

public class CharFrequency {
    public static String[][] getFrequency(String text) {
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }
        List<String[]> list = new ArrayList<>();
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                list.add(new String[]{String.valueOf((char)i), String.valueOf(freq[i])});
            }
        }
        return list.toArray(new String[0][0]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text: ");
        String text = sc.nextLine();
        String[][] result = getFrequency(text);
        System.out.println("Character | Frequency");
        for (String[] row : result) {
            System.out.println(row[0] + "         | " + row[1]);
        }
    }
}