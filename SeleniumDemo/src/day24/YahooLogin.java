package day24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class YahooLogin {
    public static void main(String[] args) throws IOException, InterruptedException {
        
       
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        props.load(fis);

        String email = props.getProperty("yahoo.email");
        String password = props.getProperty("yahoo.password");

       
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        
        driver.get("https://login.yahoo.com/");

        
        driver.findElement(By.id("login-username")).sendKeys(email);
        driver.findElement(By.id("login-signin")).click();

      
        driver.findElement(By.id("login-passwd")).sendKeys(password);
        driver.findElement(By.id("login-signin")).click();
        
        Thread.sleep(5000);

        System.out.println("Login attempted. Check for CAPTCHA or 2FA manually.");

        driver.quit();
    }
}
