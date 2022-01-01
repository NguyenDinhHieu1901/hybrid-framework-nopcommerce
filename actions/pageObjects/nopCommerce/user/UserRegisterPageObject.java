package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {

	private WebDriver driver;

	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterButton() {
		waitForClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX, lastName);
	}

	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);

	}

	public void inputToConfirmPasswordTextbox(String password) {
		waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
	}
	
	public void registerAsUser(String firstName, String lastName, String emailAddress, String password) {
		inputToFirstNameTextbox(firstName);
		inputToLastNameTextbox(lastName);
		inputToEmailTextbox(emailAddress);
		inputToPasswordTextbox(password);
		inputToConfirmPasswordTextbox(password);
		clickToRegisterButton();
	}

	public String getErrorMessageAtFirstNameTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtLastNameTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.REGISTER_SUCCESSFUL_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.REGISTER_SUCCESSFUL_MESSAGE);
	}

	public String getErrorExistingEmailMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
	}

	public void clickToMaleRadioButton() {
		waitForClickable(driver, UserRegisterPageUI.GENDER_MALE_RADIO);
		clickToElement(driver, UserRegisterPageUI.GENDER_MALE_RADIO);
	}
	
	public void clickToFeMaleRadioButton() {
		waitForClickable(driver, UserRegisterPageUI.GENDER_FEMALE_RADIO);
		clickToElement(driver, UserRegisterPageUI.GENDER_FEMALE_RADIO);
	}

	public void selectDOBDay(String dobDay) {
		waitForElementVisible(driver, UserRegisterPageUI.DOB_DAY_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserRegisterPageUI.DOB_DAY_DROPDOWN, dobDay);
	}

	public void selectDOBMonth(String dobMonth) {
		waitForElementVisible(driver, UserRegisterPageUI.DOB_MONTH_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserRegisterPageUI.DOB_MONTH_DROPDOWN, dobMonth);
	}

	public void selectDOBYear(String dobYear) {
		waitForElementVisible(driver, UserRegisterPageUI.DOB_YEAR_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserRegisterPageUI.DOB_YEAR_DROPDOWN, dobYear);
	}

	public void inputToCompanyNameTextbox(String companyName) {
		waitForElementVisible(driver, UserRegisterPageUI.COMPANY_NAME_TEXTBOX);
	}

}
