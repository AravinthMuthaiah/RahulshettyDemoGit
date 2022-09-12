package org.packagename;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/");
		
		
		WebElement btnDisappear=driver.findElement(By.xpath("//*[@alt='disapper']"));
		btnDisappear.click();
		
		//1. Wait until the button to disappear
		WebDriverWait wait=new WebDriverWait(driver,5);
		WebElement txtElement=wait.until
		(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='disappear']//following::strong")));
		
		String s=txtElement.getText();
		System.out.println(s);
		
		
	}

}
