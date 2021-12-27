package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

public class Level_03_Page_Object_01_Register {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	private String emailAddress, password, firstName, lastName;
	private HomePageObject homePageObject;
	private RegisterPageObject registerPageObject;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://demo.nopcommerce.com/");
		
		homePageObject = new HomePageObject(driver);
	
		firstName = "nguyen";
		lastName = "test";
		emailAddress = firstName + lastName + getEmailFaker() + "@mail.net";
		password = "123456";
	}

	@Test
	public void Register_01_Empty_Data() {
		
		System.out.println("Register_01 - step 1: Click to register link");
		homePageObject.clickToRegisterLink();
		
		System.out.println("Register_01 - step 2: Click to register button");
		registerPageObject = new RegisterPageObject(driver);
		registerPageObject.clickToRegisterButton();
		
		System.out.println("Register_01 - step 3: Verify error message displayed at required fields");
		Assert.assertEquals(registerPageObject.getErrorMessageAtFirstNameTextbox(), "First name is required.");
		Assert.assertEquals(registerPageObject.getErrorMessageAtLastNameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPageObject.getErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPageObject.getErrorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPageObject.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");
	}

	@Test
	public void Register_02_Invalid_Email() {
		
		System.out.println("Register_02 - step 1: Click to register link");
		homePageObject.clickToRegisterLink();
		
		System.out.println("Register_02 - step 2: Input to all required fields");
		registerPageObject = new RegisterPageObject(driver);
		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailTextbox("123@##12");
		registerPageObject.inputToPasswordTextbox(password);
		registerPageObject.inputToConfirmPasswordTextbox(password);

		System.out.println("Register_02 - step 3: Click to register button");
		registerPageObject.clickToRegisterButton();
	
		System.out.println("Register_02 - step 4: Verify error message displayed");
		Assert.assertEquals(registerPageObject.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void Register_03_Valid_Email_Password() {
		
		System.out.println("Register_03 - step 1: Click to register link");
		homePageObject.clickToRegisterLink();
		
		System.out.println("Register_03 - step 2: Input to all required fields");
		registerPageObject = new RegisterPageObject(driver);
		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailTextbox(emailAddress);
		registerPageObject.inputToPasswordTextbox(password);
		registerPageObject.inputToConfirmPasswordTextbox(password);

		System.out.println("Register_03 - step 3: Click to register button");
		registerPageObject.clickToRegisterButton();

		System.out.println("Register_03 - step 4: Verify error message displayed");
		Assert.assertEquals(registerPageObject.getRegisterSuccessMessage(), "Your registration completed");


		System.out.println("Register_03 - step 5: Click to logout link");
		registerPageObject.clickToLogoutLink();
	}

	@Test
	public void Register_04_Existing_Email() {

		System.out.println("Register_04 - step 1: Click to register link");
		homePageObject.clickToRegisterLink();
		
		System.out.println("Register_04 - step 2: Input to all required fields");
		registerPageObject = new RegisterPageObject(driver);
		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailTextbox(emailAddress);
		registerPageObject.inputToPasswordTextbox(password);
		registerPageObject.inputToConfirmPasswordTextbox(password);

		System.out.println("Register_04 - step 3: Click to register button");
		registerPageObject.clickToRegisterButton();
		
		System.out.println("Register_04 - step 4: Verify error existing email message displayed");
		Assert.assertEquals(registerPageObject.getErrorExistingEmailMessage(), "The specified email already exists");
	}

	@Test
	public void Register_05_Less_Than_6_Charactes() {
		
		System.out.println("Register_05 - step 1: Click to register link");
		homePageObject.clickToRegisterLink();
		
		System.out.println("Register_05 - step 2: Input to all required fields");
		registerPageObject = new RegisterPageObject(driver);
		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailTextbox(emailAddress);
		registerPageObject.inputToPasswordTextbox("123");
		registerPageObject.inputToConfirmPasswordTextbox(password);

		System.out.println("Register_05 - step 3: Click to register button");
		registerPageObject.clickToRegisterButton();
		
		System.out.println("Register_05 - step 4: Verify error message displayed");
		Assert.assertEquals(registerPageObject.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void Register_06_Confirm_Password_Missmatch() {

		System.out.println("Register_06 - step 1: Click to register link");
		homePageObject.clickToRegisterLink();
		
		System.out.println("Register_06 - step 2: Input to all required fields");
		registerPageObject = new RegisterPageObject(driver);
		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailTextbox(emailAddress);
		registerPageObject.inputToPasswordTextbox(password);
		registerPageObject.inputToConfirmPasswordTextbox(emailAddress);

		System.out.println("Register_06 - step 3: Click to register button");
		registerPageObject.clickToRegisterButton();

		System.out.println("Register_06 - step 4: Verify error message displayed");
		Assert.assertEquals(registerPageObject.getErrorMessageAtConfirmPasswordTextbox(), "The password and confirmation password do not match.");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int getEmailFaker() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
