package Types;

public class Car {
	// static
    static String brand = "Honda"; 
    // instance
    String model; 

    Car(String model) {
        this.model = model;
    }

    void show() {
        System.out.println(brand + " " + model);
    }

    public static void main(String[] args) {
        Car c = new Car("City");
        c.show();
    }
}

