import java.util.Arrays;

public class MatrixAdvanced {

    public static int[][] transpose(int[][] a) {
        int r = a.length, c = a[0].length;
        int[][] t = new int[c][r];
        for (int i = 0; i < r; i++) for (int j = 0; j < c; j++) t[j][i] = a[i][j];
        return t;
    }

    public static int determinant2x2(int[][] m) {
        return m[0][0]*m[1][1] - m[0][1]*m[1][0];
    }

    public static int determinant3x3(int[][] m) {
        int det = m[0][0]*(m[1][1]*m[2][2]-m[1][2]*m[2][1])
                - m[0][1]*(m[1][0]*m[2][2]-m[1][2]*m[2][0])
                + m[0][2]*(m[1][0]*m[2][1]-m[1][1]*m[2][0]);
        return det;
    }

    public static double[][] inverse2x2(int[][] m) {
        int det = determinant2x2(m);
        if (det == 0) return null;
        double[][] inv = new double[2][2];
        inv[0][0] = m[1][1] / (double)det;
        inv[0][1] = -m[0][1] / (double)det;
        inv[1][0] = -m[1][0] / (double)det;
        inv[1][1] = m[0][0] / (double)det;
        return inv;
    }

    // Naive inverse for 3x3 using adjoint/determinant (integer arithmetic)
    public static double[][] inverse3x3(int[][] m) {
        int det = determinant3x3(m);
        if (det == 0) return null;
        double[][] adj = new double[3][3];
        adj[0][0] =  (m[1][1]*m[2][2]-m[1][2]*m[2][1]);
        adj[0][1] = -(m[0][1]*m[2][2]-m[0][2]*m[2][1]);
        adj[0][2] =  (m[0][1]*m[1][2]-m[0][2]*m[1][1]);
        adj[1][0] = -(m[1][0]*m[2][2]-m[1][2]*m[2][0]);
        adj[1][1] =  (m[0][0]*m[2][2]-m[0][2]*m[2][0]);
        adj[1][2] = -(m[0][0]*m[1][2]-m[0][2]*m[1][0]);
        adj[2][0] =  (m[1][0]*m[2][1]-m[1][1]*m[2][0]);
        adj[2][1] = -(m[0][0]*m[2][1]-m[0][1]*m[2][0]);
        adj[2][2] =  (m[0][0]*m[1][1]-m[0][1]*m[1][0]);
        double[][] inv = new double[3][3];
        for (int i = 0; i < 3; i++) for (int j = 0; j < 3; j++) inv[i][j] = adj[i][j] / (double)det;
        return inv;
    }

    public static void demo() {
        int[][] m2 = {{4,7},{2,6}};
        System.out.println("Det2x2: " + determinant2x2(m2));
        double[][] inv2 = inverse2x2(m2);
        System.out.println("Inv2x2: " + Arrays.deepToString(inv2));

        int[][] m3 = {{1,2,3},{0,1,4},{5,6,0}};
        System.out.println("Det3x3: " + determinant3x3(m3));
        double[][] inv3 = inverse3x3(m3);
        System.out.println("Inv3x3: " + Arrays.deepToString(inv3));
    }
}
