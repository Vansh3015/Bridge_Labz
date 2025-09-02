import java.util.Scanner;
public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Physics marks: ");
        int phy = sc.nextInt();
        System.out.print("Enter Chemistry marks: ");
        int chem = sc.nextInt();
        System.out.print("Enter Maths marks: ");
        int math = sc.nextInt();
        double avg = (phy + chem + math) / 3.0;
        String grade, remark;
        if (avg >= 90) { grade = "A"; remark = "Excellent"; }
        else if (avg >= 75) { grade = "B"; remark = "Very Good"; }
        else if (avg >= 60) { grade = "C"; remark = "Good"; }
        else if (avg >= 40) { grade = "D"; remark = "Pass"; }
        else { grade = "F"; remark = "Fail"; }
        System.out.println("Average Mark: " + avg);
        System.out.println("Grade: " + grade + " (" + remark + ")");
        sc.close();
    }
}