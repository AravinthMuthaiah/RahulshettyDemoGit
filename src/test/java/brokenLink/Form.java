package brokenLink;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Form {

	public static void main(String[] args) throws AWTException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		
		driver.get("https:demoqa.com/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("(//div[@class='avatar mx-auto white'])[2]")).click();

		driver.findElement(By.xpath("//span[contains(text(),'Form')]")).click();
		
		// First Name
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Blake");
		
		// Last Name
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Cam");
		
	 //Email id
		WebElement txtEmail = driver.findElement(By.xpath("//input[@placeholder='name@example.com']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','blake@gmail.com')", txtEmail);
		Object emailId = js.executeScript("return arguments[0].getAttribute('value')", txtEmail);
		String s = (String) emailId;
		System.out.println(s);

		// Gender Selection
		List<WebElement> genders = driver.findElements(By.xpath("//div[@id='genterWrapper']//child::label"));
		for (WebElement gender : genders) {
			String text = gender.getText();
			if (text.equalsIgnoreCase("male")) {
				gender.click();
				System.out.println(text);

			}
		}
		
		//Mobile Number
		WebElement mobNumber = driver.findElement(By.xpath("//input[@placeholder='Mobile Number']"));
		if(mobNumber.isEnabled()) {
			mobNumber.sendKeys("1234567890");
			if(mobNumber.getAttribute("value").equals("1234567890")) {
				String num=mobNumber.getAttribute("value");
				System.out.println(num + true);
				}else {
					System.out.println(false);
				}
		}
		
		 //Date Picker
		WebElement datePicker=driver.findElement(By.id("dateOfBirthInput"));
		datePicker.click();
		
		WebDriverWait w=new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.presenceOfElementLocated(By.className("react-datepicker-popper")));
		
		//Drop Down Month
		WebElement ddnMonth=driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
		Select s1=new Select(ddnMonth);
		List<WebElement>options=s1.getOptions();
		for (WebElement webElement : options) {
			if(webElement.getText().equalsIgnoreCase("august")){
				String m=webElement.getText();
				System.out.println(m);
				webElement.click();
			}
		}
		
		//Drop Down Year
		WebElement ddnYear=driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
		Select s2=new Select(ddnYear);
		List<WebElement>yearOptions=s2.getOptions();
		for(int i=0;i<yearOptions.size();i++) {
			WebElement option=yearOptions.get(i);
			if(option.getText().equals("1996")) {
				String y=option.getText();
				System.out.println(y);
				option.click();
				break;
			}
			
		}
		
		//Date Selection
		List<WebElement>dates=driver.findElements
				(By.xpath("//div[@class='react-datepicker__week']//child::div[@role='option']"));
		for(int j=0;j<dates.size();j++) {
			WebElement date=dates.get(j);
			String text=date.getText();
			if(text.equals("11")) {
				System.out.println(text);
				date.click();
				break;
			}
		}
		
		String dob=datePicker.getAttribute("value");
		if(dob.equals("11 Aug 1996")) {
			System.out.println(dob);	
		}
		
//		Subject box
		
//		WebElement sub=driver.findElement(By.xpath("(//div[@class='css-1g6gooi']//div//child::input[@autocapitalize='none'])[1]"));
//		sub.sendKeys("mat");
//		String tex=sub.getAttribute("value");
//		if(tex.equalsIgnoreCase("maths")) {
//			System.out.println("Subject Selected"+tex);	
//		}
		
//		String tex;
//		do {
//			sub.sendKeys(Keys.ARROW_DOWN);
//			tex=sub.getAttribute("value");
//			if(tex.equalsIgnoreCase("maths")) {
//				System.out.println("Subject is"+tex);
//				sub.sendKeys(Keys.ENTER);
//				break;
//			}
//		}while(!tex.isEmpty());
		
		//Hobbies
		List<WebElement>hobbies=driver.findElements
				(By.xpath("//input[@type='checkbox']//following::label[@class='custom-control-label']"));
		for (WebElement hob : hobbies) {
			String txt=hob.getText();
			if(txt.equalsIgnoreCase("reading")) {
				hob.click();
				System.out.println(txt);
				
			}
		}
		
		//Upload a file
		WebElement up=driver.findElement(By.xpath("//input[@id='uploadPicture']"));
		String file="C:\\Users\\Lenovo\\Downloads\\sampleFile.jpeg";
		up.sendKeys(file);
		
		
		//Address Box
		
		WebElement address=driver.findElement(By.xpath("//textarea[@placeholder='Current Address']"));
		address.sendKeys("No:6");
		String add=address.getAttribute("value");
		System.out.println("Address is:"+add);
		}
	
	
	
	

}
