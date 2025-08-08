package examples;

class Patient1 {
    private String name;
    private int age;
    private String disease;
    private String healthInfo;  

   
    public Patient1(String name, int age, String disease, String healthInfo) {
        this.name = name;
        this.age = age;
        this.disease = disease;
        this.healthInfo = healthInfo;
    }

    
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDisease() {
        return disease;
    }

    public String getHealthInfo() {
        return healthInfo;
    }

    
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Disease: " + disease);
    }
}
