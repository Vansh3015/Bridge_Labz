import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        double[] percentages = new double[n];
        char[] grades = new char[n];
        double[][] marks = new double[n][3];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter marks for student " + (i + 1) + ": ");
            for (int j = 0; j < 3; j++) {
                marks[i][j] = sc.nextDouble();
            }
            percentages[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3;
            if (percentages[i] >= 90) grades[i] = 'A';
            else if (percentages[i] >= 75) grades[i] = 'B';
            else if (percentages[i] >= 50) grades[i] = 'C';
            else grades[i] = 'D';
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + " - Physics: " + marks[i][0] + ", Chemistry: " + marks[i][1] + ", Maths: " + marks[i][2] + ", Percentage: " + percentages[i] + "%, Grade: " + grades[i]);
        }
    }
}