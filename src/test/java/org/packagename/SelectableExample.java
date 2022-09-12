package org.packagename;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectableExample {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("http://leafground.com/");
driver.manage().window().maximize();

WebElement btnSelect=driver.findElement(By.xpath("//*[@alt='selectable']"));
btnSelect.click();

/*1.We need to always Find the xpath for the list which is present inside a <ol> tag ie(ordered list) 
and the list will be present inside <li> tag ie(List).
2.Since we are finding xpath for list of items so we need to use findElements*/

List<WebElement>selectBox=driver.findElements(By.xpath("//*[@id='selectable']/li"));

/*Now we need to select the first 3 item from the selectable list 
for that we are using Action class*/

////1. 1st technique to select first 3 item in the list
//Actions a=new Actions(driver);
//
////*We are going to select multiple list by pressing control key and then we will select 
////the first 3 list and then we will release the control key and to perform action we are
////using build and perform*/
//a.keyDown(Keys.CONTROL)
//.click(selectBox.get(0))
//.click(selectBox.get(1))
//.click(selectBox.get(2))
//.keyUp(Keys.CONTROL)
//.build().perform();

	
//2. 2nd technique to select first 3 item in the list
	Actions a1=new Actions(driver);
	a1.clickAndHold(selectBox.get(0))
	  .clickAndHold(selectBox.get(1))
	  .clickAndHold(selectBox.get(2))
	  .build().perform();
	

}
}
