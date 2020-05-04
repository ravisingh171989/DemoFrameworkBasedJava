package Tests.TestScenarioAddingToWishlist;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import Pages.BasePage;
import Pages.LoginPage.LoginPage;
import Pages.LoginPage.LoginPageAndroid;
import Pages.LoginPage.LoginPageiOS;
import Pages.SearchProductPage.SearchProductPage;
import Pages.SearchProductPage.SearchProductPageAndroid;
import Pages.SearchProductPage.SearchProductPageiOS;
import Tests.TestBase;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;

public class TestScenarioAddingToCart extends TestBase {

	public TestScenarioAddingToCart() throws Exception {
		super();
	}

	private LoginPage loginPage;
	private SearchProductPage searchProductPage;
	
	String username = readingExcel.getCellData("DemonstrationTest", "Username", 2);
	String password = readingExcel.getCellData("DemonstrationTest", "Password", 2);
	String productName = readingExcel.getCellData("DemonstrationTest", "ProductSearch", 2);
	String searchString = readingExcel.getCellData("DemonstrationTest", "SelectItem", 2);
	String itemAssertion = readingExcel.getCellData("DemonstrationTest", "ItemAssertion", 2);

	@BeforeTest
	public void setUpPage() throws Exception {
		switch (TestBase.executionOS) {
		case ANDROID:
			loginPage = new LoginPageAndroid(driver);
			searchProductPage = new SearchProductPageAndroid(driver);

			break;
			
		case IOS:
			loginPage = new LoginPageiOS(driver);
			searchProductPage = new SearchProductPageiOS(driver);
			break;
			
		default:
			break;
		}
	}

	@Severity(SeverityLevel.CRITICAL)
	@Test
	@Description("This is coding demonstration test")
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
		
		BasePage.closeLanguageDialog();
		searchProductPage.clickSearchTextbox(productName);
		searchProductPage.clickFirstSuggestionFromSearchBox(searchString, itemAssertion);
		
		BasePage.useMyCurrentLocationClick();
		searchProductPage.selectItemAfterScroll();
		
		BasePage.orientationTest();
	}
}
