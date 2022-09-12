package org.packagename;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {

	public static void main(String[] args) throws AWTException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/");
		driver.manage().window().maximize();

		WebElement windowBox = driver.findElement(By.xpath("//*[@alt='Windows']"));
		windowBox.click();
		//**To get the Parent Window Id we are using getWindowHandle Method**
		String parentWindowId = driver.getWindowHandle();
		System.out.println(parentWindowId);

		//**Clicking the Open Home button **
		WebElement homePgeBtn = driver.findElement(By.id("home"));
		homePgeBtn.click();
		//**After clicking the button home page will be opened 
		Set<String> allWindowId = driver.getWindowHandles();
		for (String childWindowId : allWindowId) {
			if (!parentWindowId.equals(childWindowId)) {
				driver.switchTo().window(childWindowId);
			}
		}
		//**Doing some text box operations in the text boxes**
		WebElement editBox = driver.findElement(By.xpath("//*[@alt='Edit / Text Fields']"));
		editBox.click();

		WebElement txtBox = driver.findElement(By.id("email"));
		txtBox.sendKeys("aravinth@gmail.com");

		// 2.Appending the word Append Box after the word Append
		WebElement appendBox = driver.findElement(By.xpath("//*[@value='Append ']"));
		appendBox.sendKeys("Append box");

		// 3.Pressing the keyboard tab
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);

		// 4. Printing the text "TestLeaf" that is present in the text box
		WebElement testLeafBox = driver.findElement(By.name("username"));
		String text = testLeafBox.getAttribute("value");
		System.out.println(text);

		// 5.Clearing the already existing text in the text box
		WebElement clrMeTxtBox = driver.findElement(By.xpath("//*[@value='Clear me!!']"));
		clrMeTxtBox.clear();

		// 6. checking whether the text box is editable or not
		WebElement disabledBox = driver.findElement(By.xpath("//*[@disabled='true']"));
		if (disabledBox.isEnabled()) {
			System.out.println("This disabled box is editable");
		} else {
			System.out.println("This disabled box is uneditable");
		}
		driver.close();
		driver.switchTo().window(parentWindowId);

		// 7.Finding the number of Opened windows
		WebElement multipleWindowBox = driver.findElement(By.xpath("//*[@onclick='openWindows()']"));
		multipleWindowBox.click();

		Set<String> allWindowId2 = driver.getWindowHandles();
		int size = allWindowId2.size();
		System.out.println("Number of windows opened is:" + size);

		for (String childWindowId2 : allWindowId2) {
			if (!parentWindowId.equals(childWindowId2)) {
				driver.switchTo().window(childWindowId2);
				Thread.sleep(2000);
				driver.close();
			}
		}

		driver.switchTo().window(parentWindowId);

		// 8.How to close all the windows except parent window
		WebElement dontCloseMebtn = driver.findElement(By.id("color"));
		dontCloseMebtn.click();

		Set<String> allWindowId3 = driver.getWindowHandles();
		for (String childWindowId3 : allWindowId3) {
			if (!parentWindowId.equals(childWindowId3)) {
				driver.switchTo().window(childWindowId3);
				Thread.sleep(2000);
				driver.close();
			}
		}

		driver.switchTo().window(parentWindowId);

		// 9.Wait for 5 seconds after clicking the button
		WebElement wtFor5Sec = driver.findElement(By.xpath("//*[text()='Wait for 5 seconds']"));
		wtFor5Sec.click();
		// Thread.sleep(5000);

		Set<String> allWindowId4 = driver.getWindowHandles();
		for (String childWindowId4 : allWindowId4) {
			if (!parentWindowId.equals(childWindowId4)) {
				driver.switchTo().window(childWindowId4);
				System.out.println("child");
				Thread.sleep(1000);
				driver.close();
			}

		}

		driver.switchTo().window(parentWindowId);

		System.out.println("End");
	}

}
