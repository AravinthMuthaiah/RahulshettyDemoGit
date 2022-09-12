package org.packagename;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/");
		driver.manage().window().maximize();

		WebElement checkButton = driver.findElement(By.xpath("//*[@alt='Checkbox']"));
		checkButton.click();

		// 1. Selecting the languages like java, VB, C++ from the check box list
		WebElement javaChkBox = driver.findElement(By.xpath("//*[@type='checkbox'][1]"));
		javaChkBox.click();

		WebElement vbChkBox = driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));
		vbChkBox.click();

		WebElement cPlusPlusChkBox = driver.findElement(By.xpath("(//*[@type='checkbox'])[5]"));
		cPlusPlusChkBox.click();

		// 2.Confirm the selenium is checked or not
		WebElement selChkBox = driver.findElement(By.xpath("(//*[@type='checkbox'])[6]"));
		
		if (selChkBox.isSelected()) {
			
			System.out.println("Selenium check box is checked ");
			
		}else {
			System.out.println("Selenium check box is unchecked");
		}

		// 3.Deselecting the selected check box
		WebElement iamSelectedChkBox = driver.findElement(By.xpath("(//*[@type='checkbox'])[8]"));
		WebElement notSelectedChkBox = driver.findElement(By.xpath("(//*[@type='checkbox'])[7]"));
		
		if (iamSelectedChkBox.isSelected()) {
			iamSelectedChkBox.click();
			System.out.println("I am Selected check box is deselected ");
			
		}
		
		if(notSelectedChkBox.isSelected()) {
			notSelectedChkBox.click();
			System.out.println("Not Selected check box is deselected ");
		}

		// 4.select all 5 the check boxes
		WebElement option1 = driver.findElement(By.xpath("(//*[@type='checkbox'])[9]"));
		option1.click();

		WebElement option2 = driver.findElement(By.xpath("(//*[@type='checkbox'])[10]"));
		option2.click();

		WebElement option3 = driver.findElement(By.xpath("(//*[@type='checkbox'])[11]"));
		option3.click();

		WebElement option4 = driver.findElement(By.xpath("(//*[@type='checkbox'])[12]"));
		option4.click();

		WebElement option5 = driver.findElement(By.xpath("(//*[@type='checkbox'])[13]"));
		option5.click();

	}

}
