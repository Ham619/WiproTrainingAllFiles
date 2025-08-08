package IOExamples;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterExample {
    public static void main(String[] args) {
        String filename = "buffered_writer_output.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Writing to a file using BufferedWriter.");
            writer.newLine();
            writer.write("This is the second line.");
            System.out.println("Data written successfully to: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
