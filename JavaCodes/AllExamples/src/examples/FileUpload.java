package examples;

import java.util.Scanner;

class FileData {
    String fileName;
    String fileType;
    double fileSize; 

    void uploadFile() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter File Name: ");
        fileName = sc.nextLine();

        System.out.print("Enter File Type: ");
        fileType = sc.nextLine();

        System.out.print("Enter File Size (MB): ");
        fileSize = sc.nextDouble();

        System.out.println("File uploaded successfully!");
        
        sc.close();
    }

    void downloadFile() {
        System.out.println("\n--- Downloading File ---");
        System.out.println("File Name : " + fileName);
        System.out.println("File Type : " + fileType);
        System.out.println("File Size : " + fileSize + " MB");
        System.out.println("Download completed!");
    }
}

public class FileUpload {
    public static void main(String[] args) {
        FileData file = new FileData();
        file.uploadFile();
        file.downloadFile();
    }
}
