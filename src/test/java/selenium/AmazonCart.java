package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonCart {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

        //Hit the URL
        driver.get("https://www.amazon.com");


        //signin

        driver.findElement(By.xpath("//*[@id='nav-link-accountList-nav-line-1']")).click();


        //username:

        driver.findElement(By.xpath("//*[@id='ap_email']")).sendKeys("9948030579");

        driver.findElement(By.xpath("//*[@id='continue'] [@type='submit']")).click();


        //password:

        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("suresh@6919");

        driver.findElement(By.xpath("//*[@id='signInSubmit']")).click();


        //searching product:

        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("oneplus");

        driver.findElement(By.xpath("//*[@id='nav-search-submit-button']")).click();


        //List

        List<WebElement> oneplus = driver.findElements(By.xpath("//*[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));

        System.out.println(oneplus.size());


        for (int i = 0; i < oneplus.size(); i++) {

            String result = oneplus.get(i).getText();

            System.out.println(result);

            if (result.equalsIgnoreCase("ONEPLUS 10 Pro | 5G Android Smartphone | 6.7” QHD+ Display | 12GB+256GB | U.S. Unlocked | Triple Camera co-Developed with Hasselblad | Volcanic Black (NE2115)")) {
                oneplus.get(i).click();
                break;

            }

        }

        //add to cart
        driver.findElement(By.xpath("//*[@id='add-to-cart-button']")).click();

        //close the cart details
        driver.findElement(By.xpath("//*[@id='attach-close_sideSheet-link']")).click();

        //logout
        Actions action = new Actions(driver);
        WebElement ele = driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
        action.moveToElement(ele).perform();
        driver.findElement(By.xpath("//*[text()='Sign Out']")).click();

        //closing the browser
        driver.close();


    }


}





