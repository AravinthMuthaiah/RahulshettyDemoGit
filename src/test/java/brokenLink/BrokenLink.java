package brokenLink;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLink {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total Number of links is:" + links.size());

		int brokenLinkCount = 0, notABrokenLinkCount = 0;

		for (int i = 0; i < links.size(); i++) {
			WebElement link = links.get(i);
			String attribute = link.getAttribute("href");

			URL url = new URL(attribute);
			HttpURLConnection httpconnection = (HttpURLConnection) url.openConnection();
			//httpconnection.connect();
			int responseCode = httpconnection.getResponseCode();
			if (responseCode >= 400) {
				System.out.println("Broken Link:" + attribute);
				brokenLinkCount = brokenLinkCount + 1;
			} else {
				System.out.println("Not a Broken Link" + attribute);
				notABrokenLinkCount = notABrokenLinkCount + 1;
			}
		}
		System.out.println("Broken link count:" + brokenLinkCount);
		System.out.println("Not a Broken link count:" + notABrokenLinkCount);
	}

}
