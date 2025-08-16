package day25;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BookAppointmentTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        // Load test data from config.properties
        Properties props = new Properties();
        props.load(new FileInputStream("src/test/resources/config.properties"));
        String firstName = props.getProperty("appointment.firstname");
        String lastName = props.getProperty("appointment.lastname");
        String city = props.getProperty("appointment.city");
        String phone = props.getProperty("appointment.phone");
        String email = props.getProperty("appointment.email");
       

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        try {
            driver.get("https://360homedecor.uk/book-appointment");

            WebElement brandDropdown = driver.findElement(By.xpath("//select[@id='choose_branch']"));
            Select select = new Select(brandDropdown);
            select.selectByVisibleText("360");
            Thread.sleep(2000);
            
            WebElement styleDropdown = driver.findElement(By.xpath("//select[@id='choose_style']"));
            Select style1 = new Select(styleDropdown);
            style1.selectByVisibleText("Modern");
            Thread.sleep(2000);


            
            driver.findElement(By.name("first_name")).sendKeys(firstName);
            Thread.sleep(2000);
            driver.findElement(By.name("last_name")).sendKeys(lastName);
            Thread.sleep(2000);
            driver.findElement(By.name("apt_city")).sendKeys(city);
            Thread.sleep(2000);
            driver.findElement(By.name("phone_number")).sendKeys(phone);
            Thread.sleep(2000);
            driver.findElement(By.name("email")).sendKeys(email);
            
            Thread.sleep(2000);

         
           
            driver.findElement(By.xpath("//button[@type='submit']")).click();

            System.out.println("Appointment form submitted successfully!");

        } finally {
            driver.quit();
        }
    }
}
