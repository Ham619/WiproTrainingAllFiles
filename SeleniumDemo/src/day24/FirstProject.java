package day24;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstProject {

    public static void main(String[] args) {
        runTestInChrome();
        runTestInFirefox();
        runTestInEdge();
    }

    public static void runTestInChrome() {
        System.setProperty("webdriver.chrome.driver", "/Users/hammadafroz/Desktop/SeleniumDemo/chromedriver-mac-x64/chromedriver");
        WebDriver driver = new ChromeDriver();
        runTest(driver, "Chrome");
    }

    public static void runTestInFirefox() {
        System.setProperty("webdriver.gecko.driver", "/Users/hammadafroz/Desktop/SeleniumDemo/geckodriver");
        WebDriver driver = new FirefoxDriver();
        runTest(driver, "Firefox");
    }

    public static void runTestInEdge() {
        System.setProperty("webdriver.edge.driver", "/Users/hammadafroz/Desktop/SeleniumDemo/msedgedriver");
        WebDriver driver = new EdgeDriver();
        runTest(driver, "Edge");
    }

    public static void runTest(WebDriver driver, String browserName) {
        try {
            driver.get("https://www.google.com");
            System.out.println(browserName + " Title: " + driver.getTitle());
        } finally {
            driver.quit();
        }
    }
}


