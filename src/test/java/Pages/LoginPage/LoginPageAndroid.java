package Pages.LoginPage;

import Pages.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class LoginPageAndroid extends BasePage implements LoginPage {

	public LoginPageAndroid(AndroidDriver<MobileElement> driver) throws Exception {
		super(driver);
	}

	public void CheckLoginPageForExceptions() {
		LoginButton.isDisplayed();
	}
	
	public void clickLoginButton() {
		LoginButton.click();
		takeScreenshot("login2");
	}
	
	public void enterUsername(String username) {
		takeScreenshot("enterUsername");
		emailTextField.sendKeys(username);
		takeScreenshot("enterUsername2");
	}
	
	public void enterEmptyUsername() {
		takeScreenshot("enterEmptyUsername");
		emailTextField.sendKeys("");
		takeScreenshot("enterEmptyUsername2");
	}
	
	public void enterInvalidUsername() {
		takeScreenshot("enterInvalidUsername");
		emailTextField.sendKeys("TestInvalidUsername");
		takeScreenshot("enterInvalidUsername2");
	}
	
	public void clickContinueButton() {
		takeScreenshot("continueButton");
		continueButton.click();
		takeScreenshot("continueButton2");
	}
	
	public void enterPassword(String password) {
		takeScreenshot("enterPassword");
		enterPassword.sendKeys(password);
		takeScreenshot("enterPassword2");
	}
	
	public void enterEmptyPassword() {
		takeScreenshot("enterEmptyPassword");
		enterPassword.sendKeys("");
		takeScreenshot("enterEmptyPassword2");
	}
	
	public void enterInvalidPassword() {
		takeScreenshot("enterInvalidPassword");
		enterPassword.sendKeys("ksdfhskdjh");
		takeScreenshot("enterInvalidPassword2");
	}

	public void signInSubmitButton() {
		takeScreenshot("signInSubmitButton");
		signInSubmitButton.click();
		takeScreenshot("signInSubmitButton2");
	}
}
