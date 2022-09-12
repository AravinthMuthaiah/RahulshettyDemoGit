package org.packagename;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownLoadAText {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/");
		driver.manage().window().maximize();
		
		WebElement btnDown=driver.findElement(By.xpath("//*[@alt='Download']"));
		btnDown.click();
		
		WebElement linkDwldTxt=driver.findElement(By.xpath("//*[text()='Download Text']"));
		linkDwldTxt.click();
		
		WebElement txtDowloaded=driver.findElement(By.xpath("//*[text()='You have downloaded the file.']"));
		String text=txtDowloaded.getText();
		System.out.println(text);
				
				
			}
		}


