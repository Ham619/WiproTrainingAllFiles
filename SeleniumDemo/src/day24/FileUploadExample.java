package day24;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class FileUploadExample {
 
	public static void main(String[] args)
	{
		 System.setProperty("webdriver.chrome.driver", "/Users/hammadafroz/Desktop/SeleniumDemo/chromedriver-mac-x64/chromedriver");
	     WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		
		try
		{
			driver.get("http://the-internet.herokuapp.com/upload");
			File uploadFile=new File("/Users/hammadafroz/Desktop/Hello.txt");
			WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));
			fileInput.sendKeys(uploadFile.getAbsolutePath());
			driver.findElement(By.id("file-submit")).click();
			String resultText = driver.findElement(By.id("uploaded-files")).getText();

			
			System.out.println("Uploaded: " +resultText);
		}
		finally
		{
			driver.quit();
		}
		
	}
 
}