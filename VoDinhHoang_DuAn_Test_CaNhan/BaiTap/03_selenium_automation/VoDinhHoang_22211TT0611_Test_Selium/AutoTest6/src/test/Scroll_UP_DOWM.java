package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class Scroll_UP_DOWM {
	public static void main(String[] args) throws InterruptedException {
        // Setting system properties for ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        // Creating a WebDriver instance
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Opening the web page
        driver.get("https://xaydungphanmem.com/");
        Thread.sleep(2000);

        // Creating a JavascriptExecutor instance
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scrolling down by 6500 pixels
        js.executeScript("window.scrollBy(0,6500)");
        Thread.sleep(2000);

        // Scrolling up by 8000 pixels
        js.executeScript("window.scrollBy(0,-8000)");
        Thread.sleep(2000);

        // Scrolling down by 3000 pixels
        js.executeScript("window.scrollBy(0,3000)");
        Thread.sleep(2000);

        // Scrolling to the bottom of the page
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(2000);

        // Finding an element on the page
        WebElement any_element = driver.findElement(By.xpath("//*[@id=\"page\"]/main/div[2]/div/div[2]/div[1]"));

        // Scroll the page horizontally till the element is found
        js.executeScript("arguments[0].scrollIntoView();", any_element);
        Thread.sleep(2000);

        // Closing the browser
        driver.quit();
    }
}
