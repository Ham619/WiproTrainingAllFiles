package ColletionExamples;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        // 1. Create TreeMap
        TreeMap<String, Integer> marks = new TreeMap<>();

        // 2. put()
        marks.put("Math", 85);
        marks.put("English", 90);
        marks.put("Science", 78);
        marks.put("History", 82);

        // 3. putIfAbsent()
        marks.putIfAbsent("Geography", 88);
        marks.putIfAbsent("Math", 99); // will not override

        // 4. get()
        System.out.println("Science Marks: " + marks.get("Science"));

        // 5. getOrDefault()
        System.out.println("Art Marks or default: " + marks.getOrDefault("Art", 0));

        // 6. containsKey(), containsValue()
        System.out.println("Has History? " + marks.containsKey("History"));
        System.out.println("Has 90 marks? " + marks.containsValue(90));

        // 7. replace()
        marks.replace("Science", 80);
        System.out.println("Updated Science Marks: " + marks.get("Science"));

        // 8. remove()
        marks.remove("History");
        System.out.println("After removing History: " + marks);

        // 9. keySet()
        System.out.println("Subjects: " + marks.keySet());

        // 10. values()
        System.out.println("Marks: " + marks.values());

        // 11. entrySet()
        System.out.println("All entries in sorted key order:");
        for (Map.Entry<String, Integer> entry : marks.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

        // 12. firstKey(), lastKey()
        System.out.println("First subject: " + marks.firstKey());
        System.out.println("Last subject: " + marks.lastKey());

        // 13. higherKey(), lowerKey()
        System.out.println("Key after English: " + marks.higherKey("English"));
        System.out.println("Key before English: " + marks.lowerKey("English"));

        // 14. pollFirstEntry(), pollLastEntry()
        System.out.println("Removed first: " + marks.pollFirstEntry());
        System.out.println("Removed last: " + marks.pollLastEntry());

        // 15. clear(), size(), isEmpty()
        marks.clear();
        System.out.println("Is map empty after clear? " + marks.isEmpty());
    }
}
