package day25;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class FlipkartExample {

    public static void main(String[] args) throws IOException, InterruptedException {

        
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        props.load(fis);

        String email = props.getProperty("flipkart.email");


        
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

       
        driver.get("https://www.flipkart.com/");

       
        try {
            WebElement closePopup = driver.findElement(By.cssSelector("button._2KpZ6l._2doB4z"));
            closePopup.click();
        } catch (Exception e) {
            System.out.println("No login popup appeared.");
        }

      
        driver.findElement(By.xpath("//span[normalize-space()='Login']")).click();

        WebElement emailField = driver.findElement(By.xpath("//input[@class='r4vIwl BV+Dqf']"));
        emailField.sendKeys(email);


//        driver.findElement(By.className("QqFHMw")).click();

        Thread.sleep(25000); 

       
        List<String> products = new ArrayList<>();
        products.add("Charger");
        products.add("phone");
        products.add("speaker");

        for (String product : products) {
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.clear();
            searchBox.sendKeys(product, Keys.ENTER);

            Thread.sleep(3000);

           
            WebElement firstProduct = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/a[1]/div[2]/div[1]/div[1]"));
            firstProduct.click();


            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

           
            try {
                WebElement addToCart = driver.findElement(By.xpath("//button[normalize-space()='Add to cart']"));
                addToCart.click();
                System.out.println(product + " added to cart successfully!");
            } catch (Exception e) {
                System.out.println("Add to cart button not found for " + product);
            }

            Thread.sleep(3000);

         
            driver.close();
            driver.switchTo().window(tabs.get(0));
        }

        
        driver.quit();
    }
}
