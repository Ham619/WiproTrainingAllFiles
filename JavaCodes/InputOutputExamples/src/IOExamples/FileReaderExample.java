package IOExamples;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
    public static void main(String[] args) {
        String fileName = "filereader_writer_example.txt";

        try {
            FileReader reader = new FileReader(fileName);
            int character;
            System.out.println("Reading file using FileReader:");
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
