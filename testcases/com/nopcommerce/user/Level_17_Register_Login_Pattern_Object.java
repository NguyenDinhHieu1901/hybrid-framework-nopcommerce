package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.user.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_17_Register_Login_Pattern_Object extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		log.info("Pre-condition: Open Browser '" + browserName + "'");
		driver = getBrowserDriver(browserName);
		homePageObject = PageGeneratorManager.getUserHomePage(driver);

		firstName = "nguyen";
		lastName = "test";
		emailAddress = firstName + lastName + generatorNumberRandom() + "@mail.net";
		password = "123456";
		date = "16";
		month = "February";
		year = "2022";
	}

	@Test
	public void User_01_Register() {
		log.info("User_01_Register - Step 01: Click to 'Register' link");
		homePageObject.openHeaderPageByText(driver, "Register");
		registerPageObject = PageGeneratorManager.getUserRegisterPage(driver);

		log.info("User_01_Register - Step 02: Click to Male radio button");
		registerPageObject.clickToRadioButtonByText(driver, "Male");

		log.info("User_01_Register - Step 03: Input to First name textbox with value: " + firstName);
		registerPageObject.sendkeyToTextboxByID(driver, "FirstName", firstName);

		log.info("User_01_Register - Step 04: Input to Last name textbox with value: " + lastName);
		registerPageObject.sendkeyToTextboxByID(driver, "LastName", lastName);
		
		log.info("User_01_Register - Step 05: select Date in Dropdown list with value: " + date);
		registerPageObject.selectItemInDropdownByName(driver, "DateOfBirthDay", date);
		
		log.info("User_01_Register - Step 06: select Month in Dropdown list with value: " + month);
		registerPageObject.selectItemInDropdownByName(driver, "DateOfBirthMonth", month);

		log.info("User_01_Register - Step 07: select Year in Dropdown list with value: " + year);
		registerPageObject.selectItemInDropdownByName(driver, "DateOfBirthYear", year);

		log.info("User_01_Register - Step 08: Input to Email textbox with value: " + emailAddress);
		registerPageObject.sendkeyToTextboxByID(driver, "Email", emailAddress);

		log.info("User_01_Register - Step 09: Input to Password textbox with value: " + password);
		registerPageObject.sendkeyToTextboxByID(driver, "Password", password);

		log.info("User_01_Register - Step 10: Input to Confirm Password textbox with value: " + password);
		registerPageObject.sendkeyToTextboxByID(driver, "ConfirmPassword", password);
		
		log.info("User_01_Register - Step 11: Click to Register button");
		registerPageObject.clickToButtonByText(driver, "Register");

		log.info("User_01_Register - Step 12: Verify 'Register Success Message' is displayed");
		verifyEquals(registerPageObject.getRegisterSuccessMessage(), "Your registration completed");

		log.info("User_01_Register - Step 13: Click to 'Logout' link");
		registerPageObject.openHeaderPageByText(driver, "Log out");
		homePageObject = PageGeneratorManager.getUserHomePage(driver);
	}

	@Test
	public void User_02_Login() {
		log.info("User_02_Login - Step 01: Click to 'Login' link");
		homePageObject.openHeaderPageByText(driver, "Log in");
		loginPageObject = PageGeneratorManager.getUserLoginPage(driver);

		log.info("User_02_Login - Step 02: Input to Email Address textbox with value: " + emailAddress);
		loginPageObject.sendkeyToTextboxByID(driver, "Email", emailAddress);

		log.info("User_02_Login - Step 03: Input to Password textbox with value: " + password);
		loginPageObject.sendkeyToTextboxByID(driver, "Password", password);

		log.info("User_02_Login - Step 04: Click to Login button");
		loginPageObject.clickToButtonByText(driver, "Log in");
		homePageObject = PageGeneratorManager.getUserHomePage(driver);

		log.info("User_02_Login - Step 05: Verify 'My Account Link' is displayed");
		verifyTrue(homePageObject.isMyAccountLinkDisplayed());

		log.info("User_02_Login - Step 06: Click to 'My Account' link");
		homePageObject.openHeaderPageByText(driver, "My account");
		customerInfoPageObject = PageGeneratorManager.getUserCustomerInfoPage(driver);

		log.info("User_02_Login - Step 07: Verify 'News Letter Checkbox' is selected");
		verifyTrue(customerInfoPageObject.isNewsletterCheckboxSelected());
	}

	@Parameters("browser")
	@AfterClass(alwaysRun = true)
	public void afterClass(String browserName) {
		log.info("Post-condition: Clean browser '" + browserName + "'");
		closeBrowserAndDriver();
	}

	private WebDriver driver;
	private String emailAddress, password, firstName, lastName, date, month, year;
	private UserHomePageObject homePageObject;
	private UserRegisterPageObject registerPageObject;
	private UserLoginPageObject loginPageObject;
	private UserCustomerInfoPageObject customerInfoPageObject;
}
