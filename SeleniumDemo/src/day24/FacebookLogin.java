package day24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class FacebookLogin {
    public static void main(String[] args) throws IOException {

    	try {
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        props.load(fis);

        String fbUsername = props.getProperty("fb.username");
        String fbPassword = props.getProperty("fb.password");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://www.facebook.com/");

        driver.findElement(By.id("email")).sendKeys(fbUsername);
        driver.findElement(By.id("pass")).sendKeys(fbPassword);
        driver.findElement(By.name("login")).click();
        
        
		Thread.sleep(5000);
			
		driver.quit();
		} 
    	catch (InterruptedException e) {
			e.printStackTrace();
		}
    	

       
         
    }
}
