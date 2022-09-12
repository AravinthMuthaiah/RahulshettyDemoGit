package org.packagename;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitExample2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/");
		
		WebElement btnappear=driver.findElement(By.xpath("//*[@alt='appear']"));
		btnappear.click();
		
		//Wait until the 5 th button is visible
		WebDriverWait wait=new WebDriverWait(driver,10);
		WebElement visibleTxt=wait.until
				(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='btn']/b")));
		System.out.println(visibleTxt.getText());
		
		//Output: Voila! I'm here Guys
		
		}

}
