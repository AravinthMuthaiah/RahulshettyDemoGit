package org.packagename;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadAFile {

	public static void main(String[] args) throws AWTException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		driver.manage().window().maximize();

		WebElement uploadBtn = driver.findElement(By.xpath("//*[@alt='contextClick']"));
		uploadBtn.click();

		WebElement chooseBtn = driver.findElement(By.xpath("//*[@type='file']"));
		js.executeScript("arguments[0].click()", chooseBtn);
		
		Thread.sleep(3000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	

		
		/*
		 * String Selection -- Class Creates a Transferable capable of transferring the
		 * specified String.
		 */
		StringSelection sel = new StringSelection("C:\\Users\\Lenovo\\Downloads\\testleaf.xlsx");

		// To copy the file path location to clip board
		/*
		 * Toolkit--Class getDefaultToolkit()-- Method getSystemClipboard()-- Method
		 * setContents(Transferable content, Transferable to content)--Method
		 */
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);

		/*
		 * Then we need to copy the path from the clipboard to the text box using the
		 * robot class
		 */
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);

		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);

		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("done");
		
		
		
}	

	}
	


