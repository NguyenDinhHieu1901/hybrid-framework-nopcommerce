package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserAddressesPageUI;

public class UserAddressesPageObject extends BasePage {
	private WebDriver driver;

	public UserAddressesPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAddNewButton() {
		waitForClickable(driver, UserAddressesPageUI.ADD_NEW_ADDRESS_BUTTON);
		clickToElement(driver, UserAddressesPageUI.ADD_NEW_ADDRESS_BUTTON);
	}

	public void inputToFirstNameTextbox(String firstNameUpdate) {
		waitForElementVisible(driver, UserAddressesPageUI.FIRST_NAME_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, UserAddressesPageUI.FIRST_NAME_ADDRESS_TEXTBOX, firstNameUpdate);
	}

	public void inputToLastNameTextbox(String lastNameUpdate) {
		waitForElementVisible(driver, UserAddressesPageUI.LAST_NAME_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, UserAddressesPageUI.LAST_NAME_ADDRESS_TEXTBOX, lastNameUpdate);
	}

	public void inputToEmailTextbox(String emailAddressUpdate) {
		waitForElementVisible(driver, UserAddressesPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, UserAddressesPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddressUpdate);
	}

	public void inputToCompanyNameTextbox(String companyNameUpdate) {
		waitForElementVisible(driver, UserAddressesPageUI.COMPANY_NAME_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, UserAddressesPageUI.COMPANY_NAME_ADDRESS_TEXTBOX, companyNameUpdate);
	}

	public void selectCountryInDefaultDropdown(String countryName) {
		waitForElementVisible(driver, UserAddressesPageUI.COUNTRY_DEFAULT_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserAddressesPageUI.COUNTRY_DEFAULT_DROPDOWN, countryName);
	}

	public void inputToCityTextbox(String cityName) {
		waitForElementVisible(driver, UserAddressesPageUI.CITY_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, UserAddressesPageUI.CITY_ADDRESS_TEXTBOX, cityName);
	}

	public void inputToAddress1Textbox(String address1) {
		waitForElementVisible(driver, UserAddressesPageUI.ADDRESS1_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, UserAddressesPageUI.ADDRESS1_ADDRESS_TEXTBOX, address1);
	}

	public void inputToAddress2Textbox(String address2) {
		waitForElementVisible(driver, UserAddressesPageUI.ADDRESS2_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, UserAddressesPageUI.ADDRESS2_ADDRESS_TEXTBOX, address2);
	}

	public void inputToZipCodeTextbox(String zipCode) {
		waitForElementVisible(driver, UserAddressesPageUI.ZIP_CODE_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, UserAddressesPageUI.ZIP_CODE_ADDRESS_TEXTBOX, zipCode);
	}

	public void inputToPhoneNumberTextbox(String phoneNumber) {
		waitForElementVisible(driver, UserAddressesPageUI.PHONE_NUMBER_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, UserAddressesPageUI.PHONE_NUMBER_ADDRESS_TEXTBOX, phoneNumber);
	}

	public void inputToFaxNumberTextbox(String faxNumber) {
		waitForElementVisible(driver, UserAddressesPageUI.FAX_NUMBER_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, UserAddressesPageUI.FAX_NUMBER_ADDRESS_TEXTBOX, faxNumber);
	}

	public void clickToSaveButton() {
		waitForClickable(driver, UserAddressesPageUI.SAVE_BUTTON);
		clickToElement(driver, UserAddressesPageUI.SAVE_BUTTON);
	}

	public String getNameOfUser() {
		sleepInSecond(2);
		waitForElementVisible(driver, UserAddressesPageUI.NAME_USER_UPDATED);
		return getElementText(driver, UserAddressesPageUI.NAME_USER_UPDATED);
	}

	public String getEmailOfUser() {
		waitForElementVisible(driver, UserAddressesPageUI.EMAIL_USER_UPDATED);
		return getElementText(driver, UserAddressesPageUI.EMAIL_USER_UPDATED);
	}

	public String getCountryOfUser() {
		waitForElementVisible(driver, UserAddressesPageUI.COUNTRY_USER_UPDATED);
		return getElementText(driver, UserAddressesPageUI.COUNTRY_USER_UPDATED);
	}

	public String getCityAndZipCodeOfUser() {
		waitForElementVisible(driver, UserAddressesPageUI.CITY_STATE_AND_ZIP_USER_UPDATED);
		return getElementText(driver, UserAddressesPageUI.CITY_STATE_AND_ZIP_USER_UPDATED);
	}

	public String getAddress1OfUser() {
		waitForElementVisible(driver, UserAddressesPageUI.ADDRESS1_USER_UPDATED);
		return getElementText(driver, UserAddressesPageUI.ADDRESS1_USER_UPDATED);
	}

	public String getAddress2OfUser() {
		waitForElementVisible(driver, UserAddressesPageUI.ADDRESS2_USER_UPDATED);
		return getElementText(driver, UserAddressesPageUI.ADDRESS2_USER_UPDATED);
	}

	public String getPhoneNumberOfUser() {
		waitForElementVisible(driver, UserAddressesPageUI.PHONE_NUMBER_USER_UPDATED);
		return getElementText(driver, UserAddressesPageUI.PHONE_NUMBER_USER_UPDATED);
	}

	public String getFaxNumberOfUser() {
		waitForElementVisible(driver, UserAddressesPageUI.FAX_NUMBER_USER_UPDATED);
		return getElementText(driver, UserAddressesPageUI.FAX_NUMBER_USER_UPDATED);
	}
}
