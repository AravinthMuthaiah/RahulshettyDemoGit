package org.packagename;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Upload {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		driver.manage().window().maximize();
		
		WebElement uploadBtn = driver.findElement(By.xpath("//*[@alt='contextClick']"));
		uploadBtn.click();

		WebElement btnClk = driver.findElement(By.name("filename"));
		js.executeScript("arguments[0].click()", btnClk);
		
		
		//btnClk.click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String s = "C:\\Users\\Lenovo\\Downloads\\testleaf.xlsx";
		System.out.println(s);
	}

}
