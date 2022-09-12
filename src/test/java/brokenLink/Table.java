package brokenLink;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Table {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("https://www.w3schools.com/html/html_tables.asp");
driver.manage().window().maximize();

//1. Print the number of rows in the table

List<WebElement> rows=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/following-sibling::tr"));
int row=rows.size();
System.out.println("The Number of rows in the table is:"+row);

//2. Print the number of columns in the table

List<WebElement>columns=driver.findElements(By.xpath("//table[@id='customers']//tbody/tr/th"));
int column=columns.size();
System.out.println("The Number of rows in the table is:"+column);

//3. Print the all the datas in the table

List<WebElement>datas=driver.findElements(By.xpath("//table[@id='customers']/tbody//tr/td"));
for(WebElement data:datas) {
	String d=data.getText();
		System.out.println(d+"\t");	
	}
	System.out.println();
	
	//4. Print the particular data from the web table
	String text=driver.findElement(By.xpath("//table[@id='customers']//tbody/tr[4]/td[2]")).getText();
	System.out.println(text);

	//5. Print the Contact and Country of particular data
	
	List<WebElement>datas1=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/td[1]"));
for(WebElement companyName:datas1) {
		String s=companyName.getText();
		if(s.equals("Laughing Bacchus Winecellars")) {
			String d=driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[6]/td[2]")).getText();
			String e=driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[5]/td[3]")).getText();
			System.out.println(s+"  "+d+"  "+e);
		
		}	
	}
	
		}

}
