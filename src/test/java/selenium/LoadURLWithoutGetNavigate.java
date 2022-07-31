package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoadURLWithoutGetNavigate {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        // We need to downcast WebDriver reference varaible to use JavascriptExecutor methods
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String url = "https://www.google.com";
        String script = "window.location = \'" + url + "\'";
        js.executeScript(script);
        System.out.println(driver.getCurrentUrl());
        String script1 = "window.location = \'http://facebook.com'";
        js.executeScript(script1);
        System.out.println(driver.getCurrentUrl());
        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());
        driver.navigate().forward();
        System.out.println(driver.getCurrentUrl());
        driver.quit();
    }
}

