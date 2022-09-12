package brokenLink;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		driver.manage().window().maximize();

		System.out.println("Printing the table Headers");
		System.out.println("-----------------------------");

		// Print the headers of the table
		List<WebElement> tableHeaders = driver.findElements(By.tagName("thead"));
		for (int i = 0; i < tableHeaders.size(); i++) {
			WebElement tableHeader = tableHeaders.get(i);
			String header = tableHeader.getText();
			System.out.println(header);
		}

		System.out.println("-----------------------------");
		System.out.println("Printing the table Rows");
		System.out.println("-----------------------------");

		// Printing the rows in the table
		List<WebElement> tableRows = driver.findElements(By.xpath("//tbody[@style='margin:0;padding:0']/tr"));
		for (int j = 0; j < (tableRows.size()); j++) {
			WebElement tableRow = tableRows.get(j);
			String row = tableRow.getText();
			System.out.println(row);
		}
		System.out.println("-----------------------------");

		System.out.println("Printing the table footers");
		System.out.println("-----------------------------");

		List<WebElement> tableFooters = driver.findElements(By.tagName("tfoot"));
		for (WebElement footer : tableFooters) {
			System.out.println(footer.getText());
		}

		// System.out.println("Printing the table footers");
		// System.out.println("-----------------------------");
		List<Integer> a = new ArrayList<Integer>();
		List<WebElement> tableHeights = driver.findElements(By.xpath("//tbody[@style='margin:0;padding:0']/tr/td[3]"));
		for (int i = 0; i < tableHeights.size(); i++) {
			WebElement tableHeight = tableHeights.get(i);
			String s = tableHeight.getText();
			String s1 = s.replace("m", "");
			int b = Integer.parseInt(s1);
			a.add(b);
		}
		System.out.println(a);
		for (int i = 0; i < a.size(); i++) {
			int c = a.get(i);

			// Printing the smallest structure in the earth
			if (Collections.min(a) == c) {
				List<WebElement> element = driver
						.findElements(By.xpath("//tbody[@style='margin:0;padding:0']/tr/td[3]//parent::tr/td[2]"));
				for (WebElement texts : element) {
					String text = texts.getText();
					if (text.equals("Shanghai")) {
						System.out.println("Smallest Structure is in the city:" + text);
						break;
					}
				}
			}

			// Printing the tallest structure in the earth
			Integer max = Collections.max(a);
			if (max == c) {
				List<WebElement> element2 = driver.findElements(By.xpath("//tbody[@style='margin:0;padding:0']/tr/th"));
				for (WebElement webElement : element2) {
					String s2 = webElement.getText();
					if (s2.equals("Burj Khalifa")) {
						System.out.println("The tallest structure is:" + s2);
						break;
					}
				}
			}
		}
	}

}
