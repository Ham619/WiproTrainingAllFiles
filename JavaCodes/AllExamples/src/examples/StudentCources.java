package examples;

// Student Class
public class StudentCources {
    private String name;
    private String rollNumber;
    private Course enrolledCourse;

    public StudentCources(String name, String rollNumber, Course course) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.enrolledCourse = course;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        enrolledCourse.displayCourseInfo();
    }
}

// Course Class 
class Course {
    private String courseName;
    private int durationWeeks;

    public Course(String courseName, int durationWeeks) {
        this.courseName = courseName;
        this.durationWeeks = durationWeeks;
    }

    public void displayCourseInfo() {
        System.out.println("Enrolled Course: " + courseName);
        System.out.println("Duration: " + durationWeeks + " weeks");
    }
}
