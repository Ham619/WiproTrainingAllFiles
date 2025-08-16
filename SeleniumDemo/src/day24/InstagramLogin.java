package day24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class InstagramLogin {
    public static void main(String[] args) throws InterruptedException {
        Properties props = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            props.load(fis);
       

        String username = props.getProperty("insta.username");
        String password = props.getProperty("insta.password");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://www.instagram.com/accounts/login/");

        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        
    	Thread.sleep(5000);
        
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
}
