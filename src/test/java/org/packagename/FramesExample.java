package org.packagename;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesExample {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("http://leafground.com/");
driver.manage().window().maximize();

WebElement btnFrame=driver.findElement(By.xpath("//*[@alt='Frame']"));
btnFrame.click();

//To swich the control from driver to frame we need to use driver.switchTo().frame()
driver.switchTo().frame(0);

//1. Clicking the click button inside a frame
WebElement btnClk1=driver.findElement(By.id("Click"));
btnClk1.click();
System.out.println(btnClk1.getText());

driver.switchTo().defaultContent();

driver.switchTo().frame(1);
driver.switchTo().frame("frame2");

//2. Clicking the click button inside a nested frame
WebElement btnClk2=driver.findElement(By.id("Click1"));
btnClk2.click();
System.out.println(btnClk2.getText());
System.out.println("...............");

driver.switchTo().defaultContent();

//3. Counting how many frames are there in the current page
List<WebElement>noOfFrames=driver.findElements(By.tagName("iframe"));
System.out.println(noOfFrames.size());


	}

}
