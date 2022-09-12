package brokenLink;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Slider {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/slider/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		WebElement slider=driver.findElement(By.xpath("//span[@tabindex='0']"));
		Point p=slider.getLocation();
		System.out.println(p);
		Dimension size=slider.getSize();
		System.out.println(size);
		
		Actions a=new Actions(driver);
		a.dragAndDropBy(slider, 100, 0).perform();
		Point p1=slider.getLocation();
		System.out.println(p1);
		
	}

}
