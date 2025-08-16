package day25;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class MyntraExample {

    public static void main(String[] args) throws IOException, InterruptedException {
        
       
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        props.load(fis);

        String phone = props.getProperty("myntra.phone");
        

        
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

      
        driver.get("https://www.myntra.com/");

       
        driver.findElement(By.id("nav-link-accountList")).click();

      
        WebElement emailField = driver.findElement(By.id("ap_email_login"));
        emailField.sendKeys(email);
        driver.findElement(By.id("continue")).click();

       
        WebElement passwordField = driver.findElement(By.id("ap_password"));
        passwordField.sendKeys(password);
        driver.findElement(By.id("signInSubmit")).click();
        
        
        Thread.sleep(5000);
       
         
         List<String> products = new ArrayList<>();
         products.add("laptop");
         products.add("camera");
         products.add("Speaker");
         for (String product : products) {
             
             WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
             searchBox.clear();
             searchBox.sendKeys(product);
             driver.findElement(By.id("nav-search-submit-button")).click();
             driver.findElement(By.cssSelector("#a-autoid-3-announce")).click();
             Thread.sleep(3000);
  
  
    }
}
}
