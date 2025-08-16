package SeleniumDemo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class Example {
    public static void main(String[] args) throws InterruptedException {

        
        System.setProperty("webdriver.chrome.driver", "/Users/hammadafroz/Desktop/SeleniumDemo/chromedriver-mac-x64/chromedriver");

        WebDriver driver = new ChromeDriver();

 
        
        driver.get("https://www.google.com");
		Thread.sleep(2000);
 
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.facebook.com");
		Thread.sleep(2000);
 
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.youtube.com");
		Thread.sleep(2000);;
       
        driver.quit();
    }
        
}
