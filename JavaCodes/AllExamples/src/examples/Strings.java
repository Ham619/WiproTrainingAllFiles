package examples;

public class Strings {

	 public static void main(String[] args) {
	    	String name= "Java";
	    	
	    	System.out.println(name.length());
	    	
	    	System.out.println(name.charAt(2));
	    	
	    	System.out.println(name.toUpperCase()); 
	    	
	    	System.out.println(name.toLowerCase());
	    	
	    	System.out.println(name.equals("java"));
	    	
	    	System.out.println(name.compareTo("python"));
	    	
	    	System.out.println(name.isEmpty());
	    	
	    	System.out.println(name.isBlank());
	    	
	    	String word = "Hello world";
	    	
	    	System.out.println(word.contains("World")); 
	    	
	    	System.out.println(word.startsWith("Hello"));
	    	
	    	System.out.println(word.endsWith("world"));
	    	
	    	System.out.println(word.indexOf("l")); 
	    	
	    	System.out.println(word.lastIndexOf("o")); 
	    	
	    	System.out.println(word.indexOf("o",2)); 
	    	
	    	System.out.println(word.replace("o","a"));
	    	
	    	System.out.println(word.replace("Hello","any"));
	    	
	    	System.out.println(word.substring(6));
	    	
	    	System.out.println(word.substring(2,7));
	    	
	    	System.out.println(word.trim());
	    	
	    	System.out.println(word.strip());
	    	
	    	System.out.println(word.concat("Now"));
	    }
}
