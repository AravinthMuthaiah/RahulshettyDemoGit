package org.packagename;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToolTip {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("http://leafground.com/");
driver.manage().window().maximize();

WebElement toolTipBtn=driver.findElement(By.xpath("(//*[@alt='tooltip'])[1]"));
toolTipBtn.click();

WebElement txtBox=driver.findElement(By.id("age"));
String txt=txtBox.getAttribute("title");
System.out.println(txt);

	}

}
