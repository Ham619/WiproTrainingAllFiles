package examples;

public class SumOfDigits {
    public static void main(String[] args) {
      
        
        int num = 12345;
        int sum=0;

        do {
            int digit = num %10;
            sum += digit;
            num /= 10;
        } 
        while (num > 0);

        System.out.println("Sum of digits: " + sum);
    }
}
