package org.packagename;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortablesExample {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/");

		WebElement btnSortable = driver.findElement(By.xpath("//*[@alt='sortable']"));
		btnSortable.click();

		List<WebElement> itemList = driver.findElements(By.xpath("//ul[@id='sortable']/li"));
		WebElement from1 = itemList.get(6);
		for (int i = 0; i < itemList.size(); i++) {
			
				WebElement to1 = itemList.get(i);
				
				
				Actions a = new Actions(driver);
				a.dragAndDrop(from1, to1).build().perform();
				String from = from1.getText();
				String to = to1.getText();
				System.out.println(from + ":" + to);

			}

		}

	}

