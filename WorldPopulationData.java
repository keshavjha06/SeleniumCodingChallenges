package seleniumchallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorldPopulationData {

static WebDriver driver;

	

	public static void main(String[] args) throws InterruptedException {
		String xpath_currentpop = "//div[@class='maincounter-number']/span[@class='rts-counter']";
		
		String xpath_today_thisYear_pop =  "//div[text()='This year' or text()='Today']//parent::div//span[@class='rts-counter']";

		
	
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.worldometers.info/world-population/");
		int count = 1;
		while(count<=20) {
			System.out.println(count + "sec");
			if(count==21)
			break;
		System.out.println("-----------current population count--------");
		printPopData(xpath_currentpop);
		System.out.println("-----------Today and This year population count--------");

		printPopData(xpath_today_thisYear_pop);
		System.out.println("==================================================");

		Thread.sleep(1000);
		count++;
		}

	}
	
	public static void printPopData(String locator) throws InterruptedException 
	{
//		
//			List<WebElement> popList = driver.findElements(By.xpath(locator));
//			for(WebElement e: popList) 
//			{
//				System.out.println(e.getText());
//			}
			driver.findElements(By.xpath(locator)).stream().forEach(e -> System.out.println(e.getText()));
			
		}
	}

	

