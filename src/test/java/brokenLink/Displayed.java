package brokenLink;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Displayed {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://cosmocode.io/automation-practice-webtable/");
		driver.manage().window().maximize();
		WebElement s=driver.findElement(By.xpath("(//table[@id='countries']/tbody/tr[3]/td[5]//preceding-sibling::td[4]/input[@class='hasVisited'])"));
		boolean select=s.isSelected();
		//Before Selecting
		System.out.println(select);
		
		//After Selecting
		s.click();
		boolean select1=s.isSelected();
		System.out.println(select1);
		

	}

}
