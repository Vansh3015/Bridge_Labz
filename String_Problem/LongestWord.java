public class LongestWord {
    public static void main(String[] args) {
        String sentence = "Java is a powerful language";
        String[] words = sentence.split("\\s+");
        String longest = "";
        for (String word : words) {
            if (word.length() > longest.length()) longest = word;
        }
        System.out.println(longest);
    }
}