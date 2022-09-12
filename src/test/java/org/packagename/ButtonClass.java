package org.packagename;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonClass {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/home.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//img[@class='wp-categories-icon svg-image'])[2]")).click();

		// 1.To find the X and Y position of the button
		WebElement btnPosition = driver.findElement(By.id("position"));
		Point xyLocation = btnPosition.getLocation();
		int xLocation = xyLocation.getX();
		int yLocation = xyLocation.getY();
		System.out.println("X location is: " +xLocation +  "Y location is : " +yLocation);

		// 2. To find the color of the button
		WebElement btnColor = driver.findElement(By.id("color"));
		String color = btnColor.getCssValue("background-color");
		System.out.println("Color of the button is: " + color);

		
		// 3. To find the size of the button
		WebElement btnSize = driver.findElement(By.id("size"));
		Dimension size = btnSize.getSize();
		int h = size.getHeight();
		int w = size.getWidth();
		System.out.println("Height of the button is: " +h + "Width of the button is: " +w);

		
		// 4. Click the button
		WebElement btnClick = driver.findElement(By.id("home"));
		btnClick.click();

	}

}
