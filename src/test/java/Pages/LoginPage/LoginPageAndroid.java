package Pages.LoginPage;

import Pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import ru.yandex.qatools.allure.annotations.Step;

public class LoginPageAndroid extends BasePage implements LoginPage {

	public LoginPageAndroid(AppiumDriver<MobileElement> driver) throws Exception {
		super(driver);
	}
	
	@Step("Verify login page")
	public void CheckLoginPageForExceptions() {
		LoginButton.isDisplayed();
	}
	
	@Step("Clicking on login button")
	public void clickLoginButton() {
		LoginButton.click();
		takeScreenshot("login2");
	}
	
	@Step("Enter valid username")
	public void enterUsername(String username) {
		takeScreenshot("enterUsername");
		BasePage.sleep(5);
		emailTextField.sendKeys(username);
		takeScreenshot("enterUsername2");
	}
	
	@Step("Entering on empty input to username textbox")
	public void enterEmptyUsername() {
		takeScreenshot("enterEmptyUsername");
		emailTextField.sendKeys("");
		takeScreenshot("enterEmptyUsername2");
	}
	
	@Step("Entering on invalid input to username textbox")
	public void enterInvalidUsername() {
		takeScreenshot("enterInvalidUsername");
		BasePage.sleep(5);
		emailTextField.sendKeys("TestInvalidUsername");
		takeScreenshot("enterInvalidUsername2");
	}
	
	@Step("Clicking on continue button")
	public void clickContinueButton() {
		takeScreenshot("continueButton");
		continueButton.click();
		takeScreenshot("continueButton2");
	}
	
	@Step("Entering on valid input to password textbox")
	public void enterPassword(String password) {
		takeScreenshot("enterPassword");
		BasePage.sleep(5);
		enterPassword.sendKeys(password);
		takeScreenshot("enterPassword2");
	}
	
	@Step("Passing empty input to password textbox")
	public void enterEmptyPassword() {
		takeScreenshot("enterEmptyPassword");
		BasePage.sleep(5);
		enterPassword.sendKeys("");
		takeScreenshot("enterEmptyPassword2");
	}
	
	@Step("Passing invlalid input to password textbox")
	public void enterInvalidPassword() {
		takeScreenshot("enterInvalidPassword");
		BasePage.sleep(5);
		enterPassword.sendKeys("ksdfhskdjh");
		takeScreenshot("enterInvalidPassword2");
	}

	@Step("Clicking on Submit Button")
	public void signInSubmitButton() {
		takeScreenshot("signInSubmitButton");
		signInSubmitButton.click();
		takeScreenshot("signInSubmitButton2");
	}
}
