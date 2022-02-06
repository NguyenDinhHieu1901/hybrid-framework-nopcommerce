package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_06_Page_Generate_Manager_Login_III extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);

		// homePageObject = new HomePageObject(driver);
		homePageObject = PageGeneratorManager.getUserHomePage(driver);

		firstName = "nguyen";
		lastName = "test";
		emailExisting = firstName + lastName + generatorNumberRandom() + "@mail.net";
		emailNotFound = firstName + lastName + generatorNumberRandom() + "@mail.com";
		emailInvalid = "123@gmail.com#@.vn";
		password = "123456";

		System.out.println("Pre-condition - step 1: Click to register link");
		// we put initial a new object into changing page action when have an event changing page
		registerPageObject = homePageObject.clickToRegisterLink();

		System.out.println("Pre-condition - step 2: Input to all required fields");
		// registerPageObject = new RegisterPageObject(driver);

		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailTextbox(emailExisting);
		registerPageObject.inputToPasswordTextbox(password);
		registerPageObject.inputToConfirmPasswordTextbox(password);

		System.out.println("Pre-condition - step 3: Click to register button");
		registerPageObject.clickToRegisterButton();

		System.out.println("Pre-condition - step 4: Verify error message displayed");
		Assert.assertEquals(registerPageObject.getRegisterSuccessMessage(), "Your registration completed");

		System.out.println("Pre-condition - step 5: Click to logout link");
		homePageObject = registerPageObject.clickToLogoutLinkAtUser(driver);
	}

	@Test
	public void Login_01_Empty_Data() {

		System.out.println("Login_01 - step 1: click to login link");
		// homePageObject = new HomePageObject(driver);
		loginPageObject = homePageObject.clickToLoginLink();

		System.out.println("Login_01 - step 2: click to login button");
		// loginPageObject = new LoginPageObject(driver);
		loginPageObject.clickToLoginButton();

		System.out.println("Login_01 - step 3: verify error message at email field");
		Assert.assertEquals(loginPageObject.getErrorMessageAtEmailTextbox(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email() {

		System.out.println("Login_02 - step 1: click to login link");
		loginPageObject = homePageObject.clickToLoginLink();

		System.out.println("Login_02 - step 2: input to email field");
		loginPageObject.inputToEmailTextbox(emailInvalid);

		System.out.println("Login_02 - step 3: click to login button");
		loginPageObject.clickToLoginButton();

		System.out.println("Login_02 - step 4: verify error message at email field");
		Assert.assertEquals(loginPageObject.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void Login_03_Email_Not_Found() {

		System.out.println("Login_03 - step 1: click to login link");
		// Initial object: 7
		loginPageObject = homePageObject.clickToLoginLink();

		System.out.println("Login_03 - step 2: input to email field");
		loginPageObject.inputToEmailTextbox(emailNotFound);
		loginPageObject.inputToPasswordTextbox(password);

		System.out.println("Login_03 - step 3: click to login button");
		loginPageObject.clickToLoginButton();

		System.out.println("Login_04 - step 4: verify unsuccessful message displayed");
		Assert.assertEquals(loginPageObject.getErrorMessageUnsuccessfully(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_04_Existing_Email_Empty_Password() {

		System.out.println("Login_04 - step 1: click to login link");
		loginPageObject = homePageObject.clickToLoginLink();

		System.out.println("Login_04 - step 2: input to email field");
		loginPageObject.inputToEmailTextbox(emailExisting);
		loginPageObject.inputToPasswordTextbox("");

		System.out.println("Login_04 - step 3: click to login button");
		loginPageObject.clickToLoginButton();

		System.out.println("Login_04 - step 4: verify unsuccessful message displayed");
		Assert.assertEquals(loginPageObject.getErrorMessageUnsuccessfully(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_05_Existing_Email_Incorrect_Password() {

		System.out.println("Login_05 - step 1: click to login link");
		loginPageObject = homePageObject.clickToLoginLink();

		System.out.println("Login_05 - step 2: input to email field");
		loginPageObject.inputToEmailTextbox(emailExisting);
		loginPageObject.inputToPasswordTextbox("123456789");

		System.out.println("Login_05 - step 3: click to login button");
		loginPageObject.clickToLoginButton();

		System.out.println("Login_05 - step 4: verify unsuccessful message displayed");
		Assert.assertEquals(loginPageObject.getErrorMessageUnsuccessfully(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_06_Valid_Email_Password() {

		System.out.println("Login_06 - step 1: click to login link");
		loginPageObject = homePageObject.clickToLoginLink();

		System.out.println("Login_06 - step 2: input to email field");
		loginPageObject.inputToEmailTextbox(emailExisting);
		loginPageObject.inputToPasswordTextbox(password);

		System.out.println("Login_06 - step 3: click to login button");
		homePageObject = loginPageObject.clickToLoginButton();

		System.out.println("Login_06 - step 4: verify my account link displayed");
		Assert.assertTrue(homePageObject.isMyAccountLinkDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private String emailExisting, emailInvalid, emailNotFound, password, firstName, lastName;
	private UserHomePageObject homePageObject;
	private UserRegisterPageObject registerPageObject;
	private UserLoginPageObject loginPageObject;
}
