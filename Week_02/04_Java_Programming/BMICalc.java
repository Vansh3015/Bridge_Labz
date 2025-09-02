import java.util.Scanner;
public class BMICalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter weight (kg): ");
        double weight = sc.nextDouble();
        System.out.print("Enter height (cm): ");
        double heightCm = sc.nextDouble();
        double heightM = heightCm / 100.0;
        double bmi = weight / (heightM * heightM);
        String status;
        if (bmi < 18.5) status = "Underweight";
        else if (bmi < 24.9) status = "Normal";
        else if (bmi < 29.9) status = "Overweight";
        else status = "Obese";
        System.out.println("BMI: " + bmi + " (" + status + ")");
        sc.close();
    }
}