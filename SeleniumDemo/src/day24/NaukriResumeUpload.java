package day24;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NaukriResumeUpload {

    public static void main(String[] args) throws InterruptedException, IOException {

        
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        props.load(fis);

        String email = props.getProperty("naukri.email");
        String password = props.getProperty("naukri.password");
        String resumePath = props.getProperty("resume.path");
       

       

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
           
            driver.get("https://www.naukri.com/nlogin/login");
            driver.get("https://www.facebook.com/help/ipreporting/report/copyright");
            driver.get("https://www.instagram.com/accounts/login/?hl=en");
            driver.get("")

            
            driver.findElement(By.id("usernameField")).sendKeys(email);
            driver.findElement(By.id("passwordField")).sendKeys(password);
            driver.findElement(By.xpath("//button[text()='Login']")).click();

            Thread.sleep(5000);

            
            driver.get("https://www.naukri.com/mnjuser/profile");
            Thread.sleep(5000);

          
            File resumeFile = new File(resumePath);
            WebElement uploadInput = driver.findElement(By.className("dummyUpload"));
            uploadInput.sendKeys(resumeFile.getAbsolutePath());

            Thread.sleep(5000);
            System.out.println("Resume uploaded successfully!");

        } finally {
            driver.quit();
        }
    }
}
