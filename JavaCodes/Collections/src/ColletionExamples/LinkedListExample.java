package ColletionExamples;

import java.util.LinkedList;
import java.util.Collections;

public class LinkedListExample {
    public static void main(String[] args) {
        // 1. Create LinkedList
        LinkedList<String> list = new LinkedList<>();

        // 2. Add elements
        list.add("Apple");
        list.add("Banana");
        list.add("Mango");

        // 3. Add at specific index
        list.add(1, "Grapes");

        // 4. Add at first and last
        list.addFirst("Start");
        list.addLast("End");

        System.out.println("Initial List: " + list);

        // 5. Get elements
        System.out.println("First: " + list.getFirst());
        System.out.println("Last: " + list.getLast());
        System.out.println("Element at index 2: " + list.get(2));

        // 6. Set element
        list.set(2, "Orange");
        System.out.println("After set at index 2: " + list);

        // 7. Remove elements
        list.remove("Mango");           // By value
        list.remove(0);                 // By index
        list.removeFirst();             // Remove first
        list.removeLast();              // Remove last

        System.out.println("After removals: " + list);

        // 8. Check contains, size, isEmpty
        System.out.println("Contains Banana? " + list.contains("Banana"));
        System.out.println("Size: " + list.size());
        System.out.println("Is Empty? " + list.isEmpty());

        // 9. Sort
        Collections.sort(list);
        System.out.println("Sorted: " + list);

        // 10. Reverse
        Collections.reverse(list);
        System.out.println("Reversed: " + list);

        // 11. Stack behavior
        list.push("Top"); // same as addFirst
        System.out.println("After push: " + list);
        list.pop(); // same as removeFirst
        System.out.println("After pop: " + list);

        // 12. Iterate
        for (String item : list) {
            System.out.println("Item: " + item);
        }

        // 13. Clear list
        list.clear();
        System.out.println("After clear: " + list);
    }
}
