package org.packagename;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButton {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/");

		WebElement btnRadio = driver.findElement(By.xpath("//*[@alt='Radio Button']"));
		btnRadio.click();

		// 1.Select 1 radio button either yes or not
		WebElement rdoYes = driver.findElement(By.id("yes"));
		rdoYes.click();

		// 2.Finding the default selected radio button and then printing them on the
		// console
		WebElement rdoChecked = driver.findElement(By.xpath("(//*[@name='news'])[2]"));
		WebElement rdoUnChecked = driver.findElement(By.xpath("(//*[@name='news'])[1]"));
		
		boolean status1=rdoChecked.isSelected();
		boolean status2=rdoUnChecked.isSelected();
		
		System.out.println("Checked radio button is selected" +status1);
		System.out.println("UnChecked radio button is selected" +status2);
		

		// 3.Selecting the age group from the given radio button
		WebElement rdoAge = driver.findElement(By.xpath("(//*[@value='0'])[3]"));
		rdoAge.click();

	}

}
