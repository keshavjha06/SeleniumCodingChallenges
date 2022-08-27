package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TableCellValue {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://the-internet.herokuapp.com/challenging_dom");
        // identify table
        WebElement t = driver.findElement(By.xpath("//div[@class='large-10 columns']/descendant::tbody"));
        // count rows with size() method
        List<WebElement> rws = t.findElements(By.tagName("tr"));
        int rws_cnt = rws.size();
        System.out.println(rws_cnt);
        //iterate rows of table
        for (int i = 0; i < rws_cnt; i++) {
            // count columns with size() method
            List<WebElement> cols = rws.get(i).findElements(By.tagName("td"));
            int cols_cnt = cols.size();
            //iterate cols of table
            for (int j = 0; j < cols_cnt; j++) {
                // get cell text with getText()
                String c = cols.get(j).getText();
                System.out.println("The cell value is: " + c);
            }
        }
        driver.quit();
    }
}
