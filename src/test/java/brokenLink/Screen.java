package brokenLink;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screen {

	public static void main(String[] args) throws IOException {
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();

driver.get("http://leafground.com/");
driver.manage().window().maximize();

TakesScreenshot ts=(TakesScreenshot)driver;
File src=ts.getScreenshotAs(OutputType.FILE);
File des=new File("E:\\SDET QA\\output.png");
FileUtils.copyFile(src, des);
	}

}
