package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.CustomerInfoPageUI;

public class UserCustomerInfoPageObject extends BasePage {

	private WebDriver driver;

	public UserCustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToFemaleRadioButton() {
		waitForClickable(driver, CustomerInfoPageUI.GENDER_FEMALE_RADIO);
		clickToElement(driver, CustomerInfoPageUI.GENDER_FEMALE_RADIO);
	}

	public void inputToFirstNameTextbox(String firstNameUpdate) {
		waitForElementVisible(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX, firstNameUpdate);
	}

	public void inputToLastNameTextbox(String lastNameUpdate) {
		waitForElementVisible(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX, lastNameUpdate);
	}

	public void selectDOBDay(String dobDayUpdate) {
		waitForElementVisible(driver, CustomerInfoPageUI.DOB_DAY_DEFAULT_DROPDOWN);
		selectItemInDefaultDropdown(driver, CustomerInfoPageUI.DOB_DAY_DEFAULT_DROPDOWN, dobDayUpdate);
	}

	public void selectDOBMonth(String dobMonthUpdate) {
		waitForElementVisible(driver, CustomerInfoPageUI.DOB_MONTH_DEFAULT_DROPDOWN);
		selectItemInDefaultDropdown(driver, CustomerInfoPageUI.DOB_MONTH_DEFAULT_DROPDOWN, dobMonthUpdate);
	}

	public void selectDOBYear(String dobYearUpdate) {
		waitForElementVisible(driver, CustomerInfoPageUI.DOB_YEAR_DEFAULT_DROPDOWN);
		selectItemInDefaultDropdown(driver, CustomerInfoPageUI.DOB_YEAR_DEFAULT_DROPDOWN, dobYearUpdate);
	}

	public void inputToEmailTextbox(String emailAddressUpdate) {
		waitForElementVisible(driver, CustomerInfoPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddressUpdate);
	}

	public void inputToCompanyNameTextbox(String companyNameUpdate) {
		waitForElementVisible(driver, CustomerInfoPageUI.COMPANY_NAME_TEXTBOX);
		sendkeyToElement(driver, CustomerInfoPageUI.COMPANY_NAME_TEXTBOX, companyNameUpdate);
	}

	public void clickToSaveButton() {
		waitForClickable(driver, CustomerInfoPageUI.SAVE_BUTTON);
		clickToElement(driver, CustomerInfoPageUI.SAVE_BUTTON);
	}

	public void updateCustomerInfomationOfUser(String firstNameUpdate, String lastNameUpdate, String dobDayUpdate, String dobMonthUpdate, String dobYearUpdate, String emailAddressUpdate, String companyNameUpdate) {
		clickToFemaleRadioButton();
		inputToFirstNameTextbox(firstNameUpdate);
		inputToLastNameTextbox(lastNameUpdate);
		selectDOBDay(dobDayUpdate);
		selectDOBMonth(dobMonthUpdate);
		selectDOBYear(dobYearUpdate);
		inputToEmailTextbox(emailAddressUpdate);
		inputToCompanyNameTextbox(companyNameUpdate);
		clickToSaveButton();
	}

	public boolean isFemaleRadioButtonSelected() {
		return isElementSelected(driver, CustomerInfoPageUI.GENDER_FEMALE_RADIO);
	}

	public String getValueAttributeAtFirstNameTextbox() {
		waitForElementVisible(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX);
		return getElementAttribute(driver, CustomerInfoPageUI.FIRST_NAME_TEXTBOX, "value");
	}

	public String getValueAttributeAtLastNameTextbox() {
		waitForElementVisible(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX);
		return getElementAttribute(driver, CustomerInfoPageUI.LAST_NAME_TEXTBOX, "value");
	}

	public String getFirstSelectedDayInDefaultDropdown() {
		waitForElementVisible(driver, CustomerInfoPageUI.DOB_DAY_DEFAULT_DROPDOWN);
		return getFirstSelectedItemDefaultDropdown(driver, CustomerInfoPageUI.DOB_DAY_DEFAULT_DROPDOWN);
	}

	public String getFirstSelectedMonthInDefaultDropdown() {
		waitForElementVisible(driver, CustomerInfoPageUI.DOB_MONTH_DEFAULT_DROPDOWN);
		return getFirstSelectedItemDefaultDropdown(driver, CustomerInfoPageUI.DOB_MONTH_DEFAULT_DROPDOWN);
	}

	public String getFirstSelectedYearInDefaultDropdown() {
		waitForElementVisible(driver, CustomerInfoPageUI.DOB_YEAR_DEFAULT_DROPDOWN);
		return getFirstSelectedItemDefaultDropdown(driver, CustomerInfoPageUI.DOB_YEAR_DEFAULT_DROPDOWN);
	}

	public String getValueAttributeAtEmailTextbox() {
		waitForElementVisible(driver, CustomerInfoPageUI.EMAIL_ADDRESS_TEXTBOX);
		return getElementAttribute(driver, CustomerInfoPageUI.EMAIL_ADDRESS_TEXTBOX, "value");
	}

	public String getValueAttributeAtCompanyNameTextbox() {
		waitForElementVisible(driver, CustomerInfoPageUI.COMPANY_NAME_TEXTBOX);
		return getElementAttribute(driver, CustomerInfoPageUI.COMPANY_NAME_TEXTBOX, "value");
	}

	public boolean isNewsletterCheckboxSelected() {
		waitForElementVisible(driver, CustomerInfoPageUI.NEWSLETTER_CHECKBOX);
		return isElementSelected(driver, CustomerInfoPageUI.NEWSLETTER_CHECKBOX);
	}
}
