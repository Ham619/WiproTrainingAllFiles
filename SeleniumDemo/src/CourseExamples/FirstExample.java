package CourseExamples;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.print.PageMargin;
import org.openqa.selenium.print.PageSize;
import org.openqa.selenium.print.PrintOptions;

import java.time.Duration;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class FirstExample {
    public static void main(String[] args) throws IOException, InterruptedException {
        
 

       
        WebDriver driver = new ChromeDriver();
        
//        driver.get("https://www.actitime.com/");
//        
//        driver.findElement(By.linkText("Try actiTIME for Free")).click();
//        
//        Thread.sleep(5000);
//        
//        driver.findElement(By.id("FirstName")).sendKeys("Hammad");
//        driver.findElement(By.id("LastName")).sendKeys("Afroz");
//        driver.findElement(By.id("Email")).sendKeys("hamadafroz007@gmail.com");
//        driver.findElement(By.id("Company")).sendKeys("Wipro");
//        
//        String title = driver.getTitle();
//        System.out.println(title);
//        
//        driver.findElement(By.id("confirm-button")).click();
        
//        driver.get("https://www.selenium.dev/");
//        PrintOptions printOptions = new PrintOptions();
//        printOptions.setOrientation(PrintOptions.Orientation.LANDSCAPE);
//        PrintOptions.Orientation current_orientation = printOptions.getOrientation();
//        System.out.println(current_orientation);
//        
        driver.get("https://www.selenium.dev/");
        PrintOptions printOptions1 = new PrintOptions();
        printOptions1.setPageRanges("1-2");
        String[] current_range = printOptions1.getPageRanges();
        System.out.println("current_range "+current_range);
       
        driver.get("https://www.selenium.dev/");
        PrintOptions printOptions = new PrintOptions();
        printOptions.setPageSize(new PageSize(27.94, 21.59)); 
        double currentHeight = printOptions.getPageSize().getHeight();
        System.out.println("currentHeight "+currentHeight);
        
        driver.get("https://www.selenium.dev/");
        PrintOptions printOptions11 = new PrintOptions();
        PageMargin margins = new PageMargin(1.0,1.0,1.0,1.0);
        printOptions11.setPageMargin(margins);
        double topMargin = margins.getTop();
        double bottomMargin = margins.getBottom();
        double leftMargin = margins.getLeft();
        double rightMargin = margins.getRight();
        System.out.println("topMargin:"+topMargin+" bottomMargin"+bottomMargin+" leftMatgin:"+leftMargin+" rightMargin:"+rightMargin);
        
        driver.get("https://www.selenium.dev/");
        PrintOptions printOptions2 = new PrintOptions();
        printOptions2.setScale(.50);
        double current_scale = printOptions2.getScale();
        System.out.println("current_scale "+current_scale);
        
        driver.get("https://www.selenium.dev/");
        PrintOptions printOptions3 = new PrintOptions();
        printOptions3.setBackground(true);
        boolean current_background = printOptions3.getBackground();
        System.out.println("current_background "+current_background);
        
        driver.get("https://www.selenium.dev/");
        PrintOptions printOptions4 = new PrintOptions();
        printOptions4.setShrinkToFit(true);
        boolean current_shrink_to_fit = printOptions4.getShrinkToFit();
        System.out.println("current_shrink_to_fit "+current_shrink_to_fit);
    }
}
