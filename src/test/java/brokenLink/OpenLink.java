package brokenLink;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenLink {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("https://www.w3schools.com/html/default.asp");
driver.manage().window().maximize();
String t=Keys.chord(Keys.CONTROL, Keys.ENTER);
WebElement sql=driver.findElement(By.xpath("//a[normalize-space()='SQL']"));
sql.sendKeys(t);
	}

}
