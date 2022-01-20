package pageObjects.jQuery;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.jQuery.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPageByNumber(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGING_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGING_BY_NUMBER, pageNumber);
	}

	public boolean isPageActivedByNumber(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGE_NUMBER_ACTIVED);
		return isElementDisplay(driver, HomePageUI.PAGE_NUMBER_ACTIVED);
	}

	public void inputToHeaderTextboxByName(String headerName, String valueText) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_NAME, headerName);
		sendkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_NAME, valueText, headerName);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_NAME, Keys.ENTER, headerName);
	}

	public void clickToIconByCountryName(String countryName, String valueText) {
		waitForClickable(driver, HomePageUI.ICON_BY_COUNTRY_NAME, countryName, valueText);
		clickToElement(driver, HomePageUI.ICON_BY_COUNTRY_NAME, countryName, valueText);

	}

	public boolean isRowValueDisplayed(String femaleValue, String countryName, String maleValue, String totalValue) {
		waitForElementVisible(driver, HomePageUI.ROW_VALUE_BY_FEMALE_COUNTRY_MALE_TOTAL, femaleValue, countryName, maleValue, totalValue);
		return isElementDisplay(driver, HomePageUI.ROW_VALUE_BY_FEMALE_COUNTRY_MALE_TOTAL, femaleValue, countryName, maleValue, totalValue);
	}

	public void clickToAppendRowButton() {
		waitForClickable(driver, HomePageUI.APPEND_ROW);
		clickToElement(driver, HomePageUI.APPEND_ROW);
	}

	public void inputToTextboxByRowNumber(String headerName, String rowNumber, String valueText) {
		int columnIndex = getElementSize(driver, HomePageUI.HEADER_NAME_INDEX, headerName) + 1;
		waitForElementVisible(driver, HomePageUI.CELL_VALUE_BY_ROW_COLUMN_INDEX, rowNumber, String.valueOf(columnIndex));
		sendkeyToElement(driver, HomePageUI.CELL_VALUE_BY_ROW_COLUMN_INDEX, valueText, rowNumber, String.valueOf(columnIndex));
	}

	public void clickToIconByRow(String rowIndex, String valueText) {
		waitForClickable(driver, HomePageUI.ICON_BY_ROW_NUMBER, rowIndex, valueText);
		clickToElement(driver, HomePageUI.ICON_BY_ROW_NUMBER, rowIndex, valueText);
	}
}
