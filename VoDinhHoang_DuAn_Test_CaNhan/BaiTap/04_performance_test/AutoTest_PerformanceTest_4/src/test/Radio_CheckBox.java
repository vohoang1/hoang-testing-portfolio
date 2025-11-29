package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Radio_CheckBox {
	 public static void main(String[] args) throws InterruptedException {
	        // Setting system properties for ChromeDriver
	        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

	        // Creating a WebDriver instance
	        WebDriver driver = new ChromeDriver();

	        // Opening the web page
	        driver.get("https://demo.guru99.com/test/radio.html");

	        // Finding the radio buttons
	        WebElement radio1 = driver.findElement(By.id("vfb-7-1"));
	        WebElement radio2 = driver.findElement(By.id("vfb-7-2"));

	        // Selecting Radio Button1
	        radio1.click();
	        Thread.sleep(2000);
	        System.out.println("Radio Button Option 1 Selected");

	        // Selecting Radio Button2
	        radio2.click();
	        System.out.println("Radio Button Option 2 Selected");
	        Thread.sleep(2000);

	        // Finding the checkboxes
	        WebElement option1 = driver.findElement(By.id("vfb-6-0"));
	        WebElement option3 = driver.findElement(By.id("vfb-6-2"));

	        // Toggling checkbox option1
	        option1.click();
	        Thread.sleep(2000);
	        
	        // Toggling checkbox option3
	        option3.click();
	        Thread.sleep(2000);

	        // Toggling checkbox option3 again
	        option3.click();
	        Thread.sleep(2000);

	        // Toggling checkbox option1 again
	        option1.click();
	        Thread.sleep(2000);

	        // Toggling checkbox option3 again
	        option3.click();
	        Thread.sleep(2000);

	        // Checking if both checkboxes are toggled on
	        if (option1.isSelected() && option3.isSelected()) {
	            System.out.println("2 Checkboxes is Toggled On");
	        } else {
	            System.out.println("Checkboxes are not toggled on properly");
	        }

	        // Closing the browser
	        driver.quit();
	    }
}
