package test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardEventsUsingActions {
	public static void main(String[] args) throws InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Opening the URL
        driver.get("https://demoqa.com/text-box");

        // Create object of the Actions class
        Actions actions = new Actions(driver);
        Robot robot = new Robot();

        // Enter the Full Name
        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Mr.PHUOC PHAN");
        Thread.sleep(2000);

        // Enter the Email
        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("pitsolutions3010@gmail.com");
        Thread.sleep(2000);

        // Zoom in
        System.out.println("About to zoom in");
        for (int i = 0; i < 5; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ADD);
            robot.keyRelease(KeyEvent.VK_ADD);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(1000);
        }

        // Zoom out
        System.out.println("About to zoom out");
        for (int i = 0; i < 4; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(1000);
        }

        // Enter the Current Address
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("139 đường 14, Vĩnh Phú, Thuận An, Bình Dương");
        Thread.sleep(2000);

        // Select the Current Address using CTRL+A
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();

        // Copy the Current Address using CTRL+C
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();

        // Press the TAB Key to Switch Focus to Permanent Address
        actions.sendKeys(Keys.TAB).build().perform();

        // Paste the Address in the Permanent Address field using CTRL+V
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
        Thread.sleep(2000);

        // Compare Text of current Address and Permanent Address
        if (currentAddress.getAttribute("value").equals(permanentAddress.getAttribute("value"))) {
            System.out.println("PASS");
        }

        driver.close();
    }
}
