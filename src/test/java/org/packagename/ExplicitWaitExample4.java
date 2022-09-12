package org.packagename;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitExample4 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/");

		WebElement btnAlert = driver.findElement(By.xpath("(//*[@alt='tooltip'])[3]"));
		btnAlert.click();

		WebElement btnClk = driver.findElement(By.xpath("//*[@id='alert']"));
		btnClk.click();

		// wait until the alert appear and then we need to click accept
		WebDriverWait wait = new WebDriverWait(driver, 5);
		String txt = wait.until(ExpectedConditions.alertIsPresent()).getText();
		System.out.println(txt);
		if (txt.equals("Hurray, Click OK")) {
			System.out.println("Alert is present");
			Alert a = driver.switchTo().alert();
			a.accept();
		} else {
			System.out.println("Alert is not present");
		}

	}

}
