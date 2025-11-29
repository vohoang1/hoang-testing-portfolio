package selium2;
import java.util.HashSet;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class test {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://chercher.tech/practice/dropdowns");

        Set<String> expect_result = new HashSet<>();
        expect_result.add("Bing");
        expect_result.add("Google");
        expect_result.add("Iphone 14");
        expect_result.add("Yahoo");

        WebElement actualDropdown = driver.findElement(By.id("order-same"));
        Select actual = new Select(actualDropdown);

        actualDropdown.click();
        Thread.sleep(2000);
        actualDropdown.click();

        Set<String> actual_result = new HashSet<>();
        for (WebElement option : actual.getOptions()) {
            actual_result.add(option.getText());
        }

        if (expect_result.equals(actual_result)) {
            System.out.println("Kết quả thực tế đúng với Kết quả mong đợi");
        } else {
            System.out.println("Kết quả thực tế khác kết quả mong đợi");
            System.out.println("Kết quả mong đợi: " + expect_result.toString());
            System.out.println("Kết quả thực tế: " + actual_result.toString());
        }

        String default_value_expect = "Samsung";
        if (actual.getFirstSelectedOption().getText().equals(default_value_expect)) {
            System.out.println("Giá trị mặc định của DropDown List đúng PASS");
        } else {
            System.out.println("Giá trị mặc định của DropDown List không đúng FAIL");
            System.out.println("Kết quả mong đợi là: " + default_value_expect);
            System.out.println("Kết quả thực tế là: " + actual.getFirstSelectedOption().getText());
        }

        driver.quit();
    }
}
