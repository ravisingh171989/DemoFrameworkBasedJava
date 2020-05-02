package Pages.SearchProductPage;

public interface SearchProductPage {
	public void clickSearchTextbox(String productName);
	public void clickFirstSuggestionFromSearchBox(String SelectItem, String ItemAssertion);	
	public void selectItemAfterScroll();
}
