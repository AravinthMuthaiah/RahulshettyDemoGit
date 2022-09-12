package brokenLink;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootStrapDDn {

	public static void main(String[] args) {
		
		
WebDriverManager.chromedriver().setup();

ChromeOptions options=new ChromeOptions();
options.addArguments("--disable-notifications");
WebDriver driver=new ChromeDriver(options);
driver.get("https://www.hdfcbank.com/");
driver.manage().window().maximize();

//1, First drop down select product type
driver.findElement(By.xpath("//a[text()='Select Product Type']//parent::div[@class='dropdown']")).click();

List<WebElement>productType=driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']//li"));
System.out.println(productType.size());

//Selecting the Health Insurance from the drop down
for(WebElement product:productType)
{
	if(product.getText().equals("Health Insurance")) {
		String txt=product.getText();
		product.click();
		System.out.println("Text selected in the first drop down is:"+txt);
		break;
	}
}

//2, First drop down select product type

driver.findElement(By.xpath("//a[text()='Select Product']")).click();

List<WebElement>products=driver.findElements(By.xpath("//ul[@class='dropdown2 dropdown-menu']//li"));
System.out.println("Number of products present in the product drop down is:"+products.size());

for(WebElement pro:products) {
	if(pro.getText().equals("Super Top-up Insurance")) {
		String txt1=pro.getText();
		pro.click();
		System.out.println("Text selected in the second drop down is:"+txt1);
		break;
	}
}




	}

}
