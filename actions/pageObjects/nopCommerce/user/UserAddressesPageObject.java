package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.AddressesPageUI;

public class UserAddressesPageObject extends BasePage {
	private WebDriver driver;

	public UserAddressesPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAddNewButton() {
		waitForClickable(driver, AddressesPageUI.ADD_NEW_ADDRESS_BUTTON);
		clickToElement(driver, AddressesPageUI.ADD_NEW_ADDRESS_BUTTON);
	}

	public void inputToFirstNameTextbox(String firstNameUpdate) {
		waitForElementVisible(driver, AddressesPageUI.FIRST_NAME_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, AddressesPageUI.FIRST_NAME_ADDRESS_TEXTBOX, firstNameUpdate);
	}

	public void inputToLastNameTextbox(String lastNameUpdate) {
		waitForElementVisible(driver, AddressesPageUI.LAST_NAME_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, AddressesPageUI.LAST_NAME_ADDRESS_TEXTBOX, lastNameUpdate);
	}

	public void inputToEmailTextbox(String emailAddressUpdate) {
		waitForElementVisible(driver, AddressesPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, AddressesPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddressUpdate);
	}

	public void inputToCompanyNameTextbox(String companyNameUpdate) {
		waitForElementVisible(driver, AddressesPageUI.COMPANY_NAME_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, AddressesPageUI.COMPANY_NAME_ADDRESS_TEXTBOX, companyNameUpdate);
	}

	public void selectCountryInDefaultDropdown(String countryName) {
		waitForElementVisible(driver, AddressesPageUI.COUNTRY_DEFAULT_DROPDOWN);
		selectItemInDefaultDropdown(driver, AddressesPageUI.COUNTRY_DEFAULT_DROPDOWN, countryName);
	}

	public void inputToCityTextbox(String cityName) {
		waitForElementVisible(driver, AddressesPageUI.CITY_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, AddressesPageUI.CITY_ADDRESS_TEXTBOX, cityName);
	}

	public void inputToAddress1Textbox(String address1) {
		waitForElementVisible(driver, AddressesPageUI.ADDRESS1_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, AddressesPageUI.ADDRESS1_ADDRESS_TEXTBOX, address1);
	}

	public void inputToAddress2Textbox(String address2) {
		waitForElementVisible(driver, AddressesPageUI.ADDRESS2_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, AddressesPageUI.ADDRESS2_ADDRESS_TEXTBOX, address2);
	}

	public void inputToZipCodeTextbox(String zipCode) {
		waitForElementVisible(driver, AddressesPageUI.ZIP_CODE_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, AddressesPageUI.ZIP_CODE_ADDRESS_TEXTBOX, zipCode);
	}

	public void inputToPhoneNumberTextbox(String phoneNumber) {
		waitForElementVisible(driver, AddressesPageUI.PHONE_NUMBER_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, AddressesPageUI.PHONE_NUMBER_ADDRESS_TEXTBOX, phoneNumber);
	}

	public void inputToFaxNumberTextbox(String faxNumber) {
		waitForElementVisible(driver, AddressesPageUI.FAX_NUMBER_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, AddressesPageUI.FAX_NUMBER_ADDRESS_TEXTBOX, faxNumber);
	}

	public void clickToSaveButton() {
		waitForClickable(driver, AddressesPageUI.SAVE_BUTTON);
		clickToElement(driver, AddressesPageUI.SAVE_BUTTON);
	}

	public String getNameOfUser() {
		waitForElementVisible(driver, AddressesPageUI.NAME_USER_UPDATED);
		return getElementText(driver, AddressesPageUI.NAME_USER_UPDATED);
	}

	public String getEmailOfUser() {
		waitForElementVisible(driver, AddressesPageUI.EMAIL_USER_UPDATED);
		return getElementText(driver, AddressesPageUI.EMAIL_USER_UPDATED);
	}

	public String getCountryOfUser() {
		waitForElementVisible(driver, AddressesPageUI.COUNTRY_USER_UPDATED);
		return getElementText(driver, AddressesPageUI.COUNTRY_USER_UPDATED);
	}

	public String getCityAndZipCodeOfUser() {
		waitForElementVisible(driver, AddressesPageUI.CITY_STATE_AND_ZIP_USER_UPDATED);
		return getElementText(driver, AddressesPageUI.CITY_STATE_AND_ZIP_USER_UPDATED);
	}

	public String getAddress1OfUser() {
		waitForElementVisible(driver, AddressesPageUI.ADDRESS1_USER_UPDATED);
		return getElementText(driver, AddressesPageUI.ADDRESS1_USER_UPDATED);
	}

	public String getAddress2OfUser() {
		waitForElementVisible(driver, AddressesPageUI.ADDRESS2_USER_UPDATED);
		return getElementText(driver, AddressesPageUI.ADDRESS2_USER_UPDATED);
	}

	public String getPhoneNumberOfUser() {
		waitForElementVisible(driver, AddressesPageUI.PHONE_NUMBER_USER_UPDATED);
		return getElementText(driver, AddressesPageUI.PHONE_NUMBER_USER_UPDATED);
	}

	public String getFaxNumberOfUser() {
		waitForElementVisible(driver, AddressesPageUI.FAX_NUMBER_USER_UPDATED);
		return getElementText(driver, AddressesPageUI.FAX_NUMBER_USER_UPDATED);
	}
}
