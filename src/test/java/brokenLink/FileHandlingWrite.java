package brokenLink;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class FileHandlingWrite {

	public static void main(String[] args) throws IOException {
File f=new File("E:\\SDET QA\\File Operations\\Java\\Selenium\\Java.txt");
//To write in the 
FileUtils.write(f, "Hi this is Aravinth \n I am from chennai",false);
//String s=FileUtils.readFileToString(f);
//System.out.println(s);
List<String>s=FileUtils.readLines(f);
for(String x:s) {
	System.out.println(x);
}
	}

}
