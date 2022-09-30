package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortPrices {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        String ele = driver.findElement(By.xpath("//div[contains(@class,'a-section')]")).getText();
        String[] string = ele.split(" ");
        String s = string[3];
        System.out.println(s);
        List<WebElement> element = driver.findElements(By.xpath("//a[contains(@class,'a-size-base')]/descendant::*[@class='a-price-whole']"));
        ArrayList<Integer> list = new ArrayList<>();
        for(WebElement elements : element){
            String str = elements.getText().replaceAll(",","");
            list.add(Integer.parseInt(str));
        }
        Collections.sort(list);
        System.out.println(list);
        driver.close();
    }
}
