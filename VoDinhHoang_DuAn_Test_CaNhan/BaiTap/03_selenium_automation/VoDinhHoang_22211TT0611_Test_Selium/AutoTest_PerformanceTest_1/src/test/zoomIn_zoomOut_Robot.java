package test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class zoomIn_zoomOut_Robot {
	 public static void main(String[] args) throws AWTException, InterruptedException {
	        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        // Opening the URL
	        driver.get("https://xaydungphanmem.com");
	        Thread.sleep(1000);

	        Robot robot = new Robot();

	        // Zoom in
	        System.out.println("About to zoom in");
	        for (int i = 0; i < 5; i++) {
	            robot.keyPress(KeyEvent.VK_CONTROL);
	            robot.keyPress(KeyEvent.VK_ADD);
	            robot.keyRelease(KeyEvent.VK_ADD);
	            robot.keyRelease(KeyEvent.VK_CONTROL);
	            Thread.sleep(1000);
	        }

	        // Reset zoom to 100%
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_0);
	        robot.keyRelease(KeyEvent.VK_0);
	        robot.keyRelease(KeyEvent.VK_CONTROL);

	        // Zoom out
	        System.out.println("About to zoom out");
	        for (int i = 0; i < 3; i++) {
	            robot.keyPress(KeyEvent.VK_CONTROL);
	            robot.keyPress(KeyEvent.VK_SUBTRACT);
	            robot.keyRelease(KeyEvent.VK_SUBTRACT);
	            robot.keyRelease(KeyEvent.VK_CONTROL);
	            Thread.sleep(1000);
	        }

	        driver.quit();
	    }
}
