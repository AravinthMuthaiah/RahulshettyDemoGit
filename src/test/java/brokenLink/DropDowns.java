package brokenLink;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDowns {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		
		WebElement ddn=driver.findElement(By.xpath("//select[@id='dropdown1']"));
		Select s=new Select(ddn);
		List<WebElement>options=s.getOptions();
		for(WebElement option:options) {
			String o=option.getText();
			System.out.println(o);
			
		}
		s.selectByIndex(1);
		s.selectByVisibleText("UFT/QTP");
		s.selectByValue("4");
		
		
	}

}
