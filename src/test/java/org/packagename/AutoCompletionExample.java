package org.packagename;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoCompletionExample {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/");
		driver.manage().window().maximize();

		WebElement btnAuto = driver.findElement(By.xpath("//*[@alt='Auto Complete']"));
		btnAuto.click();
		//**Finding the locator for the text box and then entering first letter 's'
		//of the required text
		WebElement txtBox = driver.findElement(By.id("tags"));
		txtBox.sendKeys("s");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//**The options which we want to select will be present in <ul> tag ie unorderd list
		//and inside that ul tag <li> tag ie List tag will be there. 
		List<WebElement> options = driver.findElements(By.xpath("//*[@id='ui-id-1']/li"));
		for (int i = 0; i < options.size(); i++) {
			WebElement element = options.get(i);
			String txt = element.getText();
			
			//1. With Break
			if (txt.equals("Selenium")) {
				element.click();
				System.out.println("if part");
				//We are putting break to break the if part when the 
				//required text is selected
				break;
				}else {
					System.out.println("else part");
				}
				}
//			//2. Without Break
//			if(txt.equals("Selenium")) {
//				System.out.println("if part");
//				element.click();
//				
//			}else {
//				System.out.println("else part");
//		}
		}
		
	}


