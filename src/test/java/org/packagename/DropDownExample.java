package org.packagename;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownExample {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//img[@alt='ListBox']")).click();

		// 1.Select by index
		WebElement dropDown1 = driver.findElement(By.id("dropdown1"));
		Select s = new Select(dropDown1);
		s.selectByIndex(1);
		
		// 2.Select by visible text
		WebElement dropDown2 = driver.findElement(By.name("dropdown2"));
		Select s1 = new Select(dropDown2);
		s1.selectByVisibleText("Loadrunner");

		// 3.Select by value
		WebElement dropDown3 = driver.findElement(By.id("dropdown3"));
		Select s2 = new Select(dropDown3);
		s2.selectByValue("3");

		// 4.To get the number of options in the drop down
		WebElement dropDown4 = driver.findElement(By.className("dropdown"));
		Select s3 = new Select(dropDown4);

		List<WebElement> options = s3.getOptions();
		int size = options.size();
		System.out.println("Size of the Drop Down is:" + size);

		// 5.To print all the options in the drop down
		System.out.println("Element in the drop down are");
		for (int i = 0; i < size; i++) {
			WebElement element = options.get(i);
			String e = element.getText();
			 
			System.out.println(e);
		}

		// 6. Selecting the drop down using sendkeys
		WebElement dropDown5 = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[5]/select"));
		dropDown5.sendKeys("Loadrunner");

		// 7.Selecting multiple options from the drop down using Index and value
		WebElement dropDown6 = driver.findElement(By.xpath("//*[@id=\'contentblock\']/section/div[6]/select"));
		Select s4 = new Select(dropDown6);
		s4.selectByIndex(0);
		s4.selectByIndex(1);
		s4.selectByIndex(2);
		s4.selectByIndex(3);
		s4.selectByValue("4");
		
		List<WebElement>allOptions=s4.getAllSelectedOptions();
		System.out.println("All Selected options in the drop down are");
		for(int j=0;j<allOptions.size();j++) {
			WebElement element=allOptions.get(j);
			String ele=element.getText();
			
			System.out.println(ele);
		}
		
		
		
	}

}
