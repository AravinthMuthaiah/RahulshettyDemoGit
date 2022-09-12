package org.packagename;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHoverActionExample {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/");

		WebElement btnMouseHover=driver.findElement(By.xpath("//*[@alt='mouseover']"));
		btnMouseHover.click();
		
		WebElement courseDdn=driver.findElement(By.className("btnMouse"));
		Actions a=new Actions(driver);
		a.moveToElement(courseDdn).build().perform();
		
		List<WebElement>listOfCourses=driver.findElements(By.xpath("//ul/following::li/following::a[@class='listener']"));
		
		//1. Print all the values present in the drop down
		for(WebElement course:listOfCourses) {
			String txt=course.getText();
			System.out.println(txt);
		}
		
		
		//2. Selecting "RPA" from the courses mouseHover drop down and then clicking that and finally handling alert
		for(WebElement course:listOfCourses) {
			String text=course.getText();
			if(text.equals("RPA")) {
				WebElement rpaCourse=driver.findElement(By.xpath("//ul/child::li/child::a[text()='RPA']"));
				rpaCourse.click();
				Alert a1=driver.switchTo().alert();
				System.out.println(a1.getText());
				a1.accept();
				}}}}
		
