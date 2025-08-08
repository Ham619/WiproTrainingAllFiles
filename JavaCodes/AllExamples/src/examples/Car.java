package examples;

class Car {
    private boolean engineStatus;
    private int speed;
    private double fuelLevel;

    
    public Car() {
        engineStatus = false;
        speed = 0;
        fuelLevel = 100;
    }

    
    public void startEngine() {
        engineStatus = true;
        System.out.println("Engine started.");
    }

    
    public void stopEngine() {
        engineStatus = false;
        speed = 0;
        System.out.println("Engine stopped.");
    }

    
    public void setSpeed(int s) {
        if (engineStatus && s >= 0) {
            speed = s;
            System.out.println("Speed set to: " + speed + " km/h");
        } else {
            System.out.println("Cannot set speed. Engine is off or speed is invalid.");
        }
    }

    
    public void setFuelLevel(double f) {
        if (f >= 0 && f <= 100) {
            fuelLevel = f;
        } else {
            System.out.println("Invalid fuel level.");
        }
    }

    
    public boolean isEngineOn() {
        return engineStatus;
    }

   
    public int getSpeed() {
        return speed;
    }

    
    public double getFuelLevel() {
        return fuelLevel;
    }

    
    public void showStatus() {
        System.out.println("Engine: " + (engineStatus ? "On" : "Off"));
        System.out.println("Speed: " + speed + " km/h");
        System.out.println("Fuel Level: " + fuelLevel + "%");
    }
}
