package com.liveguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.liveGuru.HomePageObject;
import pageObjects.liveGuru.LoginPageObject;
import pageObjects.liveGuru.MyDashboardPageObject;
import pageObjects.liveGuru.PageGeneratorManager;
import pageObjects.liveGuru.RegisterPageObject;

public class Level_06_Page_Generator_Manager_01_Register extends BaseTest {
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		firstName = "El";
		lastName = "Nino";
		emailAddress = firstName + lastName + generatorNumberRandom() + "@gmail.net";
		password = "123456";

		System.out.println("Pre-condition - step 1: Opening app");
		driver = getBrowserDriver(browserName);
		homePageObject = PageGeneratorManager.getHomePage(driver);
		
		System.out.println("Pre-condition - step 2: click to My Account link");
		loginPageObject = homePageObject.clickToMyAccountLink();

		System.out.println("Pre-condition - step 3: click to Create an account button");
		registerPageObject = loginPageObject.clickToCreateAnAccountButton();
	}

	@Test
	public void Register_01_Empty_Data() {

		System.out.println("Register_01 - step 1: click to register button");
		registerPageObject.clickToRegisterButton();

		System.out.println("Register_01 - step 2: verify error message at all of mandatory fields");
		Assert.assertEquals(registerPageObject.getErrorMessageAtFirstNameTextbox(), "This is a required field.");
		Assert.assertEquals(registerPageObject.getErrorMessageAtLastNameTextbox(), "This is a required field.");
		Assert.assertEquals(registerPageObject.getErrorMessageAtEmailTextbox(), "This is a required field.");
		Assert.assertEquals(registerPageObject.getErrorMessageAtPasswordTextbox(), "This is a required field.");
		Assert.assertEquals(registerPageObject.getErrorMessageAtConfirmPasswordTextbox(), "This is a required field.");
	}

	@Test
	public void Register_02_Invalid_Email() {

		System.out.println("Register_02 - step 1: click To Account Link");
		homePageObject.clickToAccountLink();

		System.out.println("Register_02 - step 2: click To Register Link to refresh Register page");
		registerPageObject = homePageObject.clickToRegisterLink();

		System.out.println("Register_02 - step 3: input to all of mandatory fields without invalid email");
		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailAddressTextbox("123as@#jhj.#@");
		registerPageObject.inputToPasswordTextbox(password);
		registerPageObject.inputToConfirmPasswordTextbox(password);

		System.out.println("Register_02 - step 4: click to register button");
		registerPageObject.clickToRegisterButton();

		System.out.println("Register_02 - step 5: verify validation message at email textbox");
		Assert.assertEquals(registerPageObject.verifyValidationMessageAtEmailTextbox(), "Please enter an email address.");
	}

	@Test
	public void Register_03_Valid_Email() {

		System.out.println("Register_03 - step 1: click To Account Link");
		homePageObject.clickToAccountLink();

		System.out.println("Register_03 - step 2: click To Register Link to refresh Register page");
		registerPageObject = homePageObject.clickToRegisterLink();

		System.out.println("Register_03 - step 3: input to all of mandatory fields");
		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailAddressTextbox(emailAddress);
		registerPageObject.inputToPasswordTextbox(password);
		registerPageObject.inputToConfirmPasswordTextbox(password);

		System.out.println("Register_03 - step 4: click to register button");
		myDashboardPageObject = registerPageObject.clickToRegisterButton();

		System.out.println("Register_03 - step 5: verify register successful message");
		Assert.assertEquals(myDashboardPageObject.getRegisterSuccessfulMessage(), "Thank you for registering with Main Website Store.");

		System.out.println("Register_03 - step 6: click to logout link");
		homePageObject.clickToAccountLink();
		homePageObject = myDashboardPageObject.clickToLogoutLink();

		System.out.println("Register_03 - step 7: waiting in 5 seconds for logout message disappear");
		homePageObject.waitForLogoutMessageInvisible();
		
		System.out.println("Register_03 - step 8: verify switch to home page successfully");
		Assert.assertTrue(homePageObject.isMyAccountLinkDisplayed());
	}

	@Test
	public void Register_04_Existing_Email() {

		System.out.println("Register_04 - step 1: click to My Account link");
		loginPageObject = homePageObject.clickToMyAccountLink();

		System.out.println("Register_04 - step 2: click to Create an account button");
		registerPageObject = loginPageObject.clickToCreateAnAccountButton();

		System.out.println("Register_04 - step 3: input to all of mandatory fields");
		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailAddressTextbox(emailAddress);
		registerPageObject.inputToPasswordTextbox(password);
		registerPageObject.inputToConfirmPasswordTextbox(password);

		System.out.println("Register_04 - step 4: click to register button");
		registerPageObject.clickToRegisterButton();

		System.out.println("Register_04 - step 5: verify error existing message displayed");
		Assert.assertEquals(registerPageObject.getExistingErrorMessage(), "There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.");
	}

	@Test
	public void Register_05_Password_Less_Than_6_Characters() {

		System.out.println("Register_05 - step 1: click To Account Link");
		homePageObject.clickToAccountLink();

		System.out.println("Register_05 - step 2: click To Register Link to refresh Register page");
		registerPageObject = homePageObject.clickToRegisterLink();

		System.out.println("Register_05 - step 3: input to all of mandatory fields");
		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailAddressTextbox(emailAddress);
		registerPageObject.inputToPasswordTextbox("123");
		registerPageObject.inputToConfirmPasswordTextbox("123");
		
		System.out.println("Register_05 - step 4: click to register button");
		registerPageObject.clickToRegisterButton();

		System.out.println("Register_05 - step 5: verify error message at password field");
		Assert.assertEquals(registerPageObject.getErrorMessageAtPasswordTextbox(), "Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Test
	public void Register_06_Confirm_Password_Mismatch() {

		System.out.println("Register_06 - step 1: click To Account Link");
		homePageObject.clickToAccountLink();

		System.out.println("Register_06 - step 2: click To Register Link to refresh Register page");
		registerPageObject = homePageObject.clickToRegisterLink();

		System.out.println("Register_06 - step 3: input to all of mandatory fields");
		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailAddressTextbox(emailAddress);
		registerPageObject.inputToPasswordTextbox(password);
		registerPageObject.inputToConfirmPasswordTextbox("123789");
		
		System.out.println("Register_06 - step 4: click to register button");
		registerPageObject.clickToRegisterButton();

		System.out.println("Register_06 - step 5: verify error message at password field");
		Assert.assertEquals(registerPageObject.getErrorMessageAtPasswordTextbox(), "Please make sure your passwords match.");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Post-condition: Quiting out the browser.");
		driver.quit();
	}
	
	private WebDriver driver;
	private HomePageObject homePageObject;
	private LoginPageObject loginPageObject;
	private RegisterPageObject registerPageObject;
	private MyDashboardPageObject myDashboardPageObject;
	private String firstName, lastName, emailAddress, password;
}