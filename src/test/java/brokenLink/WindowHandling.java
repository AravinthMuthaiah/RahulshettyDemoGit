package brokenLink;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.hc.core5.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.get("https://www.amazon.in/");
driver.manage().window().maximize();

driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone 13 pro max", Keys.ENTER);
WebElement iphone=driver.findElement(By.xpath("(//span[contains (text(), 'Apple iPhone 13 Pro (512GB) - Sierra Blue')])[1]"));
String parentWindowId=driver.getWindowHandle();
iphone.click();

Set<String>allWindowId=driver.getWindowHandles();
for(String eachWindowId:allWindowId) {
	if(!parentWindowId.equals(allWindowId)) {
		driver.switchTo().window(eachWindowId);
	}
}
String text=driver.findElement(By.id("acrCustomerReviewText")).getText();
System.out.println(text);

driver.switchTo().window(parentWindowId);
driver.close();

}
	
	}


