package brokenLink;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebT {
	static WebDriver driver;
	public WebT() {
		PageFactory.initElements(driver,this);
	}
	public void method() {
		
	
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.navigate().to("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");
	driver.manage().window().maximize();

	List<WebElement>rows=driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));
	for(int i=1;i<=rows.size();i++) {
		WebElement name=driver.findElement(By.xpath("//table[@id='example']//tbody//tr["+i+"]//td[2]"));
		String txt=name.getText();
		
		if(txt.equals("Bruno Nash")) {
			System.out.println(txt+" " +i);
			WebElement checkBox=driver.findElement(By.xpath("//table[@id='example']//tr["+i+"]//td[1]"));
			checkBox.click();
			System.out.println((driver.findElement(By.xpath("//table[@id='example']//tr["+i+"]//td[3]")).getText()));
		driver.navigate().refresh();
		if(checkBox.isSelected()==true) {
			System.out.println("check box is already selected");
		}else {
			checkBox.click();
		}
		}
	}
	}
	public static void main(String[] args) {
		WebT w=new WebT();
		w.method();

}
}