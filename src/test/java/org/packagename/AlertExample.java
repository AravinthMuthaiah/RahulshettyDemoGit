package org.packagename;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertExample {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/");
		driver.manage().window().maximize();

		WebElement btnAlert = driver.findElement(By.xpath("//*[@alt='Alert']"));
		btnAlert.click();

		// 1.Simple Alert
		WebElement btnSimpleAlert = driver.findElement(By.xpath("//*[text()='Alert Box']"));
		btnSimpleAlert.click();

		Alert a = driver.switchTo().alert();
		Thread.sleep(1000);
		a.accept();

		// 2. Conform Alert
		WebElement btnConformAlert = driver.findElement(By.xpath("//*[text()='Confirm Box']"));
		btnConformAlert.click();

		Alert a2 = driver.switchTo().alert();
		Thread.sleep(1000);
		a2.dismiss();

		// 3.Prompt Alert
		WebElement btnPromptAlert = driver.findElement(By.xpath("//*[text()='Prompt Box']"));
		btnPromptAlert.click();

		Alert a3 = driver.switchTo().alert();
		a3.sendKeys("Aravinth");
		Thread.sleep(1000);
		a3.accept();

		
		/*
		 * 4.Printing the text
		 * "You should not have enjoyed learning at TestLeafAravinth as compared to TestLeaf! Right?"
		 * in the console
		 */
		WebElement element = driver.findElement(By.id("result1"));
		String s = element.getText();
		System.out.println(s);

		// 5.Line Breaks(Getting the text from the alert box and then printing them on
		// the console)
		WebElement btnLineBreak = driver.findElement(By.xpath("//*[text()='Line Breaks?']"));
		btnLineBreak.click();

		Alert a4 = driver.switchTo().alert();
		String s2 = a4.getText();
		System.out.println(s2);
		Thread.sleep(1000);
		a4.accept();

		// 6.Sweet Alert----> Sweet Alert means we can able to find locator for that alert
		WebElement btnSweetAlert = driver.findElement(By.xpath("//*[text()='Sweet Alert']"));
		btnSweetAlert.click();
		WebElement sweetAlert = driver.findElement(By.xpath("//*[text()='OK']"));
		sweetAlert.click();

	}

}
