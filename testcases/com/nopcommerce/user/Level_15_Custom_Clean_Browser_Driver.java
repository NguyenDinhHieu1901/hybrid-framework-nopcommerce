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

public class Level_15_Custom_Clean_Browser_Driver extends BaseTest {

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
	}
	
	@Test
	public void User_01_Register() {
		log.info("User_01_Register - Step 01: Click to 'Register' link");
		registerPageObject = homePageObject.clickToRegisterLink();
		
		log.info("User_01_Register - Step 02: Input to all of mandatory fields in 'Register' form");
		registerPageObject.registerAsUser(firstName, lastName, emailAddress, password);
		
		log.info("User_01_Register - Step 03: Verify 'Register Success Message' is displayed");
		verifyEquals(registerPageObject.getRegisterSuccessMessage(), "Your registration completed");
		
		log.info("User_01_Register - Step 04: Click to 'Logout' link");
		homePageObject = registerPageObject.clickToLogoutLinkAtUser(driver);
	}

	@Test
	public void User_02_Login() {
		log.info("User_02-Login - Step 01: Click to 'Login' link");
		loginPageObject = homePageObject.clickToLoginLink();
		
		log.info("User_02-Login - Step 02: input to Email Address and Password in 'Login' form with value: " + emailAddress + " " + password);
		homePageObject = loginPageObject.loginAsUser(emailAddress, password);
		
		log.info("User_02-Login - Step 03: Verify 'My Account Link' is displayed");
		verifyTrue(homePageObject.isMyAccountLinkDisplayed());
		
		log.info("User_02-Login - Step 04: Click to 'My Account' link");
		customerInfoPageObject = homePageObject.clickToMyAccountLink();
		
		log.info("User_02-Login - Step 05: Verify 'News Letter Checkbox' is selected");
		verifyFalse(customerInfoPageObject.isNewsletterCheckboxSelected());
	}
	
	@Parameters("browser")
	@AfterClass(alwaysRun = true)
	public void afterClass(String browserName) {
		log.info("Post-condition: Clean browser '" + browserName + "'");
		closeBrowserAndDriver();
	}

	private WebDriver driver;
	private String emailAddress, password, firstName, lastName;
	private UserHomePageObject homePageObject;
	private UserRegisterPageObject registerPageObject;
	private UserLoginPageObject loginPageObject;
	private UserCustomerInfoPageObject customerInfoPageObject;
}
