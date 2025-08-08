package Types;

public class Cart {
	// instance
    int itemCount = 3; 

    void calculateTotal() {
    	// local
        int pricePerItem = 100; 
        int total = itemCount * pricePerItem;
        System.out.println("Cart Total: ₹" + total);
    }

    public static void main(String[] args) {
        new Cart().calculateTotal();
    }
}
