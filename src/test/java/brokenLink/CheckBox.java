package brokenLink;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("https://itera-qa.azurewebsites.net/home/automation");
driver.manage().window().maximize();

List<WebElement>checkBoxes=driver.findElements(By.xpath("//input[@type='checkbox'and contains(@id,'day')]"));
//1, Selecting the last two check boxes
/*for(int i=checkBoxes.size()-2;i<checkBoxes.size();i++) {
	checkBoxes.get(i).click();
}*/
//2, Selecting the first two check boxes
for(int i=0;i<checkBoxes.size();i++) {
	if(i<2) {
		checkBoxes.get(i).click();
	}
}
	}

}
