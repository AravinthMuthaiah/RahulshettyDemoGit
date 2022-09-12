package org.packagename;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderExample {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
WebDriver driver= new ChromeDriver();
driver.get("http://leafground.com/");
driver.manage().window().maximize();

WebElement calenderBtn=driver.findElement(By.xpath("//*[@alt='Calendar']"));
calenderBtn.click();
//Clicking the calender text box
WebElement calenderTxtBox=driver.findElement(By.id("datepicker"));
calenderTxtBox.click();

//Clicking the next button which is present inside the j querry calender
WebElement nxtBtn=driver.findElement(By.xpath("//a[@title='Next']"));
nxtBtn.click();

//Selecting Jan 15 from the calender  
WebElement jan15Btn=driver.findElement(By.xpath("//a[text()='15']"));
jan15Btn.click();

// Getting the text that is entered inside text box and printing the same on console
WebElement calenderTxtBoxValue=driver.findElement(By.id("datepicker"));
String txt=calenderTxtBoxValue.getAttribute("value");
System.out.println(txt);


	}

}
