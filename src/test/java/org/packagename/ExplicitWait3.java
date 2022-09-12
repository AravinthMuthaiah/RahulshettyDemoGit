package org.packagename;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait3 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/");
		
		WebElement btnappear=driver.findElement(By.xpath("(//*[@alt='tooltip'])[2]"));
		btnappear.click();
		
		//Wait until the click me button and then click and then alert appears and click ok in alert
		WebDriverWait wait=new WebDriverWait(driver,5);
		WebElement btnClk=wait.until
				(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Click ME!']")));
		btnClk.click();
		
		wait.until(ExpectedConditions.alertIsPresent()).accept();
		
		
		
		
	}

}
