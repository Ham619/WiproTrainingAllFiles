package IOExamples;

import java.io.File;
import java.io.IOException;

public class FileCreation {
    public static void main(String[] args) {
        try {
            File file = new File("myfile.txt");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

