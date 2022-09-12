package org.packagename;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("http://leafground.com/");
driver.manage().window().maximize();

WebElement btnDroppable=driver.findElement(By.xpath("//*[@alt='drop']"));
btnDroppable.click();

WebElement draggableBox=driver.findElement(By.id("draggable"));
WebElement dropBox=driver.findElement(By.id("droppable"));

Actions a=new Actions(driver);
Thread.sleep(1000);

a.clickAndHold(draggableBox).moveToElement(dropBox).release().perform();
// For Drag and Drop we can use the 
//above technique and also the below technique also both will do the same job
//a.dragAndDrop(draggableBox, dropBox).build().perform();
System.out.println(dropBox.getText());

}

}
