package org.packagename;

import java.io.File;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadAFileExcel {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/");
		driver.manage().window().maximize();
		
		WebElement btnDown=driver.findElement(By.xpath("//*[@alt='Download']"));
		btnDown.click();
		
		//1.Selecting the download excel link
		WebElement excelLink=driver.findElement(By.linkText("Download Excel"));
		excelLink.click();
		Thread.sleep(4000);
		
		File f=new File("C:\\Users\\Lenovo\\Downloads");
		
		/*File[] --Class
		 * listFiles()--Method
		 * getName()-- Method */
		
		File[] files=f.listFiles();
		for(File file:files) {
			String s=file.getName();
			if(s.equals("testleaf.xlsx")){
				System.out.println(s);
				System.out.println("The file is downloaded");
				break;
			}else {
				System.out.println("The File is not downloaded");
			}
		}
	}
}
