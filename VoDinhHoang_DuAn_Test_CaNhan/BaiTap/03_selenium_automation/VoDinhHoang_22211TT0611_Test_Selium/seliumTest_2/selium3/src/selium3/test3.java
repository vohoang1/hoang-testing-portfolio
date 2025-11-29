package selium3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test3 {
    public static void main(String[] args) throws InterruptedException {
        // Setting up Chrome driver
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigating to the URL
        driver.get("https://demo.guru99.com/test/delete_customer.php");

        // Entering customer ID and submitting
        driver.findElement(By.name("cusid")).sendKeys("22558899");
        driver.findElement(By.name("submit")).submit();

        // Switching to Alert
        Alert alert = driver.switchTo().alert();

        // Capturing alert message
        String alertMessage = alert.getText();

        // Displaying alert message
        System.out.println(alertMessage);
        Thread.sleep(3000);

        // Accepting alert
        alert.accept();

        // Entering new customer ID and submitting
        driver.findElement(By.name("cusid")).sendKeys("12345");
        driver.findElement(By.name("submit")).click();
        Thread.sleep(3000);

        // Cancelling alert
        alert.dismiss();
        Thread.sleep(3000);

        // Clicking on reset button
        driver.findElement(By.name("res")).click();

        // Closing the browser
        driver.quit();
    }
}
