package brokenLink;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://seleniumbase.io/demo_page");
		driver.manage().window().maximize();

		WebElement ddnBox = driver.findElement(By.xpath("//select[@id='mySelect']"));

		Select s = new Select(ddnBox);
		s.selectByIndex(1);
		s.selectByVisibleText("Set to 75%");

		List<WebElement> options = s.getOptions();
		
		for (WebElement option : options) {
			String o = option.getAttribute("value");
			System.out.println(o);
			if(o.contains("25")) {
				s.selectByValue("25%");
			}
			
		}

	}
}
