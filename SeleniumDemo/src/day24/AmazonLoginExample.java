package day24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class AmazonLoginExample {

    public static void main(String[] args) throws IOException, InterruptedException {
        
       
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        props.load(fis);

        String email = props.getProperty("amazon.email");
        String password = props.getProperty("amazon.password");

        
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

      
        driver.get("https://www.amazon.in");

       
        driver.findElement(By.id("nav-link-accountList")).click();

      
        WebElement emailField = driver.findElement(By.id("ap_email_login"));
        emailField.sendKeys(email);
        driver.findElement(By.id("continue")).click();

       
        WebElement passwordField = driver.findElement(By.id("ap_password"));
        passwordField.sendKeys(password);
        driver.findElement(By.id("signInSubmit")).click();
        
        
        Thread.sleep(5000);
        
        
        WebElement inputbox = driver.findElement(By.id("twotabsearchtextbox"));
        inputbox.sendKeys("Laptop");


      
         driver.quit();
    }
}
