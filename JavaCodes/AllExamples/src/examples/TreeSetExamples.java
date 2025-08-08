package examples;

import java.util.*;



public class TreeSetExamples {

    public static void main(String[] args) {

        TreeSet<String> names = new TreeSet<>();

        names.add("Rahul");
        names.add("Ajay");
        names.add("hammad");
        
       
        for (String name : names) {
            System.out.println(name);
        }

        
        List<String> nameList = new ArrayList<>(names);

       
        Collections.reverse(nameList);

        
        System.out.println("Reversed names:");
        for (String name : nameList) {
            System.out.println(name);
        }
    }
}

