package SeleniumDemo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.List;
import java.time.Duration;

public class GoogleSearchAutomation {

    public static void main(String[] args) {
        // Set ChromeDriver path if not in system PATH
    	 System.setProperty("webdriver.chrome.driver", "/Users/hammadafroz/Desktop/SeleniumDemo/chromedriver-mac-x64/chromedriver");

        // Optional: Run in headless mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        // options.addArguments("--headless"); // Uncomment if no browser UI needed

        WebDriver driver = new ChromeDriver(options);

        try {
            // 1. Navigate to Google
            driver.get("https://www.google.com");

            // 2. Accept cookies / handle popups if any (Google may show it based on location)
            try {
                WebElement agreeButton = driver.findElement(By.xpath("//div[text()='I agree' or text()='Accept all']"));
                agreeButton.click();
            } catch (Exception e) {
                // Ignore if not present
            }

            // 3. Enter search term
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("Selenium Web");

            // 4. Submit search
            searchBox.submit();

            // Wait for results to load
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            // 5. Get the titles of first few results
            List<WebElement> results = driver.findElements(By.cssSelector("h3"));
            System.out.println("Top Google Search Results:");
            for (int i = 0; i < Math.min(results.size(), 5); i++) {
                System.out.println((i + 1) + ". " + results.get(i).getText());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6. Close browser
            driver.quit();
        }
    }
}
