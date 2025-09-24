package Encapsulation_Polymorphism_Abstraction.EmployeeManagementSystem;

public class FullTimeEmployee extends Employee implements Department {
    private String department;
    private double monthlySalary;

    // Constructor
    public FullTimeEmployee(int employeeId, String name, double baseSalary, double monthlySalary) {
        super(employeeId, name, baseSalary);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary; // Fixed monthly salary
    }

    @Override
    public void assignDepartment(String departmentName) {
        this.department = departmentName;
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + department;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Employee Type: Full Time");
        System.out.println("Monthly Salary: " + calculateSalary());
        System.out.println(getDepartmentDetails());
        System.out.println("-------------------------");
    }
}
