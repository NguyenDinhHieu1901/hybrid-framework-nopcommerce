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

public class Level_09_Dynamic_Locator extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePageObject = PageGeneratorManager.getUserHomePage(driver);

		firstName = "nguyen";
		lastName = "test";
		emailAddress = firstName + lastName + getEmailFaker() + "@mail.net";
		password = "123456";
	}

	@Test
	public void User_01_Register_Login() {
		registerPageObject = homePageObject.clickToRegisterLink();
		registerPageObject.registerAsUser(firstName, lastName, emailAddress, password);
		Assert.assertEquals(registerPageObject.getRegisterSuccessMessage(), "Your registration completed");
		homePageObject = registerPageObject.clickToLogoutLinkAtUser(driver);
		loginPageObject = homePageObject.clickToLoginLink();
		homePageObject = loginPageObject.loginAsUser(emailAddress, password);
		Assert.assertTrue(homePageObject.isMyAccountLinkDisplayed());
		customerInfoPageObject = homePageObject.clickToMyAccountLink();
		Assert.assertTrue(customerInfoPageObject.isNewsletterCheckboxSelected());
	}
	
	@Test
	public void User_02_Switch_Page_I() {
		// Customer Info Page --> Addresses Page
		addressesPageObject = (UserAddressesPageObject) customerInfoPageObject.openPagesAtMyAccountByName(driver, "Addresses");
		
		// Addresses Page --> My product review
		myProductReviewsPageObject = (UserMyProductReviewsPageObject) addressesPageObject.openPagesAtMyAccountByName(driver, "My product reviews");
		
		// My product review --> Reward Point page
		rewardPointPageObject = (UserRewardPointPageObject) myProductReviewsPageObject.openPagesAtMyAccountByName(driver, "Reward points");
		
		// Reward Point page --> addresses page
		addressesPageObject = (UserAddressesPageObject) rewardPointPageObject.openPagesAtMyAccountByName(driver, "Addresses");
		
		// addresses page --> reward point page
		rewardPointPageObject = (UserRewardPointPageObject) addressesPageObject.openPagesAtMyAccountByName(driver, "Reward points");
		
		// reward point page --> my product reviews page
		myProductReviewsPageObject = (UserMyProductReviewsPageObject) rewardPointPageObject.openPagesAtMyAccountByName(driver, "My product reviews");
	}

	@Test
	public void User_02_Switch_Page_II() {
		// My product review --> Addresses Page
		myProductReviewsPageObject.openPagesAtMyAccountByPageName(driver, "Addresses");
		addressesPageObject = PageGeneratorManager.getUserAddressesPage(driver);
		
		// Addresses Page --> My product review
		addressesPageObject.openPagesAtMyAccountByPageName(driver, "My product reviews");
		myProductReviewsPageObject = PageGeneratorManager.getUserMyProductReviewsPage(driver);
		
		// My product review --> Reward Point page
		myProductReviewsPageObject.openPagesAtMyAccountByPageName(driver, "Reward points");
		rewardPointPageObject = PageGeneratorManager.getUserRewardPointPage(driver);
		
		// Reward Point page --> addresses page
		rewardPointPageObject.openPagesAtMyAccountByPageName(driver, "Addresses");
		addressesPageObject = PageGeneratorManager.getUserAddressesPage(driver);
		
		// addresses page --> reward point page
		addressesPageObject.openPagesAtMyAccountByPageName(driver, "Reward points");
		rewardPointPageObject = PageGeneratorManager.getUserRewardPointPage(driver);
		
		// reward point page --> my product reviews page
		rewardPointPageObject.openPagesAtMyAccountByPageName(driver, "My product reviews");
		myProductReviewsPageObject = PageGeneratorManager.getUserMyProductReviewsPage(driver);
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
