import java.util.Random;
import java.util.Arrays;

public class MatrixOperations {

    public static int[][] randomMatrix(int r, int c) {
        Random rnd = new Random();
        int[][] m = new int[r][c];
        for (int i = 0; i < r; i++) for (int j = 0; j < c; j++) m[i][j] = rnd.nextInt(10);
        return m;
    }

    public static int[][] add(int[][] a, int[][] b) {
        int r = a.length, c = a[0].length;
        int[][] out = new int[r][c];
        for (int i = 0; i < r; i++) for (int j = 0; j < c; j++) out[i][j] = a[i][j] + b[i][j];
        return out;
    }

    public static int[][] subtract(int[][] a, int[][] b) {
        int r = a.length, c = a[0].length;
        int[][] out = new int[r][c];
        for (int i = 0; i < r; i++) for (int j = 0; j < c; j++) out[i][j] = a[i][j] - b[i][j];
        return out;
    }

    public static int[][] multiply(int[][] a, int[][] b) {
        int r = a.length, c = b[0].length, mid = a[0].length;
        int[][] out = new int[r][c];
        for (int i = 0; i < r; i++) for (int j = 0; j < c; j++) {
            int s = 0;
            for (int k = 0; k < mid; k++) s += a[i][k] * b[k][j];
            out[i][j] = s;
        }
        return out;
    }

    public static void printMatrix(int[][] m) {
        for (int[] row : m) System.out.println(Arrays.toString(row));
    }

    public static void demo() {
        int[][] a = randomMatrix(2,3);
        int[][] b = randomMatrix(2,3);
        System.out.println("A:"); printMatrix(a);
        System.out.println("B:"); printMatrix(b);
        System.out.println("A+B:"); printMatrix(add(a,b));
        System.out.println("A-B:"); printMatrix(subtract(a,b));
        int[][] x = randomMatrix(2,2);
        int[][] y = randomMatrix(2,2);
        System.out.println("X:"); printMatrix(x);
        System.out.println("Y:"); printMatrix(y);
        System.out.println("X*Y:"); printMatrix(multiply(x,y));
    }
}
