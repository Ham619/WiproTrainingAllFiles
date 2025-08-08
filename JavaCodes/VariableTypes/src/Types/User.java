package Types;

public class User {
    static int loginCount = 0;

    void login(String name) {
        loginCount++;
        System.out.println(name + " logged in. Total logins: " + loginCount);
    }

    public static void main(String[] args) {
        User u1 = new User();
        User u2 = new User();
        u1.login("Amit");
        u2.login("Priya");
    }
}
