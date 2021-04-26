package seleniumcodingchallenges;
import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ZoomInAndZoomOut {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com");
		String pageTitle = driver.getTitle();
		System.out.println("Page Title is : " +pageTitle);
		driver.close();
		
		

	}

}
