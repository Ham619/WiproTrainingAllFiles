package examples;

public class MonitorPatient {

    public static void main(String[] args) {
    	int heartBeat=70;
        while(heartBeat>=60 && heartBeat<=100) {
        	 System.out.println("Heartbeat is normal: " + heartBeat + " bpm");
        	 heartBeat++;
        }
    }

}
