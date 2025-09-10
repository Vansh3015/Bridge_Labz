import java.util.Arrays;

public class FactorUtils {

    public static int[] factors(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) if (n % i == 0) count++;
        int[] arr = new int[count];
        int idx = 0;
        for (int i = 1; i <= n; i++) if (n % i == 0) arr[idx++] = i;
        return arr;
    }

    public static int greatestFactor(int n) {
        int[] f = factors(n);
        return f[f.length - 1];
    }

    public static int sumOfFactors(int n) {
        int[] f = factors(n);
        int s = 0;
        for (int v : f) s += v;
        return s;
    }

    public static long productOfFactors(int n) {
        int[] f = factors(n);
        long p = 1;
        for (int v : f) p *= v;
        return p;
    }

    public static long productOfCubesOfFactors(int n) {
        int[] f = factors(n);
        long p = 1;
        for (int v : f) p *= Math.pow(v, 3);
        return p;
    }

    public static void demo(int n) {
        int[] f = factors(n);
        System.out.println("Factors: " + Arrays.toString(f));
        System.out.println("Greatest: " + greatestFactor(n));
        System.out.println("Sum: " + sumOfFactors(n));
        System.out.println("Product: " + productOfFactors(n));
        System.out.println("Product of cubes: " + productOfCubesOfFactors(n));
    }
}
