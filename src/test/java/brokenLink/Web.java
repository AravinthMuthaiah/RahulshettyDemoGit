package brokenLink;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Web {

	public static void main(String[] args) {

		ChromeOptions options=new ChromeOptions();
		options.addArguments("start-maximized");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://qavbox.github.io/demo/webtable/");
		
		//1. To print the headers from the table
		WebElement table=driver.findElement(By.xpath("//table[@id='table01']"));
		
		List<WebElement>tableHeaders=table.findElements(By.tagName("th"));
		for(int i=0;i<tableHeaders.size();i++) {
			WebElement tableHeader=tableHeaders.get(i);
			String header=tableHeader.getText();
			System.out.println(header);
		}
		System.out.println("-----------------------------------------------");
		
		//2. To print the rows from the table
		
		List<WebElement>tableRows=table.findElements(By.xpath("//table[@id='table01']//tbody//tr"));
		for(WebElement tableRow:tableRows) {
			String rows=tableRow.getText();
			System.out.println(rows);	
		}
		
		System.out.println("-----------------------------------------------");
		
		//3.To print the datas from the table
		List<WebElement>tableDeletes=table.findElements
				(By.xpath("//table[@id='table01']//tbody//tr//td//following::input[@class='btn']"));
	//	for(int k=0;k<tableDeletes.size();k++) {
			
		
		List<WebElement>tableDatas=table.findElements(By.xpath("//table[@id='table01']//tbody//tr//td"));
		
		for(int j=0;j<tableDatas.size();j++) {
			WebElement tableData=tableDatas.get(j);
			String datas= tableData.getText();
			System.out.println(datas);
			
			if(datas.equals("Bugzilla")) {
				WebElement tableDelete=tableDeletes.get(0);
				tableDelete.click();
			}
			
			}
		System.out.println("-----------------------------------------------");
		}
		
		
		
		
		
		
		
	}


