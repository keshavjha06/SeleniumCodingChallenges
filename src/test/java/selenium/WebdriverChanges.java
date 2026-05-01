package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebdriverChanges {
    public static void main(String[] args) {
        // WebDriver driver = new ChromeDriver(); - selenium manager 

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = WebDriverManager.chromedriver().capabilities(options).create();
        driver.get("https://www.facebook.com");
        System.out.println("Title of the page is : " + driver.getTitle());
        driver.close();

    }

}
