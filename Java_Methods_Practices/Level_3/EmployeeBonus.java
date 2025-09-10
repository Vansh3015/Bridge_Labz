import java.util.Random;
import java.util.Arrays;

public class EmployeeBonus {

    public static double[][] generateEmployees(int n) {
        double[][] arr = new double[n][2]; // salary, years
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            arr[i][0] = 10000 + r.nextInt(90000); // 5-digit salary approx
            arr[i][1] = r.nextInt(11); // years 0..10
        }
        return arr;
    }

    public static double[][] calculateNewSalaryAndBonus(double[][] data) {
        int n = data.length;
        double[][] out = new double[n][3]; // old salary, years, bonus
        for (int i = 0; i < n; i++) {
            double salary = data[i][0];
            double years = data[i][1];
            double rate = years > 5 ? 0.05 : 0.02;
            double bonus = salary * rate;
            out[i][0] = salary;
            out[i][1] = years;
            out[i][2] = bonus;
        }
        return out;
    }

    public static void summary(double[][] arr) {
        double sumOld = 0, sumNew = 0, totalBonus = 0;
        System.out.println("OldSalary\tYears\tBonus\tNewSalary");
        for (double[] r : arr) {
            double oldS = r[0];
            double years = r[1];
            double bonus = r[2];
            double newS = oldS + bonus;
            sumOld += oldS; sumNew += newS; totalBonus += bonus;
            System.out.printf("%.0f\t\t%.0f\t%.2f\t%.2f%n", oldS, years, bonus, newS);
        }
        System.out.println("Sum Old: " + Math.round(sumOld) + " Sum New: " + Math.round(sumNew) + " Total Bonus: " + Math.round(totalBonus));
    }

    public static void demo() {
        double[][] employees = generateEmployees(10);
        double[][] computed = calculateNewSalaryAndBonus(employees);
        summary(computed);
    }
}
