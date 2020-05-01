package Pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
/*Class which has */
public abstract class BasePage {

	@FindBy(id = "sign_in_button")
	protected WebElement LoginButton;
	
	@FindBy(xpath = "//android.widget.EditText[@resource-id='ap_email_login']")
	protected WebElement emailTextField;
	
	@FindBy(xpath = "//android.widget.Button[@text='Continue']")
	protected WebElement continueButton;
	
	@FindBy(xpath = "//android.widget.EditText[@resource-id='ap_password']")
	protected WebElement enterPassword;
	
	@FindBy(xpath  = "//android.widget.Button[@resource-id='signInSubmit']")
	protected WebElement signInSubmitButton;
	
	@FindBy(xpath = "//android.view.View[@text='close']")
	protected static WebElement closeLanguageDialog;
	
	@FindBy(xpath = "//android.widget.EditText[@resource-id='com.amazon.mShop.android.shopping:id/rs_search_src_text']")
	protected WebElement searchTextBox;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.amazon.mShop.android.shopping:id/iss_search_dropdown_item_text']")
	protected WebElement firstSuggestedSearchClick;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.amazon.mShop.android.shopping:id/loc_ux_update_current_pin_code']")
	protected static WebElement useMyCurrentLocationClick;
	
	@FindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	protected static WebElement allowLocationButton;
	
	@FindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout[3]")
	protected WebElement selectItem;
	
	@FindBy(xpath = "//android.view.View[@resource-id='add-to-wishlist-button-submit'][@text='ADD TO WISH LIST']")
	protected WebElement wishlistButtonStack;
	
	@FindBy(xpath = "//android.widget.Button[@class='android.widget.Button']")
	protected MobileElement sizeButtons;

	static WebDriverWait wait;

	protected static Dimension size;

	protected static AndroidDriver<MobileElement> driver;
	
	public BasePage(AndroidDriver<MobileElement> driver) throws Exception {
		BasePage.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); 	
	}

	public static boolean takeScreenshot(final String name) {
		String screenshotDirectory = System.getProperty("appium.screenshots.dir",
				System.getProperty("java.io.tmpdir", ""));
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		return screenshot.renameTo(new File(screenshotDirectory, String.format("%s.png", name)));
	}

	public static void sleep(int sleeptime) {
		try {
			Thread.sleep(sleeptime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeLanguageDialog() {
		takeScreenshot("closeLanguageDialog");
		try {
			closeLanguageDialog.click();
		} catch (Exception e) {
			System.err.println("Unable to click Login button");
		}
		takeScreenshot("closeLanguageDialog2");
	}
	
	public static void useMyCurrentLocationClick() {
		takeScreenshot("useMyCurrentLocationClick");
		try {
			useMyCurrentLocationClick.click();
		} catch (Exception e) {
			System.err.println("use My Current Location button not present");
		}
		takeScreenshot("useMyCurrentLocationClick2");
		
		takeScreenshot("allowLocationButton");
		try {
			allowLocationButton.click();
		} catch (Exception e) {
			System.err.println("allow Location Button  not present");
		}
		takeScreenshot("allowLocationButton2");
	}
	
	public static void orientationTest() {
		driver.rotate(new DeviceRotation(0, 0, 90));
		takeScreenshot("selectItem");
		BasePage.sleep(2);
		driver.rotate(new DeviceRotation(0, 0, 180));
		takeScreenshot("selectItem");
		BasePage.sleep(2);
		driver.rotate(new DeviceRotation(0, 0, 270));
		takeScreenshot("selectItem");
		BasePage.sleep(2);
		driver.rotate(new DeviceRotation(0, 0, 0));
		takeScreenshot("selectItem");
		BasePage.sleep(2);
	}
}
