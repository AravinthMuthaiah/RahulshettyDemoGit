package brokenLink;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Teble {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		driver.get("https://cosmocode.io/automation-practice-webtable/");
		driver.manage().window().maximize();
		
		List<WebElement> rows=driver.findElements(By.xpath("//table[@id='countries']/tbody/tr"));
		for(int i=1;i<rows.size();i++){
			
			WebElement primaryLanguage=driver.findElement(By.xpath("//table[@id='countries']/tbody/tr["+i+"]/td[5]"));
			String lang=primaryLanguage.getText();
			if(lang.equals("Albanian")) {
				driver.findElement
(By.xpath("//table[@id='countries']/tbody/tr[3]/td[5]//preceding-sibling::td/input[@class='hasVisited']")).click();
				
			}
		
		
	}
		
//		List<WebElement> rows=driver.findElements(By.xpath("//table[@id='countries']/tbody/tr"));
//		for(int i=1;i<rows.size();i++){
//			WebElement row=rows.get(i);
//		List<WebElement> datas=driver.findElements(By.xpath("//table[@id='countries']/tbody/tr/td"));
//		for(int j=1;j<datas.size();j++){
//		WebElement data=datas.get(j);
//		String text=data.getText();
//		if(text.equals("Albanian")){
//		WebElement element=driver.findElement(By.xpath("//table[@id='countries']/tbody/tr["+i+"]/td["+j+"]//precedingsibling::td[1]"));
//		String txt=element.getText();
//		System.out.println(txt);
//		}
//		}
//		}

}
}