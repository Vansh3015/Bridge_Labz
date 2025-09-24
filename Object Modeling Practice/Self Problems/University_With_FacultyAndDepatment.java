import java.util.ArrayList;
import java.util.List;

class Faculty {
    private String name;
    private String title;

    public Faculty(String name, String title) {
        this.name = name;
        this.title = title;
    }

    public void displayFaculty() {
        System.out.println("Faculty: " + name + ", Title: " + title);
    }
}

class Department {
    private String deptName;
    private List<Faculty> faculties = new ArrayList<>();

    public Department(String deptName) {
        this.deptName = deptName;
    }

    public void addFaculty(Faculty f) {
        faculties.add(f);
    }

    public void displayDepartment() {
        System.out.println("Department: " + deptName);
        for (Faculty f : faculties) {
            f.displayFaculty();
        }
    }
}

public class University_With_FacultyAndDepatment {
    private String uniName;
    private List<Department> departments = new ArrayList<>();

    public University_With_FacultyAndDepatment(String uniName) {
        this.uniName = uniName;
    }

    public void addDepartment(Department d) {
        departments.add(d);
    }

    public void displayUniversity() {
        System.out.println("University: " + uniName);
        for (Department d : departments) {
            d.displayDepartment();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Faculty f1 = new Faculty("Dr. Smith", "Professor");
        Faculty f2 = new Faculty("Dr. Alice", "Assistant Professor");
        Faculty f3 = new Faculty("Dr. John", "Lecturer");

        Department d1 = new Department("Computer Science");
        d1.addFaculty(f1);
        d1.addFaculty(f2);

        Department d2 = new Department("Mathematics");
        d2.addFaculty(f3);

        University_With_FacultyAndDepatment uni = new University_With_FacultyAndDepatment("Global University");
        uni.addDepartment(d1);
        uni.addDepartment(d2);

        uni.displayUniversity();

        System.out.println("Faculty independent of departments:");
        f1.displayFaculty();
        f2.displayFaculty();
        f3.displayFaculty();
    }
}
