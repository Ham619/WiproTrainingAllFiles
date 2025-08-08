package Types;

public class Interest {
    void calculateInterest() {
        double principal = 10000, rate = 5, time = 2;
        double interest = (principal * rate * time) / 100;
        System.out.println("Simple Interest: " + interest);
    }

    public static void main(String[] args) {
        new Interest().calculateInterest();
    }
}
