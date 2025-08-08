package ColletionExamples;

import java.util.TreeSet;
import java.util.Iterator;

public class TreeSetExample {
    public static void main(String[] args) {
        // 1. Create TreeSet
        TreeSet<Integer> numbers = new TreeSet<>();

        // 2. Add elements (unsorted)
        numbers.add(40);
        numbers.add(10);
        numbers.add(30);
        numbers.add(20);
        numbers.add(10); // Duplicate - will not be added

        // 3. Print all elements (sorted automatically)
        System.out.println("TreeSet: " + numbers); // [10, 20, 30, 40]

        // 4. size
        System.out.println("Size: " + numbers.size());

        // 5. contains
        System.out.println("Contains 20? " + numbers.contains(20));
        System.out.println("Contains 50? " + numbers.contains(50));

        // 6. remove
        numbers.remove(30);
        System.out.println("After removing 30: " + numbers);

        // 7. isEmpty
        System.out.println("Is empty? " + numbers.isEmpty());

        // 8. first and last
        System.out.println("First: " + numbers.first());
        System.out.println("Last: " + numbers.last());

        // 9. higher, lower
        System.out.println("Higher than 20: " + numbers.higher(20));
        System.out.println("Lower than 20: " + numbers.lower(20));

        // 10. headSet, tailSet, subSet
        System.out.println("HeadSet (<30): " + numbers.headSet(30));
        System.out.println("TailSet (>=20): " + numbers.tailSet(20));
        System.out.println("SubSet (10 to 40): " + numbers.subSet(10, 40));

        // 11. Iterating
        System.out.println("Using Iterator:");
        Iterator<Integer> it = numbers.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // 12. Clear
        numbers.clear();
        System.out.println("After clear: " + numbers);
    }
}
