package AutoTest2;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class UploadWith {
	public static void main(String[] args) throws AWTException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".btn.btn-success.fileinput-button")).click();
        Thread.sleep(3000); // Wait for file dialog to open

        String filePath = "D:\\PLT.png"; // Specify your file path here
        uploadFileWithRobot(filePath);

        Thread.sleep(3000); // Wait for file upload
        driver.quit();
    }

    public static void uploadFileWithRobot(String filePath) throws AWTException {
        StringSelection ss = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        Robot robot = new Robot();
        robot.delay(1000); // Add a delay for the file dialog to be ready
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(1000); // Add a delay before hitting Enter
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}
