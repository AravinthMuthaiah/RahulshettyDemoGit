package brokenLink;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class W3Schooltable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();

		// 1. Count no of rows in the table
		List<WebElement> rows = driver
				.findElements(By.xpath("//table[@id='customers']/tbody/tr/following-sibling::tr"));
		int row = rows.size();
		System.out.println("No of rows in the webtable is:" + row);

		// 2. Print the rows datas in the console
		for (int i = 0; i < row; i++) {
			WebElement r = rows.get(i);
			String s = r.getText();
			System.out.println(s + "  ");

		}
		System.out.println("Printing the Headers of the table---------------------------------");

		// 3. COunt no of columns in the table
		List<WebElement> columns = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/th"));
		int column = columns.size();
		System.out.println("No of Column in the webtable is:" + column);
		for (int j = 0; j < column; j++) {
			WebElement c = columns.get(j);
			String e = c.getText();
			System.out.println(e + "  ");
		}

		// 4.printing the particular data
		for (int i = 2; i <= row; i++) {

			WebElement ele = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[" + i + "]/td[3]"));
			String txt = ele.getText();
			if (txt.equals("Austria")) {
				String a = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[" + i + "]/td[2]")).getText();
				String b = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[" + i + "]/td[1]")).getText();
				System.out.println(txt + "  " + a + "  " + b);
			}
		}

	}

}
