package SeleniumDemo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class EcommerceMouseScroll {

    

    public static void main(String[] args) {
    	 System.setProperty("webdriver.chrome.driver", "/Users/hammadafroz/Desktop/SeleniumDemo/chromedriver-mac-x64/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            driver.get("http://automationpractice.pl");

            // Hover over "Women" menu
            WebElement womenMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Women")));
            actions.moveToElement(womenMenu).pause(Duration.ofSeconds(1)).perform();
            System.out.println("Hovered over Women menu.");

            // Use CSS selector for T-shirts link (more reliable)
            WebElement tshirtLink = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("#block_top_menu > ul > li:nth-child(1) ul li a[title='T-shirts']")));
            tshirtLink.click();
            System.out.println("Clicked T-shirts link.");

            // Scroll to product
            js.executeScript("window.scrollBy(0, 500);");
            Thread.sleep(1000);

            // Hover over product to see Add to cart button
            WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product-container")));
            actions.moveToElement(product).pause(Duration.ofMillis(500)).perform();
            System.out.println("Hovered over product.");

            // Click Add to cart
            WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ajax_add_to_cart_button")));
            addToCartBtn.click();
            System.out.println("Clicked Add to cart.");

            // Wait for modal and click Proceed to checkout
            WebElement checkoutBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".button-container a[title='Proceed to checkout']")));
            checkoutBtn.click();
            System.out.println("Proceeding to checkout.");

            // Scroll down checkout page
            js.executeScript("window.scrollBy(0, 400);");
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
