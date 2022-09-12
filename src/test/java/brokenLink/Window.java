package brokenLink;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Window {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("https://opensource-demo.orangehrmlive.com/");

String parentWindowId=driver.getWindowHandle();

driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();

Set<String>WindowIds=driver.getWindowHandles();
for(String windowId:WindowIds) {
	System.out.println(windowId);
	if(!parentWindowId.equals(windowId)) {
		driver.switchTo().window(windowId);
		System.out.println(windowId);
		
	}
}
String childTitle=driver.getTitle();
System.out.println("Child Window Id title"+childTitle);
	}

}
