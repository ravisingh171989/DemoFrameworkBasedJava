package Tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import Pages.ExcelReading;
import driver.deviceAndroid;

public abstract class TestBase {

	private final static String URL_STRING = "http://127.0.0.1:4723/wd/hub";

	public static AndroidDriver<MobileElement> driver;
	static WebDriverWait wait;

	/*
	 * Depending upon which platform is to tested, tester need to change the OS
	 * value either to: ANDROID, IOS or WEB
	 */
	public static OS executionOS = OS.ANDROID;

	public enum OS {
		ANDROID
	}

	public static final String File_TestData = "TestData.xlsx";

	/* This to set the File path and to open the Excel file, Pass Excel Path
	* and Sheetname as Arguments to this method protected ExcelReading
	*/
	protected ExcelReading readingExcel = new ExcelReading(File_TestData);

	public TestBase() throws Exception {
	
	}

	@BeforeTest
	public abstract void setUpPage() throws Exception;

	@BeforeSuite
	public static void initAppium() throws MalformedURLException {

		URL url = new URL(URL_STRING);

		switch (executionOS) {
		case ANDROID:

			DesiredCapabilities capabilitiesAndroid = new DesiredCapabilities();
			capabilitiesAndroid.setCapability(MobileCapabilityType.PLATFORM_NAME, deviceAndroid.platformName);
			capabilitiesAndroid.setCapability(MobileCapabilityType.DEVICE_NAME, deviceAndroid.deviceName);
			capabilitiesAndroid.setCapability(MobileCapabilityType.AUTOMATION_NAME, deviceAndroid.automationName);
			capabilitiesAndroid.setCapability(MobileCapabilityType.APP, "/Users/Anand/Testing/Practice/DemoFrameworkCognizant/apps/Amazon_shopping.apk");
			capabilitiesAndroid.setCapability("appPackage", deviceAndroid.appPackage);
			capabilitiesAndroid.setCapability("appActivity", deviceAndroid.appActivity);
			capabilitiesAndroid.setCapability(MobileCapabilityType.NO_RESET, false);

			driver = new AndroidDriver<MobileElement>(url, capabilitiesAndroid);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			break;
			
		default:
			break;
		}
	}

	@AfterSuite
	public void tearDownAppium() {
		if (driver != null) {
			driver.quit();
		}
	}
}