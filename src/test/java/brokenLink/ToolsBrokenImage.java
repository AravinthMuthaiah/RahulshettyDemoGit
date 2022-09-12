package brokenLink;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToolsBrokenImage {
	static WebDriver driver;
	public ToolsBrokenImage(){
		PageFactory.initElements(driver, this);
	}

	public static void main(String[] args) throws IOException {
WebDriverManager.chromedriver().setup();
driver=new ChromeDriver();
driver.navigate().to("https://demoqa.com/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


 WebElement form=driver.findElement(By.xpath("(//div[@class='avatar mx-auto white'])[2]"));
 form.click();
 
 

 WebElement element = driver.findElement(By.xpath("//div[text()='Elements']"));
element.click();

WebElement ele = driver.findElement(By.xpath("//div[text()='Interactions']"));
System.out.println(ele.getText());
JavascriptExecutor js=(JavascriptExecutor)driver;
js.executeScript("arguments[0].scrollIntoView(true)",ele);	

List<WebElement> typeOfElements = driver.findElements(By.xpath("//div[@class='element-list collapse show']/ul/li/span"));
for (WebElement webElement : typeOfElements) {
	String text = webElement.getText();
	if(text.equalsIgnoreCase("Broken Links - Images")) {
		webElement.click();
		System.out.println(text);
		
	}
}

//Broken Image and valid Image
int validImageCount=0,brokenImageCount=0;
List<WebElement> images = driver.findElements(By.tagName("img"));
for (WebElement img : images) {
	String attribute = img.getAttribute("src");
	if(attribute!=null) {
		if(attribute.contains("https")) {
			URL url=new URL(attribute);
			URLConnection openConnection = url.openConnection();
			HttpURLConnection http=(HttpURLConnection)openConnection;
			int responseCode=http.getResponseCode();
			if(responseCode==200) {
				System.out.println("Valid Image :" +attribute +"   "+responseCode);
				validImageCount++;
			}else {
				
				System.out.println("Broken Image :" +attribute +"   "+responseCode);
				brokenImageCount++;
			}
			
		}
	}
}
System.out.println("Number of Broken Image count is:" +brokenImageCount);
System.out.println("Number of Valid Image count is:" +validImageCount);

//Broken Link and valid Link
int validLinkCount=0,brokenLinkCount=0;
List<WebElement> links = driver.findElements(By.tagName("a"));
for (WebElement link : links) {
	String attribute1 = link.getAttribute("href");
	link.click();
	
	if(driver.getCurrentUrl().contains("500")) {
		System.out.println("Broken Link :" +attribute1 );
		brokenLinkCount++;
		driver.navigate().back();
	}else {
		System.out.println("Valid Link :" +attribute1 );
		validLinkCount++;
		driver.navigate().back();
	}



	}
System.out.println("Number of Broken Link count is:" +brokenLinkCount);
System.out.println("Number of Valid Link count is:" +validLinkCount);

}
}