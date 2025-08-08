package examples;

public class ForEach {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        for (int num : numbers) {
            System.out.println("Number: " + num);
        }
        
        String[] fruits = {"apple","banana","mango"};
        for(String fruit:fruits) {
        	System.out.println("fruit"+fruit);
        }
    }
}

