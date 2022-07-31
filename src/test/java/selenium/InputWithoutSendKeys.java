package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InputWithoutSendKeys {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.tutorialspoint.com/index.htm");
        // JavaScript Executor to enter text
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("document.getElementById('gsc-i-id1').value='Selenium'");
        WebElement l = driver.findElement(By.id("gsc-i-id1"));
        String s = l.getAttribute("value");
        System.out.println("Value entered is: " + s);
        driver.quit();

    }

}
