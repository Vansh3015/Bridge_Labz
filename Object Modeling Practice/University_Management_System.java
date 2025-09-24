import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;
    private List<Course> courses = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public void enrollCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.addStudent(this);
        }
    }

    public void viewCourses() {
        System.out.println("Student: " + name);
        for (Course c : courses) {
            System.out.println("Enrolled in: " + c.getCourseName() + ", Professor: " + (c.getProfessor() != null ? c.getProfessor().getName() : "TBA"));
        }
    }

    public String getName() {
        return name;
    }
}

class Professor {
    private String name;
    private List<Course> courses = new ArrayList<>();

    public Professor(String name) {
        this.name = name;
    }

    public void assignCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.setProfessor(this);
        }
    }

    public String getName() {
        return name;
    }

    public void viewCourses() {
        System.out.println("Professor: " + name);
        for (Course c : courses) {
            System.out.println("Teaching: " + c.getCourseName());
        }
    }
}

class Course {
    private String courseName;
    private Professor professor;
    private List<Student> students = new ArrayList<>();

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Professor getProfessor() {
        return professor;
    }

    public String getCourseName() {
        return courseName;
    }

    public void displayCourseStudents() {
        System.out.println("Course: " + courseName);
        for (Student s : students) {
            System.out.println("Student: " + s.getName());
        }
    }
}

public class University_Management_System {
    public static void main(String[] args) {
        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");

        Professor p1 = new Professor("Dr. Smith");
        Professor p2 = new Professor("Dr. Alice");

        Course c1 = new Course("Mathematics");
        Course c2 = new Course("Physics");

        s1.enrollCourse(c1);
        s1.enrollCourse(c2);

        s2.enrollCourse(c1);

        p1.assignCourse(c1);
        p2.assignCourse(c2);

        s1.viewCourses();
        System.out.println();
        s2.viewCourses();
        System.out.println();
        p1.viewCourses();
        System.out.println();
        p2.viewCourses();
        System.out.println();

        c1.displayCourseStudents();
        System.out.println();
        c2.displayCourseStudents();
    }
}
