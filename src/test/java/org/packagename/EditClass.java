package org.packagename;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditClass {

	// TEST LEAF WEBSITE TASK EDIT
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/");
		driver.manage().window().maximize();
		WebElement btnClick = driver.findElement(By.xpath("(//img[@class='wp-categories-icon svg-image'])[1]"));
		btnClick.click();

		driver.findElement(By.id("email")).sendKeys("aravinth@gmail.com");
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("aravi");

		String attribute = driver.findElement(By.name("username")).getAttribute("Value");

		System.out.println(attribute);

		driver.findElement(By.xpath("(//input[@name='username'])[2]")).clear();
		Thread.sleep(1000);
		boolean enabled = driver.findElement(By.xpath("//input[@disabled='true']")).isEnabled();
		if (enabled == true) {
			System.out.println("The text box is editable");
		} else {
			System.out.println("The text box is disabled");
		}

		// driver.quit();

	}

}
