package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RefreshPage {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com/");
        driver.manage().window().maximize();
        driver.navigate().refresh();

        driver.get("https://www.facebook.com");
        driver.get(driver.getCurrentUrl());

        driver.get("https://www.yahoo.com");
        driver.navigate().to(driver.getCurrentUrl());

        driver.get("https://www.guru99.com");
        driver.findElement(By.id("gsc-i-id2")).sendKeys(Keys.F5);

        driver.close();

    }

}
