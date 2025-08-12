import java.*;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class launchChrome {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		File oneFile = screenshot.getScreenshotAs(OutputType.FILE);
		File newlocFile = new File("/Users/anand/Desktop/one.png");
		FileUtils.copyFile(oneFile, newlocFile);
		driver.quit();
	}
}
