package com.liveguru.user;

import static org.testng.Assert.assertEquals;

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

public class Level_06_Page_Generator_Manager_02_login extends BaseTest {
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		firstName = "El";
		lastName = "Nino";
		emailAddress = firstName + lastName + getEmailFaker() + "@gmail.net";
		password = "123456";
		emailNotFound = firstName + lastName + getEmailFaker() + "@gmail.com";

		System.out.println("Pre-condition - step 1: Opening app");
		driver = getBrowserDriver(browserName);
		homePageObject = PageGeneratorManager.getHomePage(driver);
		
		System.out.println("Pre-condition - step 2: click to My Account link");
		loginPageObject = homePageObject.clickToMyAccountLink();

		System.out.println("Pre-condition - step 3: click to Create an account button");
		registerPageObject = loginPageObject.clickToCreateAnAccountButton();
		
		System.out.println("Pre-condition - step 4: input to all of mandatory fields");
		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailAddressTextbox(emailAddress);
		registerPageObject.inputToPasswordTextbox(password);
		registerPageObject.inputToConfirmPasswordTextbox(password);

		System.out.println("Pre-condition - step 5: click to register button");
		myDashboardPageObject = registerPageObject.clickToRegisterButton();

		System.out.println("Pre-condition - step 6: verify register successful message");
		Assert.assertEquals(myDashboardPageObject.getRegisterSuccessfulMessage(), "Thank you for registering with Main Website Store.");

		System.out.println("Pre-condition - step 7: click to logout link");
		homePageObject.clickToAccountLink();
		homePageObject = myDashboardPageObject.clickToLogoutLink();

		System.out.println("Pre-condition - step 8: waiting in 5 seconds for logout message disappear");
		homePageObject.waitForLogoutMessageInvisible();
		
		System.out.println("Pre-condition - step 9: verify switch to home page successfully");
		Assert.assertTrue(homePageObject.isMyAccountLinkDisplayed());
	}

	@Test
	public void Login_01_Empty_Data() {
		
		System.out.println("Login_01 - step 1: click to my account link");
		loginPageObject = homePageObject.clickToMyAccountLink();
		
		System.out.println("Login_01 - step 2: click to login button");
		loginPageObject.clickToLoginButton();
		
		System.out.println("Login_01 - step 3: verify error messages at mandatory fields.");
		Assert.assertEquals(loginPageObject.getErrorMessageAtEmailTextbox(), "This is a required field.");
		Assert.assertEquals(loginPageObject.getErrorMessageAtPasswordTextbox(), "This is a required field.");
	}

	@Test
	public void Login_02_Invalid_Email() {
		
		System.out.println("Login_02 - step 1: click to login link to refresh page");
		homePageObject.clickToAccountLink();
		homePageObject.clickToLoginLink();
		
		System.out.println("Login_02 - step 2: input an invalid email to email fields");
		loginPageObject.inputToEmailTextbox("123@aksj#.jkas");
		loginPageObject.inputToPasswordTextbox(password);
		
		System.out.println("Login_02 - step 3: click to login button");
		loginPageObject.clickToLoginButton();
		
		System.out.println("Login_02 - step 4: verify validation message at email textbox");
		assertEquals(loginPageObject.getValidationMessageAtEmailTextbox(), "Please enter an email address.");
	}

	@Test
	public void Login_03_Email_Not_Found() {
		
		System.out.println("Login_03 - step 1: click to login link to refresh page");
		homePageObject.clickToAccountLink();
		homePageObject.clickToLoginLink();
		
		System.out.println("Login_03 - step 2: input an not found email to email fields");
		loginPageObject.inputToEmailTextbox(emailNotFound);
		loginPageObject.inputToPasswordTextbox(password);
		
		System.out.println("Login_03 - step 3: click to login button");
		loginPageObject.clickToLoginButton();
		
		System.out.println("Login_03 - step 4: verify unsuccessful login error message displayed");
		Assert.assertEquals(loginPageObject.getUnsuccessfulLoginErrorMessage(), "Invalid login or password.");
	}

	@Test
	public void Login_04_Valid_Email_Without_Password() {
		
		System.out.println("Login_04 - step 1: click to login link to refresh page");
		homePageObject.clickToAccountLink();
		homePageObject.clickToLoginLink();
		
		System.out.println("Login_04 - step 2: input an empty data to password fields");
		loginPageObject.inputToEmailTextbox(emailAddress);
		loginPageObject.inputToPasswordTextbox("");
		
		System.out.println("Login_04 - step 3: click to login button");
		loginPageObject.clickToLoginButton();
		
		System.out.println("Login_04 - step 4: verify error message at password fields");
		Assert.assertEquals(loginPageObject.getErrorMessageAtPasswordTextbox(), "This is a required field.");
	}

	@Test
	public void Login_05_Valid_Email_Incorrect_Password() {
		
		System.out.println("Login_05 - step 1: click to login link to refresh page");
		homePageObject.clickToAccountLink();
		homePageObject.clickToLoginLink();
		
		System.out.println("Login_05 - step 2: input an incorrect password to password fields");
		loginPageObject.inputToEmailTextbox(emailAddress);
		loginPageObject.inputToPasswordTextbox("123456789");
		
		System.out.println("Login_05 - step 3: click to login button");
		loginPageObject.clickToLoginButton();
		
		System.out.println("Login_05 - step 4: verify unsuccessful login error message displayed");
		Assert.assertEquals(loginPageObject.getUnsuccessfulLoginErrorMessage(), "Invalid login or password.");
	}

	@Test
	public void Login_06_Valid_Email_Password() {
		
		System.out.println("Login_06 - step 1: click to login link to refresh page");
		homePageObject.clickToAccountLink();
		homePageObject.clickToLoginLink();
		
		System.out.println("Login_06 - step 2: input an valid email and password");
		loginPageObject.inputToEmailTextbox(emailAddress);
		loginPageObject.inputToPasswordTextbox(password);
		
		System.out.println("Login_06 - step 3: click to login button");
		myDashboardPageObject = loginPageObject.clickToLoginButton();
		
		System.out.println("Login_06 - step 4: verify login successfully");
		Assert.assertEquals(myDashboardPageObject.getWelcomeMessageText(), "Hello, " + firstName + " " + lastName + "!");
		Assert.assertTrue(myDashboardPageObject.isFullNameInContactInformationDisplayed(firstName + " " + lastName));
		Assert.assertTrue(myDashboardPageObject.isEmailAddressInContactInformationDisplayed(emailAddress));
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
	private String firstName, lastName, emailAddress, password, emailNotFound;
}
