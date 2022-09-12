package brokenLink;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DoubleClick {

	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/");
		driver.manage().window().maximize();
		
		WebElement editBox=driver.findElement(By.xpath("//*[@alt='Edit / Text Fields']"));
		editBox.click();
		
		WebElement txtBox=driver.findElement(By.id("email"));
		txtBox.sendKeys("123456");
		
		Actions a=new Actions(driver);
		a.doubleClick(txtBox).build().perform();
		a.contextClick(txtBox).build().perform();
		
		Robot r=new Robot();
		
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
//		Thread.sleep(1000);
//		
//		r.keyPress(KeyEvent.VK_RIGHT);
//		r.keyRelease(KeyEvent.VK_RIGHT);
//		
//		r.keyPress(KeyEvent.VK_RIGHT);
//		r.keyRelease(KeyEvent.VK_RIGHT);
//		
//		r.keyPress(KeyEvent.VK_ENTER);
//		r.keyRelease(KeyEvent.VK_ENTER);
//		
//		r.keyPress(KeyEvent.VK_ENTER);
//		r.keyRelease(KeyEvent.VK_ENTER);
//		
//		r.keyPress(KeyEvent.VK_ENTER);
//		r.keyRelease(KeyEvent.VK_ENTER);
		
		driver.quit();
	}

}
