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

public class BrokenImage {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> imageLinks = driver.findElements(By.tagName("img"));
		System.out.println("Total Number of Images is:" + imageLinks.size());

		int brokenImageCount = 0, notABrokenImageCount = 0;

		for (int i = 0; i < imageLinks.size(); i++) {
			WebElement imglink = imageLinks.get(i);
			String attribute = imglink.getAttribute("src");

			URL url = new URL(attribute);
			HttpURLConnection httpconnection = (HttpURLConnection) url.openConnection();
			//httpconnection.connect();
			int responseCode = httpconnection.getResponseCode();
			if (responseCode >= 400) {
				System.out.println("Broken Image:" + attribute);
				brokenImageCount = brokenImageCount + 1;
			} else {
				System.out.println("Not a Broken Image:" + attribute);
				notABrokenImageCount = notABrokenImageCount + 1;
			}
		}
		System.out.println("Broken Image count:" + brokenImageCount);
		System.out.println("Not a Broken Image count:" + notABrokenImageCount);
	}

	}


