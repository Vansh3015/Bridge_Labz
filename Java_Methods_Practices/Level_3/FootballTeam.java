import java.util.Random;
import java.util.Arrays;

public class FootballTeam {
    public static int[] generateHeights(int size) {
        int[] heights = new int[size];
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            heights[i] = 150 + r.nextInt(101); // 150..250 inclusive
        }
        return heights;
    }

    public static int sum(int[] arr) {
        int s = 0;
        for (int v : arr) s += v;
        return s;
    }

    public static double mean(int[] arr) {
        if (arr.length == 0) return 0;
        return (double) sum(arr) / arr.length;
    }

    public static int min(int[] arr) {
        int m = Integer.MAX_VALUE;
        for (int v : arr) if (v < m) m = v;
        return m;
    }

    public static int max(int[] arr) {
        int M = Integer.MIN_VALUE;
        for (int v : arr) if (v > M) M = v;
        return M;
    }

    public static void demo() {
        int[] heights = generateHeights(11);
        System.out.println("Heights (cms): " + Arrays.toString(heights));
        System.out.println("Sum: " + sum(heights));
        System.out.printf("Mean: %.2f%n", mean(heights));
        System.out.println("Shortest: " + min(heights));
        System.out.println("Tallest: " + max(heights));
    }
}
