package brokenLink;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseOver {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("http://leafground.com/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.findElement(By.xpath("//img[@alt='mouseover']")).click();
Actions a=new Actions(driver);
a.moveToElement(driver.findElement(By.className("btnMouse"))).perform();
List<WebElement>elements=driver.findElements(By.xpath("//a[@class='listener']"));
for(WebElement element:elements) {
	String text=element.getText();
	System.out.println(text);
if(text.equals("RPA")) {
	element.click();
	Alert al=driver.switchTo().alert();
	
	WebDriverWait w=new WebDriverWait(driver,5);
	w.until(ExpectedConditions.alertIsPresent());
	System.out.println(al.getText());
	
	al.accept();
}
}


	}

}
