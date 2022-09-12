package brokenLink;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectClass {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver();

driver.get("http://leafground.com/");
driver.manage().window().maximize();
WebElement selClk=driver.findElement(By.xpath("//*[@alt='selectable']"));
selClk.click();

List<WebElement>selectBoxes=driver.findElements(By.xpath("//*[@id='selectable']/li"));
System.out.println(selectBoxes.size());
Actions a=new Actions(driver);
//a.clickAndHold(selectBoxes.get(0)).clickAndHold(selectBoxes.get(1)).clickAndHold(selectBoxes.get(2)).build().perform();
a.keyDown(Keys.CONTROL)
.clickAndHold(selectBoxes.get(0))
.clickAndHold(selectBoxes.get(1))
.clickAndHold(selectBoxes.get(2))
.keyUp(Keys.CONTROL)
.build().perform();

	}
	}


