package Types;

public class ElectricityBill {
    static double ratePerUnit = 7.5;

    void calculateBill(int units) {
        double bill = units * ratePerUnit;
        System.out.println("Total Bill: ₹" + bill);
    }

    public static void main(String[] args) {
        new ElectricityBill().calculateBill(120);
    }
}
