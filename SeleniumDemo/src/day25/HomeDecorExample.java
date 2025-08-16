package day25;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class HomeDecorExample {

    public static void main(String[] args) throws IOException, InterruptedException {
        
       
        ;

       

        
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

      
        driver.get("https://360homedecor.uk/contact-us");

       
      

      
        WebElement name = driver.findElement(By.xpath("//input[@placeholder='Name *']"));
        name.sendKeys("Hammad");
    

       
        WebElement emailId = driver.findElement(By.xpath("//input[@placeholder='Email *']"));
        emailId.sendKeys("hammadafroz007@gmail.com");
        
        WebElement mobile = driver.findElement(By.xpath("//input[@id='mobile_phone']"));
        
        mobile.sendKeys("7061292019");
        
        Thread.sleep(5000);
        
        driver.findElement(By.className("btn--md")).click();
        
        
        
     
       
         
        
  
  
    }
}

