package org.packagename;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageExample {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/");

		WebElement imgBtn = driver.findElement(By.xpath("//*[@alt='Images']"));
		imgBtn.click();
		
		/*//1.Find whether the image is broken image or not 
		 * if it is not broken means then click that image*/
		WebElement imgClk = driver.findElement
				(By.xpath("//*[@id=\"contentblock\"]/section/div[1]/div/div/img"));
		
		if (imgClk.getAttribute("naturalWidth").equals("0")) {
			System.out.println("This is for the first image: The image is broken image");
		} else {
			System.out.println("This is for the first image: The image is not a broken image");
			imgClk.click();
		}
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement imgBtn1 = driver.findElement(By.xpath("//*[@alt='Images']"));
		imgBtn1.click();

		// **Natural width is a css property
		// if the Natural width is 0 means
		// then that image is a broken image.
		
		//2. Find whether the image is broken image or not
		WebElement secondImg = driver.findElement
				(By.xpath("//*[@id=\'contentblock\']/section/div[2]/div/div/img"));
		if (secondImg.getAttribute("naturalWidth").equals("0")) {
			System.out.println("This is for the second image: The image is broken image");
		} else {
			System.out.println("This is for the second image: The image is not a broken image");
		}

	}

}
