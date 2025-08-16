package SeleniumDemo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class EcommercePurchaseBot {

   

    public static void main(String[] args) {
    	System.setProperty("webdriver.chrome.driver", "/Users/hammadafroz/Desktop/SeleniumDemo/chromedriver-mac-x64/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            driver.get("https://www.demoblaze.com/");

            // 1️⃣ Add first Laptop to cart (using helper with retries)
            clickFirstProductInCategory(driver, wait, "Laptops");
            addCurrentProductToCart(driver, wait);

            // 2️⃣ Add first Phone to cart
            safeGoHome(driver, wait);
            clickFirstProductInCategory(driver, wait, "Phones");
            addCurrentProductToCart(driver, wait);

            // 3️⃣ Go to Cart and Purchase
            driver.findElement(By.linkText("Cart")).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-success"))).click(); // Place Order

            // Fill in order form
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).sendKeys("Hammad Afroz");
            driver.findElement(By.id("country")).sendKeys("Pakistan");
            driver.findElement(By.id("city")).sendKeys("Karachi");
            driver.findElement(By.id("card")).sendKeys("4111111111111111");
            driver.findElement(By.id("month")).sendKeys("12");
            driver.findElement(By.id("year")).sendKeys("2025");

            // Purchase
            driver.findElement(By.xpath("//button[text()='Purchase']")).click();

            // Get confirmation details
            WebElement confirmationBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sweet-alert")));
            System.out.println("\n=== Purchase Confirmation ===\n" + confirmationBox.getText());

            // Close confirmation
            driver.findElement(By.xpath("//button[text()='OK']")).click();

            System.out.println("\nAutomation complete.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Always quit
            driver.quit();
        }
    }

    /**
     * Clicks the first product in the given category.
     * Uses retries and always re-finds elements after navigation to avoid stale element exceptions.
     */
    private static void clickFirstProductInCategory(WebDriver driver, WebDriverWait wait, String category) {
        final int MAX_RETRIES = 3;
        int attempt = 0;

        while (attempt < MAX_RETRIES) {
            try {
                // Click category link and wait for product cards to be present
                wait.until(ExpectedConditions.elementToBeClickable(By.linkText(category))).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-title a")));

                // Re-find product links and click the first one
                List<WebElement> products = driver.findElements(By.cssSelector(".card-title a"));

                if (products.isEmpty()) {
                    throw new NoSuchElementException("No products found in category: " + category);
                }

                // click the first product (re-locate just before clicking)
                WebElement firstProduct = products.get(0);
                wait.until(ExpectedConditions.elementToBeClickable(firstProduct));
                firstProduct.click();

                // Wait for product details page to load (product name visible)
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".name")));
                return; // success
            } catch (StaleElementReferenceException | NoSuchElementException | TimeoutException ex) {
                attempt++;
                System.out.println("Attempt " + attempt + " failed for category '" + category + "'. Retrying...");
                // small fallback: reload home and try again (keeps DOM stable)
                safeGoHome(driver, wait);
            }
        }

        throw new RuntimeException("Failed to click first product in category: " + category + " after retries.");
    }

    /**
     * Clicks "Add to cart" on the current product page, accepts the alert.
     * Waits appropriately for elements and alert.
     */
    private static void addCurrentProductToCart(WebDriver driver, WebDriverWait wait) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add to cart"))).click();
            // wait for and accept alert
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();

            // give a tiny pause so DemoBlaze updates (not Thread.sleep long, just a short implicit pause)
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cartur"))); // ensure cart link exists
            System.out.println("Product added to cart.");
        } catch (TimeoutException te) {
            throw new RuntimeException("Add to cart failed: " + te.getMessage(), te);
        }
    }

    /**
     * Navigates to the Home page safely and waits for the top product list to show.
     */
    private static void safeGoHome(WebDriver driver, WebDriverWait wait) {
        try {
            // Click Home, then wait for the page to be ready
            driver.findElement(By.linkText("Home")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-title a")));
        } catch (Exception e) {
            // As a fallback, do a direct get to the homepage URL
            driver.get("https://www.demoblaze.com/");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-title a")));
        }
    }
}
