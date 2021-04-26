package seleniumcodingchallenges;
import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandlingPushNotifications {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.redbus.in");
		String pageTitle = driver.getTitle();
		System.out.println("Page Title is : " +pageTitle);
		driver.close();
		
		

	}

}
