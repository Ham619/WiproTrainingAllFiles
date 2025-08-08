package IOExamples;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    public static void main(String[] args) {
        String fileName = "filereader_writer_example.txt";

        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write("This is a simple FileWriter example.\n");
            writer.write("Writing to file character by character.\n");
            writer.close();
            System.out.println("Data written to file: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
