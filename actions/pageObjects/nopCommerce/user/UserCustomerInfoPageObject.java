package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.user.UserCustomerInfoPageUI;

public class UserCustomerInfoPageObject extends BasePage {

	private WebDriver driver;

	public UserCustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToFemaleRadioButton() {
		waitForClickable(driver, UserCustomerInfoPageUI.GENDER_FEMALE_RADIO);
		clickToElement(driver, UserCustomerInfoPageUI.GENDER_FEMALE_RADIO);
	}

	public void inputToFirstNameTextbox(String firstNameUpdate) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX, firstNameUpdate);
	}

	public void inputToLastNameTextbox(String lastNameUpdate) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX, lastNameUpdate);
	}

	public void selectDOBDay(String dobDayUpdate) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.DOB_DAY_DEFAULT_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserCustomerInfoPageUI.DOB_DAY_DEFAULT_DROPDOWN, dobDayUpdate);
	}

	public void selectDOBMonth(String dobMonthUpdate) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.DOB_MONTH_DEFAULT_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserCustomerInfoPageUI.DOB_MONTH_DEFAULT_DROPDOWN, dobMonthUpdate);
	}

	public void selectDOBYear(String dobYearUpdate) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.DOB_YEAR_DEFAULT_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserCustomerInfoPageUI.DOB_YEAR_DEFAULT_DROPDOWN, dobYearUpdate);
	}

	public void inputToEmailTextbox(String emailAddressUpdate) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInfoPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddressUpdate);
	}

	public void inputToCompanyNameTextbox(String companyNameUpdate) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.COMPANY_NAME_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInfoPageUI.COMPANY_NAME_TEXTBOX, companyNameUpdate);
	}

	public void clickToSaveButton() {
		waitForClickable(driver, UserCustomerInfoPageUI.SAVE_BUTTON);
		clickToElement(driver, UserCustomerInfoPageUI.SAVE_BUTTON);
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
		return isElementSelected(driver, UserCustomerInfoPageUI.GENDER_FEMALE_RADIO);
	}

	public String getValueAttributeAtFirstNameTextbox() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX, "value");
	}

	public String getValueAttributeAtLastNameTextbox() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX, "value");
	}

	public String getFirstSelectedDayInDefaultDropdown() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.DOB_DAY_DEFAULT_DROPDOWN);
		return getFirstSelectedItemDefaultDropdown(driver, UserCustomerInfoPageUI.DOB_DAY_DEFAULT_DROPDOWN);
	}

	public String getFirstSelectedMonthInDefaultDropdown() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.DOB_MONTH_DEFAULT_DROPDOWN);
		return getFirstSelectedItemDefaultDropdown(driver, UserCustomerInfoPageUI.DOB_MONTH_DEFAULT_DROPDOWN);
	}

	public String getFirstSelectedYearInDefaultDropdown() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.DOB_YEAR_DEFAULT_DROPDOWN);
		return getFirstSelectedItemDefaultDropdown(driver, UserCustomerInfoPageUI.DOB_YEAR_DEFAULT_DROPDOWN);
	}

	public String getValueAttributeAtEmailTextbox() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.EMAIL_ADDRESS_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInfoPageUI.EMAIL_ADDRESS_TEXTBOX, "value");
	}

	public String getValueAttributeAtCompanyNameTextbox() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.COMPANY_NAME_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInfoPageUI.COMPANY_NAME_TEXTBOX, "value");
	}
	
	@Step("Verify Newsletter checkbox is selected")
	public boolean isNewsletterCheckboxSelected() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.NEWSLETTER_CHECKBOX);
		return isElementSelected(driver, UserCustomerInfoPageUI.NEWSLETTER_CHECKBOX);
	}
}
