package ColletionExamples;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {
    public static void main(String[] args) {
        // 1. Create a HashSet
        HashSet<String> fruits = new HashSet<>();

        // 2. Add elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Grapes");
        fruits.add("Banana"); // Duplicate - will not be added

        // 3. Print all elements
        System.out.println("Fruits: " + fruits);

        // 4. Check size
        System.out.println("Size: " + fruits.size());

        // 5. Check if element exists
        System.out.println("Contains Mango? " + fruits.contains("Mango"));
        System.out.println("Contains Orange? " + fruits.contains("Orange"));

        // 6. Remove an element
        fruits.remove("Grapes");
        System.out.println("After removing Grapes: " + fruits);

        // 7. isEmpty
        System.out.println("Is empty? " + fruits.isEmpty());

        // 8. Iterate using for-each
        System.out.println("Using for-each:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // 9. Iterate using Iterator
        System.out.println("Using Iterator:");
        Iterator<String> iterator = fruits.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 10. Clear all elements
        fruits.clear();
        System.out.println("After clear: " + fruits);
    }
}
