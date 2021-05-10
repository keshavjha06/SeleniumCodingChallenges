package seleniumchallenge;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoomInAndZoomOut {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.iplt20.com");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		//zoomin to 200%
		String zoomInScript = "document.body.style.zoom='200%'";
		jse.executeScript(zoomInScript);
		
		Thread.sleep(3000);
		
		//zoomout to 50%
		
		String zoomoutScript = "document.body.style.zoom='50%'";
		jse.executeScript(zoomoutScript);
		
		Thread.sleep(3000);

		
		//default zoom level
		
		String defaultZoomLevel = "document.body.style.zoom='100%'";
		jse.executeScript(defaultZoomLevel);
		
		Thread.sleep(3000);

		
		//get page Title
		String pageTitle = driver.getTitle();
		
		System.out.println("Page Title is : " +pageTitle);
		driver.close();
		
		


	}

}
