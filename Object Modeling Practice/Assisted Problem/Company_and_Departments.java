import java.util.ArrayList;
import java.util.List;

class Employee {
    private String name;
    private String designation;

    public Employee(String name, String designation) {
        this.name = name;
        this.designation = designation;
    }

    public void displayEmployee() {
        System.out.println("Employee: " + name + ", Designation: " + designation);
    }
}

class Department {
    private String deptName;
    private List<Employee> employees;

    public Department(String deptName) {
        this.deptName = deptName;
        employees = new ArrayList<>();
    }

    public void addEmployee(String name, String designation) {
        employees.add(new Employee(name, designation));
    }

    public void displayDepartment() {
        System.out.println("Department: " + deptName);
        for (Employee e : employees) {
            e.displayEmployee();
        }
    }
}

public class Company_and_Departments {
    private String companyName;
    private List<Department> departments;

    public Company_and_Departments(String companyName) {
        this.companyName = companyName;
        departments = new ArrayList<>();
    }

    public void addDepartment(Department dept) {
        departments.add(dept);
    }

    public void displayCompanyDetails() {
        System.out.println("Company: " + companyName);
        for (Department d : departments) {
            d.displayDepartment();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Company_and_Departments company = new Company_and_Departments("Tech Solutions Inc.");

        Department dept1 = new Department("Software");
        dept1.addEmployee("Thamarai", "Software Engineer");
        dept1.addEmployee("Rohan", "Senior Developer");

        Department dept2 = new Department("HR");
        dept2.addEmployee("Anita", "HR Manager");

        company.addDepartment(dept1);
        company.addDepartment(dept2);

        company.displayCompanyDetails();
    }
}
