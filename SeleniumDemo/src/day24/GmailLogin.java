package day24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class GmailLogin {
    public static void main(String[] args) throws IOException {
        
       
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        props.load(fis);
        String email = props.getProperty("gmail.email");
        String password = props.getProperty("gmail.password");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://mail.google.com/");

       
        driver.findElement(By.id("identifierId")).sendKeys(email);
        driver.findElement(By.id("identifierNext")).click();

        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Passwd")));
        driver.findElement(By.name("Passwd")).sendKeys(password);
        driver.findElement(By.id("passwordNext")).click();

        
 
        
        System.out.println("Login attempt completed.");

        driver.quit();
    }
}
