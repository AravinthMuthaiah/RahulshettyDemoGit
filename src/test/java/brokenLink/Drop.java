package brokenLink;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drop {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("https://seleniumbase.io/demo_page");
driver.manage().window().maximize();

WebElement dDn=driver.findElement(By.xpath("//select[@class='selectClasses']"));
Select s=new Select(dDn);
List<WebElement>options=s.getOptions();
for(int i=0;i<options.size();i++) {
	WebElement element=options.get(i);
	String txt=element.getText();
	if(txt.equalsIgnoreCase("set to 50%")) {
		element.click();
		System.out.println(txt);
	}
}
	}

}
