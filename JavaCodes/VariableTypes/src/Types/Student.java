package Types;

public class Student {
    int marks1 = 70, marks2 = 80; // instance variables

    void total() {
        int totalMarks = marks1 + marks2; // local
        System.out.println("Total Marks: " + totalMarks);
    }

    public static void main(String[] args) {
        Student s = new Student();
        s.total();
    }
}
