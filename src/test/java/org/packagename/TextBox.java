package org.packagename;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextBox {

	public static void main(String[] args) throws AWTException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/");
		driver.manage().window().maximize();

		WebElement editBox = driver.findElement(By.xpath("//*[@alt='Edit / Text Fields']"));
		editBox.click();

		//1.Entering the email in the text box
		WebElement txtBox = driver.findElement(By.id("email"));
		txtBox.sendKeys("aravinth@gmail.com");
		
		//2.Appending the word Append Box after the word Append
		WebElement appendBox = driver.findElement(By.xpath("//*[@value='Append ']"));
		appendBox.sendKeys("Append box");
		
		//3.Pressing the keyboard tab
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);

		//4. Printing the text "TestLeaf" that is present in the text box
		WebElement testLeafBox = driver.findElement(By.name("username"));
		String text = testLeafBox.getAttribute("value");
		System.out.println(text);

		//5.Clearing the already existing text in the text box
		WebElement clrMeTxtBox = driver.findElement(By.xpath("//*[@value='Clear me!!']"));
		clrMeTxtBox.clear();

		//6. checking whether the text box is editable or not
		WebElement disabledBox = driver.findElement(By.xpath("//*[@disabled='true']"));
		if (disabledBox.isEnabled()) {
			System.out.println("This disabled box is editable");
		} else {
			System.out.println("This disabled box is uneditable");
		}

	}

}
