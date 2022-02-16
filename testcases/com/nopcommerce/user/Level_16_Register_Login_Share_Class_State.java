package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.commons.Commons_01_Login;

import commons.BaseTest;
import pageObjects.nopCommerce.user.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;

public class Level_16_Register_Login_Share_Class_State extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		log.info("Pre-condition: Open Browser '" + browserName + "'");
		driver = getBrowserDriver(browserName);
		homePageObject = PageGeneratorManager.getUserHomePage(driver);
	}

	@Test
	public void User_01_Login() {
		log.info("User_01_Login - Step 01: Click to 'Login' link");
		loginPageObject = homePageObject.clickToLoginLink();

		log.info("User_01_Login - Step 02: input to Email Address and Password in 'Login' form");
		loginPageObject.setAllCookies(driver, Commons_01_Login.cookiesLoginPage);
		loginPageObject.sleepInSecond(3);
		loginPageObject.refreshCurrentPage(driver);
		homePageObject = loginPageObject.clickToNopCommerceImage();

		log.info("User_01_Login - Step 03: Verify 'My Account Link' is displayed");
		verifyTrue(homePageObject.isMyAccountLinkDisplayed());

		log.info("User_01_Login - Step 04: Click to 'My Account' link");
		customerInfoPageObject = homePageObject.clickToMyAccountLink();

		log.info("User_01_Login - Step 05: Verify 'News Letter Checkbox' is selected");
		verifyTrue(customerInfoPageObject.isNewsletterCheckboxSelected());
	}

	@Parameters("browser")
	@AfterClass(alwaysRun = true)
	public void afterClass(String browserName) {
		log.info("Post-condition: Clean browser '" + browserName + "'");
		closeBrowserAndDriver();
	}

	private WebDriver driver;
	private UserHomePageObject homePageObject;
	private UserLoginPageObject loginPageObject;
	private UserCustomerInfoPageObject customerInfoPageObject;
}
