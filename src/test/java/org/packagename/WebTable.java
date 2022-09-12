package org.packagename;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/");
		driver.manage().window().maximize();

		WebElement btnTable = driver.findElement(By.xpath("//*[@alt='Table']"));
		btnTable.click();

		WebElement table = driver.findElement(By.id("table_id"));

		// 1. Count the number of columns present in the web table
		List<WebElement> tableHeaders = table.findElements(By.tagName("th"));

		int size = tableHeaders.size();
		System.out.println("Number of Columns present in the table is:" + size);

		System.out.println("---------------------------------");

		// Print the values present in the headers
		for (int i = 0; i < size; i++) {
			WebElement header = tableHeaders.get(i);
			String h = header.getText();
			System.out.println(h);
		}
		System.out.println("---------------------------------");

		// 2. Count the number of rows present in the Web table
		List<WebElement> tableRows = table.findElements(By.tagName("tr"));
		int rowSize = tableRows.size();
		System.out.println("Number of Rows present in the table is:" + rowSize);
		System.out.println("---------------------------------");

		// Print the values present in the rows including header
		for (WebElement tableRow : tableRows) {
			String row = tableRow.getText();
			System.out.println(row);

		}
		System.out.println("---------------------------------");

		// 3. Get the progress value of 'Learn to interact with Elements'

		List<WebElement> tableFirstColumnDatas = table.findElements(By.xpath("//td[1]"));
		for (WebElement tableData : tableFirstColumnDatas) {
			String data = tableData.getText();
			if (data.equals("Learn to interact with Elements")) {
				WebElement progressValue = driver
						.findElement(By.xpath("//*[text()='Learn to interact with Elements']/following::td[1]"));
				String value = progressValue.getText();
				System.out.println("The Progress value of Learn to interact with Elements is:" + value);
				break;
			}
		}

		System.out.println("----------------------------------");

		// 4. Check box clicking the vital task for the least completed progress.

		List<WebElement> progressPercentage = driver.findElements(By.xpath("//td[2]"));

		List<Integer> percentage = new ArrayList<Integer>();

		for (WebElement percent : progressPercentage) {
			String individualValue = percent.getText().replace("%", "");
			
			//Converting String in to Integer 
			int value = Integer.parseInt(individualValue);
			percentage.add(value);

		}
		System.out.println("Progress Percentage list is:" + percentage);

		System.out.println("----------------------------------");

		//To find the minimum value in the list
		/*We are having a Class Collections and inside that there is method min().
		 * Collections -- Class
		 * 	min() -- Method
		 * */
		int minValue = Collections.min(percentage);
		System.out.println("Minimum progress percentage value is:" + minValue);

		System.out.println("----------------------------------");
		
		//Converting Integer to String
		String minPercentage = Integer.toString(minValue).concat("%");
		System.out.println("Minimum progress percentage is:" + minPercentage);

		String s = "//td[normalize-space()=" + "\"" + minPercentage + "\"]" + "//following::td[1]" + "//child::input";
		System.out.println(s);
		
		//Clicking the check box
		WebElement chkBox = table.findElement(By.xpath(s));
		chkBox.click();

	}

}
