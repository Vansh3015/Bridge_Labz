import java.util.ArrayList;
import java.util.Arrays;

public class NumberChecker {

    public static int countDigits(long n) {
        n = Math.abs(n);
        if (n == 0) return 1;
        int c = 0;
        while (n > 0) { c++; n /= 10; }
        return c;
    }

    public static int[] digitsArray(long n) {
        n = Math.abs(n);
        int len = countDigits(n);
        int[] d = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            d[i] = (int)(n % 10);
            n /= 10;
        }
        return d;
    }

    public static boolean isDuck(long n) {
        int[] d = digitsArray(n);
        for (int digit : d) if (digit == 0) return true;
        return false;
    }

    public static boolean isArmstrong(long n) {
        int[] d = digitsArray(n);
        int p = d.length;
        long sum = 0;
        for (int v : d) sum += Math.pow(v, p);
        return sum == n;
    }

    public static int[] largestAndSecondLargest(int[] arr) {
        int largest = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int v : arr) {
            if (v > largest) { second = largest; largest = v; }
            else if (v > second && v != largest) second = v;
        }
        return new int[] { largest, second };
    }

    public static int[] smallestAndSecondSmallest(int[] arr) {
        int smallest = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int v : arr) {
            if (v < smallest) { second = smallest; smallest = v; }
            else if (v < second && v != smallest) second = v;
        }
        return new int[] { smallest, second };
    }

    // Additional utility methods for later sections
    public static int sumDigits(long n) {
        int[] d = digitsArray(n);
        int s = 0;
        for (int v : d) s += v;
        return s;
    }

    public static long sumSquaresOfDigits(long n) {
        int[] d = digitsArray(n);
        long s = 0;
        for (int v : d) s += (long)Math.pow(v, 2);
        return s;
    }

    public static boolean isHarshad(long n) {
        int s = sumDigits(n);
        if (s == 0) return false;
        return n % s == 0;
    }

    public static int[][] digitFrequency(long n) {
        int[] d = digitsArray(n);
        int[] freq = new int[10];
        for (int v : d) freq[v]++;
        int[][] out = new int[10][2];
        for (int i = 0; i < 10; i++) {
            out[i][0] = i;
            out[i][1] = freq[i];
        }
        return out;
    }

    public static int[] reverseDigitsArray(int[] arr) {
        int[] r = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < r.length / 2; i++) {
            int tmp = r[i]; r[i] = r[r.length - 1 - i]; r[r.length - 1 - i] = tmp;
        }
        return r;
    }

    public static boolean arraysEqual(int[] a, int[] b) {
        return Arrays.equals(a, b);
    }

    public static boolean isPalindrome(long n) {
        int[] d = digitsArray(n);
        int[] r = reverseDigitsArray(d);
        return arraysEqual(d, r);
    }

    public static boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0) return false;
        for (long i = 3; i*i <= n; i += 2) if (n % i == 0) return false;
        return true;
    }

    public static boolean isNeon(long n) {
        long sq = n * n;
        return sumDigits(sq) == n;
    }

    public static boolean isSpy(long n) {
        int[] d = digitsArray(n);
        long sum = 0, prod = 1;
        for (int v : d) { sum += v; prod *= v; }
        return sum == prod;
    }

    public static boolean isAutomorphic(long n) {
        long sq = n * n;
        String s = Long.toString(n);
        String sqs = Long.toString(sq);
        return sqs.endsWith(s);
    }

    public static boolean isBuzz(long n) {
        return n % 7 == 0 || Math.abs(n) % 10 == 7;
    }

    public static long factorial(int n) {
        long f = 1;
        for (int i = 2; i <= n; i++) f *= i;
        return f;
    }

    public static boolean isPerfect(long n) {
        if (n <= 1) return false;
        long s = 1;
        for (long i = 2; i*i <= n; i++) {
            if (n % i == 0) {
                s += i;
                long j = n / i;
                if (j != i) s += j;
            }
        }
        return s == n;
    }

    public static String abundanceType(long n) {
        if (n <= 1) return "neither";
        long s = 1;
        for (long i = 2; i*i <= n; i++) {
            if (n % i == 0) {
                s += i;
                long j = n / i;
                if (j != i) s += j;
            }
        }
        if (s == n) return "perfect";
        if (s > n) return "abundant";
        return "deficient";
    }

    public static boolean isStrong(long n) {
        int[] d = digitsArray(n);
        long s = 0;
        for (int v : d) s += factorial(v);
        return s == n;
    }

    public static long[] factors(long n) {
        ArrayList<Long> list = new ArrayList<>();
        for (long i = 1; i*i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
                long j = n / i;
                if (j != i) list.add(j);
            }
        }
        long[] arr = new long[list.size()];
        for (int i = 0; i < list.size(); i++) arr[i] = list.get(i);
        Arrays.sort(arr);
        return arr;
    }

    // demo method to show multiple checks
    public static void demo(long n) {
        System.out.println("Number: " + n);
        System.out.println("Digits: " + Arrays.toString(digitsArray(n)));
        System.out.println("Is Duck? " + isDuck(n));
        System.out.println("Is Armstrong? " + isArmstrong(n));
        System.out.println("Is Harshad? " + isHarshad(n));
        System.out.println("Is Prime? " + isPrime(n));
        System.out.println("Is Palindrome? " + isPalindrome(n));
        System.out.println("Is Spy? " + isSpy(n));
        System.out.println("Is Buzz? " + isBuzz(n));
        System.out.println("Abundance Type: " + abundanceType(n));
    }
}
