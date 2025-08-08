package ColletionExamples;

import java.util.LinkedHashSet;
import java.util.Iterator;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        // 1. Create LinkedHashSet
        LinkedHashSet<String> languages = new LinkedHashSet<>();

        // 2. Add elements
        languages.add("Java");
        languages.add("Python");
        languages.add("C++");
        languages.add("JavaScript");
        languages.add("Java"); // Duplicate - will not be added

        // 3. Print all elements (in insertion order)
        System.out.println("Languages: " + languages);

        // 4. Check size
        System.out.println("Size: " + languages.size());

        // 5. Check if element exists
        System.out.println("Contains Python? " + languages.contains("Python"));
        System.out.println("Contains Ruby? " + languages.contains("Ruby"));

        // 6. Remove element
        languages.remove("C++");
        System.out.println("After removing C++: " + languages);

        // 7. isEmpty check
        System.out.println("Is empty? " + languages.isEmpty());

        // 8. Iterate using for-each
        System.out.println("Using for-each loop:");
        for (String lang : languages) {
            System.out.println(lang);
        }

        // 9. Iterate using Iterator
        System.out.println("Using Iterator:");
        Iterator<String> itr = languages.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        // 10. Clear all
        languages.clear();
        System.out.println("After clear: " + languages);
    }
}

