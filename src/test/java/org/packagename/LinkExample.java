package org.packagename;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkExample {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://leafground.com/");

		WebElement linkBtn = driver.findElement(By.xpath("//*[@alt='Link']"));
		linkBtn.click();
		//1. Clicking the first link
		WebElement goToHomePage = driver.findElement(By.linkText("Go to Home Page"));
		goToHomePage.click();

		driver.navigate().back();
		
		//2. Clicking the second link in the web page
		WebElement whereIWillGo = driver.findElement(By.partialLinkText("Find where am"));
		String s = whereIWillGo.getAttribute("href");
		System.out.println("This link will go to:" + s);

		//3. Checking whether the third link in the web page is broken link or not
		WebElement verifyIamBroken = driver.findElement(By.linkText("Verify am I broken?"));
		verifyIamBroken.click();

		String title = driver.getTitle();

		if (title.contains("404")) {
			System.out.println("The link is a broken link");
			
		} else {
			System.out.println("The link is not a broken link");
		}
		
		driver.navigate().back();
		
		//4. When we click the 4 link with the goHomPage.click(); 
		//element name then we will get "Stale element reference exception" to overcome that we 
		//find the locator again.
		Thread.sleep(3000);
		WebElement goToHomePage1 = driver.findElement(By.linkText("Go to Home Page"));
		goToHomePage1.click();
		
		driver.navigate().back();

		List<WebElement> totalLinks = driver.findElements(By.tagName("a"));
		int noOfLinks = totalLinks.size();
		System.out.println("Total number of links in the webpage is:" + noOfLinks);
		
		//5. To Print the name of the links in the console
		for(int i=0;i<totalLinks.size();i++) {
			WebElement element=totalLinks.get(i);
			System.out.println(element.getText());
			
			
		}

	}
}
