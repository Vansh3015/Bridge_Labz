public class PalindromeCheck {
    public static void main(String[] args) {
        String str = "madam";
        int l = 0, r = str.length() - 1;
        boolean isPalindrome = true;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                isPalindrome = false;
                break;
            }
            l++;
            r--;
        }
        System.out.println(isPalindrome ? "Palindrome" : "Not Palindrome");
    }
}