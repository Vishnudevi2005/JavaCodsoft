import java.util.ArrayList;
import java.util.List;

class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private String schedule;
    private List<Student> enrolledStudents;

    // Constructor to initialize the course details
    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.enrolledStudents = new ArrayList<>();
    }

    // Getters for course details
    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    // Method to check how many slots are available
    public int availableSlots() {
        return capacity - enrolledStudents.size();
    }

    // Method to enroll a student in the course
    public boolean enrollStudent(Student student) {
        if (availableSlots() > 0) {
            enrolledStudents.add(student);
            student.registerForCourse(this);
            return true;
        }
        return false;
    }

    // Method to remove a student from the course
    public boolean removeStudent(Student student) {
        if (enrolledStudents.contains(student)) {
            enrolledStudents.remove(student);
            student.dropCourse(this);
            return true;
        }
        return false;
    }

    // Override toString to display course details
    @Override
    public String toString() {
        return code + ": " + title + " - " + description + ", Schedule: " + schedule
                + ", Available Slots: " + availableSlots();
    }
}

class Student {
    private int studentId;
    private String name;
    private List<Course> registeredCourses;

    // Constructor to initialize student details
    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    // Getters for student info
    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    // Method to register for a course
    public void registerForCourse(Course course) {
        if (!registeredCourses.contains(course)) {
            registeredCourses.add(course);
        }
    }

    // Method to drop a course
    public void dropCourse(Course course) {
        registeredCourses.remove(course);
    }

    // Override toString to display student details
    @Override
    public String toString() {
        return "Student " + studentId + ": " + name;
    }
}

public class CourseRegistrationSystem {

    // Method to display available courses
    public static void displayCourses(List<Course> courses) {
        System.out.println("Available Courses:");
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    // Method to register a student for a course
    public static void registerStudentForCourse(Student student, Course course) {
        if (course.enrollStudent(student)) {
            System.out.println(student.getName() + " successfully registered for " + course.getTitle() + ".");
        } else {
            System.out.println(course.getTitle() + " is full. Registration failed.");
        }
    }

    // Method to drop a student from a course
    public static void dropStudentFromCourse(Student student, Course course) {
        if (course.removeStudent(student)) {
            System.out.println(student.getName() + " successfully dropped " + course.getTitle() + ".");
        } else {
            System.out.println(student.getName() + " is not registered for " + course.getTitle() + ".");
        }
    }

    public static void main(String[] args) {
        // Create courses
        Course cs101 = new Course("CS101", "Introduction to Computer Science", "Learn the basics of computer science.", 30, "Mon-Wed 10:00-11:30");
        Course math202 = new Course("MATH202", "Calculus II", "A deeper look into calculus concepts.", 25, "Tue-Thu 12:00-13:30");
        Course phys301 = new Course("PHYS301", "Physics I", "Introduction to mechanics and motion.", 20, "Mon-Wed 14:00-15:30");

        // Create students
        Student alice = new Student(1001, "Alice Johnson");
        Student bob = new Student(1002, "Bob Smith");
        Student charlie = new Student(1003, "Charlie Brown");

        // List of available courses
        List<Course> courses = new ArrayList<>();
        courses.add(cs101);
        courses.add(math202);
        courses.add(phys301);

        // Display available courses
        displayCourses(courses);

        // Register students
        registerStudentForCourse(alice, cs101);  // Alice registers for CS101
        registerStudentForCourse(bob, math202);  // Bob registers for MATH202
        registerStudentForCourse(charlie, phys301);  // Charlie registers for PHYS301

        // Display available courses after registration
        System.out.println("\nAfter Registration:");
        displayCourses(courses);

        // Drop a course (Alice drops CS101)
        dropStudentFromCourse(alice, cs101);

        // Display available courses after dropping a course
        System.out.println("\nAfter Dropping Course:");
        displayCourses(courses);
    }
}
