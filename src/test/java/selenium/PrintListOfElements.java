package selenium;


import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PrintListOfElements {

    public static void main(String[] args) {
        WebDriver driver = WebDriverManager.chromedriver().create();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

//		driver.get("https://www.google.com");
//		List<WebElement> list = driver.findElements(By.xpath("//div[@id='SIvCob']/a"));
//
//		System.out.println(list.size());
//
//		for (WebElement i : list) {
//			String name = i.getText();
//			System.out.println(name);
//		}
//		driver.close();

        driver.get("https://www.amazon.com");
        //List<WebElement> list1 = driver.findElements(By.xpath("//div[@id='navFooter']/div/div/div[3]/ul/li[3]/a"));
        //List<WebElement> list1 = driver.findElements(By.xpath("//a[text()='Sell apps on Amazon']"));
        List<WebElement> list1 = driver.findElements(By.xpath("//a[@href='https://developer.amazon.com']"));

        for (WebElement i : list1) {
            String name = i.getText();
            System.out.println(name);

        }
        driver.close();
    }

}
	

