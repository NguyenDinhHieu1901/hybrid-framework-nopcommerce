package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Level_06_Generate_Page_Manager_Login_I extends BaseTest {
	private WebDriver driver;
	private String emailExisting, emailInvalid, emailNotFound, password, firstName, lastName;
	private HomePageObject homePageObject;
	private RegisterPageObject registerPageObject;
	private LoginPageObject loginPageObject;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		
		driver = getBrowserDriver(browserName);
		
		// Initial object: 1
		homePageObject = new HomePageObject(driver);

		firstName = "nguyen";
		lastName = "test";
		emailExisting = firstName + lastName + getEmailFaker() + "@mail.net";
		emailNotFound = firstName + lastName + getEmailFaker() + "@mail.com";
		emailInvalid = "123@gmail.com#@.vn";
		password = "123456";

		System.out.println("Pre-condition - step 1: Click to register link");
		homePageObject.clickToRegisterLink();

		System.out.println("Pre-condition - step 2: Input to all required fields");
		// Initial object: 2
		registerPageObject = new RegisterPageObject(driver);
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
		registerPageObject.clickToLogoutLink();
	}

	@Test
	public void Login_01_Empty_Data() {

		System.out.println("Login_01 - step 1: click to login link");
		// Initial object: 3
		homePageObject = new HomePageObject(driver);
		homePageObject.clickToLoginLink();

		System.out.println("Login_01 - step 2: click to login button");
		// Initial object: 4
		loginPageObject = new LoginPageObject(driver);
		loginPageObject.clickToLoginButton();

		System.out.println("Login_01 - step 3: verify error message at email field");
		Assert.assertEquals(loginPageObject.getErrorMessageAtEmailTextbox(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email() {

		System.out.println("Login_02 - step 1: click to login link");
		homePageObject.clickToLoginLink();

		System.out.println("Login_02 - step 2: input to email field");
		// Initial object: 5
		loginPageObject = new LoginPageObject(driver);
		loginPageObject.inputToEmailTextbox(emailInvalid);

		System.out.println("Login_02 - step 3: click to login button");
		loginPageObject.clickToLoginButton();

		System.out.println("Login_02 - step 4: verify error message at email field");
		Assert.assertEquals(loginPageObject.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void Login_03_Email_Not_Found() {

		System.out.println("Login_03 - step 1: click to login link");
		homePageObject.clickToLoginLink();

		System.out.println("Login_03 - step 2: input to email field");
		// Initial object: 6
		loginPageObject = new LoginPageObject(driver);
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
		homePageObject.clickToLoginLink();

		System.out.println("Login_04 - step 2: input to email field");
		// Initial object: 7
		loginPageObject = new LoginPageObject(driver);
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
		homePageObject.clickToLoginLink();

		System.out.println("Login_05 - step 2: input to email field");
		// Initial object: 8
		loginPageObject = new LoginPageObject(driver);
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
		homePageObject.clickToLoginLink();

		System.out.println("Login_06 - step 2: input to email field");
		// Initial object: 9
		loginPageObject = new LoginPageObject(driver);
		loginPageObject.inputToEmailTextbox(emailExisting);
		loginPageObject.inputToPasswordTextbox(password);

		System.out.println("Login_06 - step 3: click to login button");
		loginPageObject.clickToLoginButton();

		System.out.println("Login_06 - step 4: verify my account link displayed");
		// Initial object: 10
		homePageObject = new HomePageObject(driver);
		Assert.assertTrue(homePageObject.isMyAccountLinkDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
