package ColletionExamples;

import java.util.LinkedList;

public class LinkedList2Example {
    public static void main(String[] args) {
        // 1. Create LinkedList
        LinkedList<String> cities = new LinkedList<>();

        // 2. Add elements (List methods)
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Chennai");
        cities.add("Kolkata");

        // 3. Add at specific index
        cities.add(2, "Bangalore");

        // 4. Add First/Last (Deque methods)
        cities.addFirst("Pune");
        cities.addLast("Hyderabad");

        // 5. Get elements (List methods)
        System.out.println("First: " + cities.getFirst());
        System.out.println("Last: " + cities.getLast());
        System.out.println("At index 3: " + cities.get(3));

        // 6. Remove elements
        cities.remove();              // Removes head (Queue behavior)
        cities.remove(2);            // Remove at index
        cities.remove("Mumbai");     // Remove by value
        cities.removeFirst();        // Remove first element
        cities.removeLast();         // Remove last element

        // 7. Peek (Queue methods)
        System.out.println("Peek (head): " + cities.peek());

        // 8. Poll (removes and returns head)
        System.out.println("Poll: " + cities.poll());

        // 9. Offer (Queue methods)
        cities.offer("Jaipur");
        cities.offerFirst("Lucknow");
        cities.offerLast("Bhopal");

        // 10. Stack-like methods
        cities.push("Nagpur"); // Same as addFirst
        System.out.println("Popped: " + cities.pop()); // Remove from front

        // 11. Size and Contains
        System.out.println("Size: " + cities.size());
        System.out.println("Contains Chennai? " + cities.contains("Chennai"));

        // 12. Iterate
        System.out.println("All Cities:");
        for (String city : cities) {
            System.out.println(city);
        }

        // 13. Clear all
        cities.clear();
        System.out.println("After clear: " + cities);
    }
}
