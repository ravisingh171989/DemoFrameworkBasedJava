package Tests.TestScenarioAddingToWishlist;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import Pages.BasePage;
import Pages.LoginPage.LoginPage;
import Pages.LoginPage.LoginPageAndroid;
import Pages.SearchProductPage.SearchProductPage;
import Pages.SearchProductPage.SearchProductPageAndroid;
import Tests.TestBase;

public class TestScenarioAddingToWishlist extends TestBase {

	public TestScenarioAddingToWishlist() throws Exception {
		super();
	}

	private LoginPage loginPage;
	private SearchProductPage searchProductPage;
	
	String username = readingExcel.getCellData("Sheet1", "Username", 2);
	String password = readingExcel.getCellData("Sheet1", "Password", 2);
	String productName = readingExcel.getCellData("Sheet1", "ProductSearch", 2);
	String searchString = readingExcel.getCellData("Sheet1", "SelectItem", 2);

	@BeforeTest
	public void setUpPage() throws Exception {
		switch (TestBase.executionOS) {
		case ANDROID:
			loginPage = new LoginPageAndroid(driver);
			searchProductPage = new SearchProductPageAndroid(driver);

			break;
		default:
			break;
		}
	}

	@Test
	public void LoginPageTestMethods() {
		/* LoginPageTests */
		loginPage.CheckLoginPageForExceptions();
		loginPage.clickLoginButton();
		
		loginPage.enterEmptyUsername();
		loginPage.clickContinueButton();
		
		loginPage.enterInvalidUsername();
		loginPage.clickContinueButton();
		
		loginPage.enterUsername(username);
		loginPage.clickContinueButton();
		
		loginPage.enterEmptyPassword();
		loginPage.signInSubmitButton();
		
		loginPage.enterInvalidPassword();
		loginPage.signInSubmitButton();
		
		loginPage.enterPassword(password);
		loginPage.signInSubmitButton();
		
		/*Adding a product to wishlist*/
		BasePage.closeLanguageDialog();
		searchProductPage.clickSearchTextbox(productName);
		searchProductPage.clickFirstSuggestionFromSearchBox();
		
		BasePage.useMyCurrentLocationClick();
		searchProductPage.selectItemAfterScroll();
		
		BasePage.orientationTest();
	}
}
