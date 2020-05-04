package Pages.SearchProductPage;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;

import Pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import ru.yandex.qatools.allure.annotations.Step;

public class SearchProductPageAndroid extends BasePage implements SearchProductPage {

	public SearchProductPageAndroid(AppiumDriver<MobileElement> driver) throws Exception {
		super(driver);
	}
	
	/*
	 * This methods performs following:
	 * Enters item to be searched from search box
	 */
	@Step("Click on search textbox and enter a product name to search")
	public void clickSearchTextbox(String productName) {
		takeScreenshot("searchTextBox");
		searchTextBox.click();
		BasePage.sleep(3);
		searchTextBox.sendKeys(productName);
		takeScreenshot("searchTextBox2");
	}
	
	/*
	 * This methods performs following:
	 * Clicks on first suggested option from search box
	 */
	@Step("Click on first suggested product from listing")
	public void clickFirstSuggestionFromSearchBox(String SelectItem, String ItemAssertion) {
		takeScreenshot("firstSuggestedSearchClick");
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+SelectItem+"']")).click();
		takeScreenshot("firstSuggestedSearchClick2");
		
		/*Verify first Item*/
		String actualText = driver.findElement(By.xpath("//android.widget.TextView[@text='"+ItemAssertion+"']")).getText();
		assertEquals(actualText, ItemAssertion);
		
	}
	
	/*
	 * This methods performs following:
	 * Select item which is needed to be added to wishlist
	 * Scrolling to Add the product to wishlist
	 */
	@Step("Click on Add to Cart button")
	public void selectItemAfterScroll() {
		takeScreenshot("selectItem");
		selectItem.click();
		BasePage.sleep(5);
		BasePage.closeLanguageDialog();
		
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)."
				+ "instance(0)).scrollIntoView(new UiSelector()."
				+ "textContains(\""+"Add to Cart"+"\").instance(0))"));
		addToCartButton.click();
		BasePage.sleep(5);
		takeScreenshot("selectItem2");
	}

}
