package Types;

public class Offer {
    int discount = 10;

    void applyDiscount(double price) {
        double finalPrice = price - (price * discount / 100);
        System.out.println("Final Price: ₹" + finalPrice);
    }

    public static void main(String[] args) {
        new Offer().applyDiscount(500);
    }
}

