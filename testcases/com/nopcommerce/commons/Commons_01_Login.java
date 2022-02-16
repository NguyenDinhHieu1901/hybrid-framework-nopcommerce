package com.nopcommerce.commons;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import pageObjects.nopCommerce.user.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Commons_01_Login extends BaseTest {

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		log.info("Pre-condition 01: Open Browser '" + browserName + "'");
		driver = getBrowserDriver(browserName);
		homePageObject = PageGeneratorManager.getUserHomePage(driver);

		firstName = "nguyen";
		lastName = "test";
		emailAddress = firstName + lastName + generatorNumberRandom() + "@mail.net";
		password = "123456";

		log.info("Pre-condition 02: Click to 'Register' link");
		registerPageObject = homePageObject.clickToRegisterLink();

		log.info("Pre-condition 03: Input to all of mandatory fields in 'Register' form");
		registerPageObject.registerAsUser(firstName, lastName, emailAddress, password);

		log.info("Pre-condition 04: Verify 'Register Success Message' is displayed");
		verifyEquals(registerPageObject.getRegisterSuccessMessage(), "Your registration completed");

		log.info("Pre-condition 05: Click to 'Logout' link");
		homePageObject = registerPageObject.clickToLogoutLinkAtUser(driver);

		log.info("Pre-condition 06: Click to 'Login' link");
		loginPageObject = homePageObject.clickToLoginLink();

		log.info("Pre-condition 07: Input to Email Address and Password in 'Login' form with value: " + emailAddress + " " + password);
		homePageObject = loginPageObject.loginAsUser(emailAddress, password);

		log.info("Pre-condition 08: Get all cookies and inject cookies to other classes");
		cookiesLoginPage = homePageObject.getAllCookies(driver);

		log.info("Pre-condition 09: Clean browser '" + browserName + "'");
		closeBrowserAndDriver();
	}

	private WebDriver driver;
	private String emailAddress, password, firstName, lastName;
	private UserHomePageObject homePageObject;
	private UserRegisterPageObject registerPageObject;
	private UserLoginPageObject loginPageObject;
	public static Set<Cookie> cookiesLoginPage;
}