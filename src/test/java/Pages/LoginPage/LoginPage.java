package Pages.LoginPage;
/*
 * Added a interface for having flexibility of running tests against both Android & iOS  
 */
public interface LoginPage {
	public void CheckLoginPageForExceptions();
	public void clickLoginButton();
	public void enterUsername(String username);
	public void enterEmptyUsername();
	public void enterInvalidUsername();
	public void clickContinueButton();
	public void enterPassword(String password);
	public void enterEmptyPassword();
	public void enterInvalidPassword();
	public void signInSubmitButton();
}
