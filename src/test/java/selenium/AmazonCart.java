package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class AmazonCart {
    public static void main(String[] args) {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));

        // Hit the URL
        driver.get("https://www.amazon.com");

        /*
         * signin with credentials
         * driver.findElement(By.xpath("//*[@id='nav-link-accountList-nav-line-1']")).
         * click();
         * driver.findElement(By.xpath("//*[@id='ap_email_login']")).sendKeys(
         * "+919948030579");
         * driver.findElement(By.xpath("//*[@type='submit']")).click();
         * driver.findElement(By.xpath("//*[@type='password']")).sendKeys("suresh@6919")
         * ;
         * driver.findElement(By.xpath("//*[@id='signInSubmit']")).click();
         */

        // searching product:

        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("oneplus");

        driver.findElement(By.xpath("//*[@id='nav-search-submit-button']")).click();

        // List

        List<WebElement> oneplus = driver.findElements(By.xpath(
                "//*[@class='a-link-normal s-line-clamp-2 puis-line-clamp-3-for-col-4-and-8 s-link-style a-text-normal']"));

        System.out.println("The number of OnePlus products found is: " + oneplus.size());

        for (int i = 0; i < oneplus.size(); i++) {

            String result = oneplus.get(i).getText();

            System.out.println("The product is: " + result);

            if (result.equalsIgnoreCase(
                    "ONEPLUS 15R, 12GB RAM + 256GB Storage, Dual-SIM, Unlocked Android Smartphone, Snapdragon 8 Gen 5, 7400mAh Battery, Mint Breeze")) {
                oneplus.get(i).click();
                break;

            }

        }

        // add to cart
        driver.findElement(By.xpath("//*[@name='submit.addToCart']")).click();

        // remove item from the cart
        driver.findElement(By.xpath("//*[@data-a-selector='decrement']")).click();

        // hovering on the account and clicking on sign in
        Actions action = new Actions(driver);
        WebElement ele = driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
        action.moveToElement(ele).perform();
        driver.findElement(By.xpath("//*[text()='Sign in']")).click();

        // closing the browser
        driver.close();

    }

}
