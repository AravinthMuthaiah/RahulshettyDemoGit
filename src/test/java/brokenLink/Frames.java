package brokenLink;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://seleniumbase.io/demo_page");
		driver.manage().window().maximize();

		driver.switchTo().frame("myFrame2");
		WebElement frame = driver.findElement(By.xpath("//h4[text()='iFrame Text']"));
		String txt = frame.getText();
		System.out.println(txt);

		driver.switchTo().defaultContent();

		WebElement element = driver.findElement(By.xpath("//div[@class='dropdown']"));
		Actions a = new Actions(driver);
		a.moveToElement(element).build().perform();

		WebElement element2 = driver
				.findElement(By.xpath("//div[@class='dropdown']//following::div[@class='dropdown-content']"));

		Select s = new Select(element2);
		s.selectByIndex(1);

	}

}
