package ColletionExamples;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListExample {
    public static void main(String[] args) {
        // 1. Create ArrayList
        ArrayList<String> list = new ArrayList<>();

        // 2. Add elements
        list.add("Apple");
        list.add("Banana");
        list.add("Mango");
        list.add(1, "Grapes"); // Insert at index 1

        // 3. Display list
        System.out.println("Initial List: " + list);

        // 4. Get element
        String fruit = list.get(2); // index 2
        System.out.println("Element at index 2: " + fruit);

        // 5. Set element (replace)
        list.set(0, "Strawberry");
        System.out.println("After set: " + list);

        // 6. Remove element by index and object
        list.remove(1);              // removes "Grapes"
        list.remove("Banana");       // removes "Banana"
        System.out.println("After remove: " + list);

        // 7. Check if element exists
        boolean hasMango = list.contains("Mango");
        System.out.println("Contains Mango? " + hasMango);

        // 8. Size of the list
        System.out.println("List size: " + list.size());

        // 9. Check if list is empty
        System.out.println("Is list empty? " + list.isEmpty());

        // 10. Sort the list
        Collections.sort(list);
        System.out.println("Sorted List: " + list);

        // 11. Reverse the list
        Collections.reverse(list);
        System.out.println("Reversed List: " + list);

        // 12. Iterate using for-each loop
        System.out.println("For-each loop:");
        for (String item : list) {
            System.out.println(item);
        }

        // 13. Clear the list
        list.clear();
        System.out.println("After clear: " + list);
    }
}
