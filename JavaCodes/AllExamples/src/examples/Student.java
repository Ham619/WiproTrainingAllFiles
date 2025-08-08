package examples;

class data {
	int id;
	String name;
}

class data1 {
	int id;
	String name;

	public data1() {
		id = 101;
		name = "hammad";
	}
}


public class Student {
    public static void main(String[] args) {
        data s = new data(); 
        System.out.println(s.id);   
        System.out.println(s.name); 
        
        data1 d = new data1();
        System.out.println(d.id);
        System.out.println(d.name);
    }
}
