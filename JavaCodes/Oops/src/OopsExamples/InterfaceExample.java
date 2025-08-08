package OopsExamples;


interface Remote {
 void powerOn();
 void powerOff();
}

class TV implements Remote {
 public void powerOn() {
     System.out.println("TV is turning on...");
 }

 public void powerOff() {
     System.out.println("TV is turning off...");
 }
}

public class InterfaceExample {
 public static void main(String[] args) {
     Remote remote = new TV();
     remote.powerOn();
     remote.powerOff();
 }
}
