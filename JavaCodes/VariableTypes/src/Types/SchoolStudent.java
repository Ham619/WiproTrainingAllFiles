package Types;

public class SchoolStudent {
    static int count = 0;

    SchoolStudent() {
        count++;
        System.out.println("Student #" + count + " created");
    }

    public static void main(String[] args) {
        new SchoolStudent();
        new SchoolStudent();
        new SchoolStudent();
    }
}

