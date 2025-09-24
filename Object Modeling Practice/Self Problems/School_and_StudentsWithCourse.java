import java.util.ArrayList;
import java.util.List;

class Course {
    private String courseName;
    private List<Student> students = new ArrayList<>();

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            student.enrollCourse(this);
        }
    }

    public void displayStudents() {
        System.out.println("Course: " + courseName);
        for (Student s : students) {
            System.out.println("Student: " + s.getName());
        }
    }

    public String getCourseName() {
        return courseName;
    }
}

class Student {
    private String name;
    private List<Course> courses = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public void enrollCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    public void viewCourses() {
        System.out.println("Student: " + name);
        for (Course c : courses) {
            System.out.println("Enrolled in: " + c.getCourseName());
        }
    }

    public String getName() {
        return name;
    }
}

class School {
    private String schoolName;
    private List<Student> students = new ArrayList<>();

    public School(String schoolName) {
        this.schoolName = schoolName;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayAllStudents() {
        System.out.println("School: " + schoolName);
        for (Student s : students) {
            s.viewCourses();
            System.out.println();
        }
    }
}

public class School_and_StudentsWithCourse {
    public static void main(String[] args) {
        School school = new School("Global High School");

        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");

        school.addStudent(s1);
        school.addStudent(s2);

        Course math = new Course("Mathematics");
        Course physics = new Course("Physics");
        Course chemistry = new Course("Chemistry");

        s1.enrollCourse(math);
        s1.enrollCourse(physics);

        s2.enrollCourse(physics);
        s2.enrollCourse(chemistry);

        school.displayAllStudents();

        System.out.println("Course details:");
        math.displayStudents();
        physics.displayStudents();
        chemistry.displayStudents();
    }
}
