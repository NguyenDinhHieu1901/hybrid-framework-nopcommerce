package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.user.UserAddressesPageObject;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewsPageObject;
import pageObjects.nopCommerce.user.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

public class Level_07_Switch_Page extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		// homePageObject = new HomePageObject(driver);
		homePageObject = PageGeneratorManager.getUserHomePage(driver);

		firstName = "nguyen";
		lastName = "test";
		emailAddress = firstName + lastName + generatorNumberRandom() + "@mail.net";
		password = "123456";
	}

	@Test
	public void User_01_Register() {
		registerPageObject = homePageObject.clickToRegisterLink();
		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailTextbox(emailAddress);
		registerPageObject.inputToPasswordTextbox(password);
		registerPageObject.inputToConfirmPasswordTextbox(password);
		registerPageObject.clickToRegisterButton();
		Assert.assertEquals(registerPageObject.getRegisterSuccessMessage(), "Your registration completed");
		homePageObject = registerPageObject.clickToLogoutLinkAtUser(driver);
	}

	@Test
	public void User_02_Login() {
		loginPageObject = homePageObject.clickToLoginLink();
		loginPageObject.inputToEmailTextbox(emailAddress);
		loginPageObject.inputToPasswordTextbox(password);
		homePageObject = loginPageObject.clickToLoginButton();
		Assert.assertTrue(homePageObject.isMyAccountLinkDisplayed());
	}

	@Test
	public void User_03_My_Account() {
		customerInfoPageObject = homePageObject.clickToMyAccountLink();
		Assert.assertTrue(customerInfoPageObject.isNewsletterCheckboxSelected());
	}

	@Test
	public void User_04_Switch_Page() {
		// Customer Info Page --> Addresses Page
		addressesPageObject = customerInfoPageObject.openAddressesPage(driver);
		
		// Addresses Page --> My product review
		myProductReviewsPageObject = addressesPageObject.openMyProductReviewsPage(driver);
		
		// My product review --> Reward Point page
		rewardPointPageObject = myProductReviewsPageObject.openRewardPointPage(driver);
		
		// Reward Point page --> addresses page
		addressesPageObject = rewardPointPageObject.openAddressesPage(driver);
		
		// addresses page --> reward point page
		rewardPointPageObject = addressesPageObject.openRewardPointPage(driver);
		
		// reward point page --> my product reviews page
		myProductReviewsPageObject = rewardPointPageObject.openMyProductReviewsPage(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private String emailAddress, password, firstName, lastName;
	private UserHomePageObject homePageObject;
	private UserRegisterPageObject registerPageObject;
	private UserLoginPageObject loginPageObject;
	private UserCustomerInfoPageObject customerInfoPageObject;
	private UserAddressesPageObject addressesPageObject;
	private UserRewardPointPageObject rewardPointPageObject;
	private UserMyProductReviewsPageObject myProductReviewsPageObject;
}
