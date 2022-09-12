package brokenLink;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSelection {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("http://leafground.com/pages/autoComplete.html");
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.findElement(By.id("tags")).sendKeys("A");

 List<WebElement> ele=driver.findElements(By.xpath("//li[@class='ui-menu-item']//div"));
 for(int i=0;i<ele.size();i++) {
	 WebElement e=ele.get(i);
	 String s=e.getText();
	 if(s.equals("SOAP")) {
	 	e.click();
	 	System.out.println(s);
	 }	 
 }
 //This has been added later
 driver.quit();
 
 //This line is added after so many time
//This line is added after so many time
//This line is added after so many time
//This line is added after so many time
//This line is added after so many time
	}

}
