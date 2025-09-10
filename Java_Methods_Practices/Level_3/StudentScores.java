import java.util.Random;
import java.util.Arrays;

public class StudentScores {

    public static int[][] generateScores(int students) {
        Random r = new Random();
        int[][] arr = new int[students][3];
        for (int i = 0; i < students; i++) {
            arr[i][0] = 10 + r.nextInt(90); // physics
            arr[i][1] = 10 + r.nextInt(90); // chem
            arr[i][2] = 10 + r.nextInt(90); // maths
        }
        return arr;
    }

    public static double[][] totalsAndPercentages(int[][] scores) {
        int n = scores.length;
        double[][] out = new double[n][3]; // total, avg, percentage
        for (int i = 0; i < n; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = Math.round((total / 3.0) * 100.0) / 100.0;
            double perc = Math.round((total / 300.0 * 100.0) * 100.0) / 100.0;
            out[i][0] = total;
            out[i][1] = avg;
            out[i][2] = perc;
        }
        return out;
    }

    public static void displayScorecard(int[][] scores) {
        double[][] t = totalsAndPercentages(scores);
        System.out.println("Idx\tPhy\tChe\tMat\tTotal\tAvg\tPerc");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%d\t%d\t%d\t%d\t%.0f\t%.2f\t%.2f%n", i+1, scores[i][0], scores[i][1], scores[i][2], t[i][0], t[i][1], t[i][2]);
        }
    }

    public static void demo() {
        int[][] s = generateScores(5);
        displayScorecard(s);
    }
}
