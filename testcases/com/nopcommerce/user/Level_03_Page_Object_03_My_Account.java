package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.nopCommerce.user.UserAddressesPageObject;
import pageObjects.nopCommerce.user.UserChangePasswordPageObject;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserDesktopsPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyAccountPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewsPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_03_Page_Object_03_My_Account {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");

	private String emailAddress, password, firstName, lastName, companyName, dobDay, dobMonth, dobYear;
	private String emailAddressUpdate, firstNameUpdate, lastNameUpdate, companyNameUpdate, dobDayUpdate, dobMonthUpdate, dobYearUpdate;
	private String countryName, cityName, address1, address2, zipCode, phoneNumber, faxNumber, newPassword;

	private UserHomePageObject homePageObject;
	private UserRegisterPageObject registerPageObject;
	private UserLoginPageObject loginPageObject;
	private UserMyAccountPageObject myAccountPageObject;
	private UserAddressesPageObject addressesPageObject;
	private UserCustomerInfoPageObject customerInfoPageObject;
	private UserChangePasswordPageObject changePasswordPageObject;
	private UserDesktopsPageObject desktopsPageObject;
	private UserMyProductReviewsPageObject myProductReviewsPageObject;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://demo.nopcommerce.com/");

		homePageObject = new UserHomePageObject(driver);

		firstName = "nguyen";
		lastName = "test";
		emailAddress = firstName + lastName + generateFakerEmail() + "@gmail.net";
		password = "123456";
		companyName = firstName + lastName;
		dobDay = "19";
		dobMonth = "December";
		dobYear = "2000";

		firstNameUpdate = "El";
		lastNameUpdate = "Nino";
		emailAddressUpdate = firstName + lastName + generateFakerEmail() + "@gmail.net";
		companyNameUpdate = firstNameUpdate + lastNameUpdate;
		dobDayUpdate = "18";
		dobMonthUpdate = "May";
		dobYearUpdate = "1999";

		countryName = "Viet Nam";
		cityName = "Ho Chi Minh";
		address1 = "1 Nguyen Trai";
		address2 = "1 Nam Ky Khoi Nghia";
		zipCode = "888888";
		phoneNumber = "0909888888";
		faxNumber = "0909888888";
		newPassword = "123456789";

		System.out.println("Pre-condition - step 1: Click to register link");
		homePageObject.clickToRegisterLink();

		System.out.println("Pre-condition - step 2: input all required fields");
		registerPageObject = new UserRegisterPageObject(driver);
		registerPageObject.clickToMaleRadioButton();
		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.selectDOBDay(dobDay);
		registerPageObject.selectDOBMonth(dobMonth);
		registerPageObject.selectDOBYear(dobYear);
		registerPageObject.inputToEmailTextbox(emailAddress);
		registerPageObject.inputToCompanyNameTextbox(companyName);
		registerPageObject.inputToPasswordTextbox(password);
		registerPageObject.inputToConfirmPasswordTextbox(password);

		System.out.println("Pre-condition - step 3: Click to register button");
		registerPageObject.clickToRegisterButton();

		System.out.println("Pre-condition - step 4: verify register success message");
		Assert.assertEquals(registerPageObject.getRegisterSuccessMessage(), "Your registration completed");

		System.out.println("Pre-condition - step 5: Click to logout link");
		registerPageObject.clickToLogoutLinkAtUser(driver);
		
		System.out.println("Pre-condition - step 6: click to log in link");
		homePageObject = new UserHomePageObject(driver);
		homePageObject.clickToLoginLink();

		System.out.println("Pre-condition - step 7: input to email and password fields");
		loginPageObject = new UserLoginPageObject(driver);
		loginPageObject.inputToEmailTextbox(emailAddress);
		loginPageObject.inputToPasswordTextbox(password);
		loginPageObject.clickToLoginButton();
	}

	@Test
	public void My_Account_01_Customer_Info() {
		System.out.println("My_Account_01 - step 1: click to my account link");
		homePageObject = new UserHomePageObject(driver);
		homePageObject.clickToMyAccountLink();

		System.out.println("My_Account_01 - step 2: update all of required fields ");
		customerInfoPageObject = new UserCustomerInfoPageObject(driver);
		customerInfoPageObject.clickToFemaleRadioButton();
		customerInfoPageObject.inputToFirstNameTextbox(firstNameUpdate);
		customerInfoPageObject.inputToLastNameTextbox(lastNameUpdate);
		customerInfoPageObject.selectDOBDay(dobDayUpdate);
		customerInfoPageObject.selectDOBMonth(dobMonthUpdate);
		customerInfoPageObject.selectDOBYear(dobYearUpdate);
		customerInfoPageObject.inputToEmailTextbox(emailAddressUpdate);
		customerInfoPageObject.inputToCompanyNameTextbox(companyNameUpdate);

		System.out.println("My_Account_01 - step 3: click to save button");
		customerInfoPageObject.clickToSaveButton();

		System.out.println("My_Account_01 - step 4: verify all of fields updated");
		Assert.assertTrue(customerInfoPageObject.isFemaleRadioButtonSelected());
		Assert.assertEquals(customerInfoPageObject.getValueAttributeAtFirstNameTextbox(), firstNameUpdate);
		Assert.assertEquals(customerInfoPageObject.getValueAttributeAtLastNameTextbox(), lastNameUpdate);
		Assert.assertEquals(customerInfoPageObject.getFirstSelectedDayInDefaultDropdown(), dobDayUpdate);
		Assert.assertEquals(customerInfoPageObject.getFirstSelectedMonthInDefaultDropdown(), dobMonthUpdate);
		Assert.assertEquals(customerInfoPageObject.getFirstSelectedYearInDefaultDropdown(), dobYearUpdate);
		Assert.assertEquals(customerInfoPageObject.getValueAttributeAtEmailTextbox(), emailAddressUpdate);
		Assert.assertEquals(customerInfoPageObject.getValueAttributeAtCompanyNameTextbox(), companyNameUpdate);
	}

	@Test
	public void My_Account_02_Addresses() {
		System.out.println("My_Account_02 - step 1: click to addresses link");
		myAccountPageObject = new UserMyAccountPageObject(driver);
		myAccountPageObject.clickToAddressesLink();

		System.out.println("My_Account_02 - step 2: click to add new button");
		addressesPageObject = new UserAddressesPageObject(driver);
		addressesPageObject.clickToAddNewButton();

		System.out.println("My_Account_02 - step 3: input to all of required fields");
		addressesPageObject.inputToFirstNameTextbox(firstNameUpdate);
		addressesPageObject.inputToLastNameTextbox(lastNameUpdate);
		addressesPageObject.inputToEmailTextbox(emailAddressUpdate);
		addressesPageObject.inputToCompanyNameTextbox(companyNameUpdate);
		addressesPageObject.selectCountryInDefaultDropdown(countryName);
		addressesPageObject.inputToCityTextbox(cityName);
		addressesPageObject.inputToAddress1Textbox(address1);
		addressesPageObject.inputToAddress2Textbox(address2);
		addressesPageObject.inputToZipCodeTextbox(zipCode);
		addressesPageObject.inputToPhoneNumberTextbox(phoneNumber);
		addressesPageObject.inputToFaxNumberTextbox(faxNumber);

		System.out.println("My_Account_02 - step 4: click to save button");
		addressesPageObject.clickToSaveButton();

		System.out.println("My_Account_02 - step 5: verify all of informations of address");
		sleepInSecond(1);
		Assert.assertEquals(addressesPageObject.getNameOfUser(), firstNameUpdate + " " + lastNameUpdate);
		Assert.assertTrue(addressesPageObject.getEmailOfUser().contains(emailAddressUpdate));
		Assert.assertTrue(addressesPageObject.getPhoneNumberOfUser().contains(phoneNumber));
		Assert.assertTrue(addressesPageObject.getFaxNumberOfUser().contains(faxNumber));
		Assert.assertEquals(addressesPageObject.getAddress1OfUser(), address1);
		Assert.assertEquals(addressesPageObject.getAddress2OfUser(), address2);
		Assert.assertEquals(addressesPageObject.getCityAndZipCodeOfUser(), cityName + ", " + zipCode);
		Assert.assertEquals(addressesPageObject.getCountryOfUser(), countryName);
	}

	@Test
	public void My_Account_03_Change_Password() {
		System.out.println("My_Account_03 - step 1: click to change password link");
		myAccountPageObject = new UserMyAccountPageObject(driver);
		myAccountPageObject.clickToChangePasswordLink();

		System.out.println("My_Account_03 - step 2: change password");
		changePasswordPageObject = new UserChangePasswordPageObject(driver);
		changePasswordPageObject.inputToOldPasswordTextbox(password);
		changePasswordPageObject.inputToNewPasswordTextbox(newPassword);
		changePasswordPageObject.inputToConfirmNewPasswordTextbox(newPassword);

		System.out.println("My_Account_03 - step 3: click to change password button");
		changePasswordPageObject.clickToChangePasswordButton();

		System.out.println("My_Account_03 - step 4: verify change password success message");
		Assert.assertEquals(changePasswordPageObject.getChangePasswordSuccessMessage(), "Password was changed");

		System.out.println("My_Account_03 - step 5: close change password success message");
		changePasswordPageObject.clickToCloseChangePasswordSuccessMessage();

		sleepInSecond(2);

		System.out.println("My_Account_03 - step 6: click to logout link");
		myAccountPageObject.clickToLogoutLinkAtUser(driver);

		System.out.println("My_Account_03 - step 7: click to login link");
		homePageObject = new UserHomePageObject(driver);
		homePageObject.clickToLoginLink();

		System.out.println("My_Account_03 - step 8: input to email and password fields with old password");
		loginPageObject = new UserLoginPageObject(driver);
		loginPageObject.inputToEmailTextbox(emailAddressUpdate);
		loginPageObject.inputToPasswordTextbox(password);
		loginPageObject.clickToLoginButton();

		System.out.println("My_Account_03 - step 9: verify error password message displayed");
		Assert.assertEquals(loginPageObject.getErrorMessageUnsuccessfully(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

		System.out.println("My_Account_03 - step 10: input to email and password fields with new password");
		loginPageObject.inputToEmailTextbox(emailAddressUpdate);
		loginPageObject.inputToPasswordTextbox(newPassword);
		loginPageObject.clickToLoginButton();

		System.out.println("My_Account_03 - step 11: verify login success and navigate to homepage");
		Assert.assertEquals(homePageObject.getTitleHomePage(), "nopCommerce demo store");
	}

	@Test
	public void My_Account_04_My_Product_Review() {
		System.out.println("My_Account_04 - step 1: hover to Computers menu");
		homePageObject = new UserHomePageObject(driver);
		homePageObject.hoverToComputersMenu();

		System.out.println("My_Account_04 - step 2: Click to Desktops");
		homePageObject.clickToSubmenuDesktopsLink();

		System.out.println("My_Account_04 - step 3: Click to build your own computer link");
		desktopsPageObject = new UserDesktopsPageObject(driver);
		desktopsPageObject.clickToBuildYourOwnComputerLink();

		System.out.println("My_Account_04 - step 4: Click to add your review link");
		desktopsPageObject.clickToAddYourReviewLink();

		System.out.println("My_Account_04 - step 5: input to review title textbox");
		desktopsPageObject.inputToReviewTitleTextbox("Review's " + emailAddressUpdate);

		System.out.println("My_Account_04 - step 6: input to review text textarea");
		desktopsPageObject.inputToReviewTextTextarea("Excellent product\nI recommend everyone buy it.");

		System.out.println("My_Account_04 - step 7: click to submit review button");
		desktopsPageObject.clickToSubmitReviewButton();

		System.out.println("My_Account_04 - step 8: click to my account link");
		homePageObject = new UserHomePageObject(driver);
		homePageObject.clickToMyAccountLink();

		System.out.println("My_Account_04 - step 9: click to my product reviews link");
		myAccountPageObject = new UserMyAccountPageObject(driver);
		myAccountPageObject.clickToMyProductReviewsLink();

		System.out.println("My_Account_04 - step 10: verify reviews added successfully");
		myProductReviewsPageObject = new UserMyProductReviewsPageObject(driver);
		Assert.assertEquals(myProductReviewsPageObject.getTitleReviewText(), "Review's " + emailAddressUpdate);
		Assert.assertEquals(myProductReviewsPageObject.getContentReviewText(), "Excellent product\nI recommend everyone buy it.");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateFakerEmail() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
