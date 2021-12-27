package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

public class Level_03_Register_Page_Object_Model {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	private String emailAddress, password, firstName, lastName;
	
	HomePageObject homePageObject;
	RegisterPageObject registerPageObject;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		homePageObject = new HomePageObject(driver);
		registerPageObject = new RegisterPageObject(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		firstName = "nguyen";
		lastName = "test";
		emailAddress = firstName + lastName + getEmailFaker() + "@mail.net";
		password = "123456";

		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_01_Register_Empty_Data() {
		
		System.out.println("Home Page - step 1: Click to register link");
		homePageObject.clickToRegisterLink();
		
		System.out.println("Register Page - step 2: Click to register button");
		registerPageObject.clickToRegisterButton();
		
		System.out.println("Register Page - step 3: Verify error message displayed at required fields");
		Assert.assertEquals(registerPageObject.getErrorMessageAtFirstNameTextbox(), "First name is required.");
		Assert.assertEquals(registerPageObject.getErrorMessageAtLastNameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPageObject.getErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPageObject.getErrorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPageObject.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");

	}

	@Test
	public void TC_02_Register_Invalid_Email() {
		
		System.out.println("Home Page - step 1: Click to register link");
		homePageObject.clickToRegisterLink();
		
		System.out.println("Register Page - step 2: Input to all required fields");
		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailTextbox("123@##12");
		registerPageObject.inputToPasswordTextbox(password);
		registerPageObject.inputToConfirmPasswordTextbox(password);

		System.out.println("Register Page - step 3: Click to register button");
		registerPageObject.clickToRegisterButton();
	
		System.out.println("Register Page - step 4: Verify error message displayed");
		Assert.assertEquals(registerPageObject.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void TC_03_Register_Valid() {
		
		System.out.println("Home Page - step 1: Click to register link");
		homePageObject.clickToRegisterLink();
		
		System.out.println("Register Page - step 2: Input to all required fields");
		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailTextbox(emailAddress);
		registerPageObject.inputToPasswordTextbox(password);
		registerPageObject.inputToConfirmPasswordTextbox(password);

		System.out.println("Register Page - step 3: Click to register button");
		registerPageObject.clickToRegisterButton();

		System.out.println("Register Page - step 4: Verify error message displayed");
		Assert.assertEquals(registerPageObject.getRegisterSuccessMessage(), "Your registration completed");


		System.out.println("Register Page - step 5: Click to logout link");
		registerPageObject.clickToLogoutLink();

	}

	@Test
	public void TC_04_Register_Existing_Email() {

		System.out.println("Home Page - step 1: Click to register link");
		homePageObject.clickToRegisterLink();
		
		System.out.println("Register Page - step 2: Input to all required fields");
		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailTextbox(emailAddress);
		registerPageObject.inputToPasswordTextbox(password);
		registerPageObject.inputToConfirmPasswordTextbox(password);

		System.out.println("Register Page - step 3: Click to register button");
		registerPageObject.clickToRegisterButton();
		
		System.out.println("Register Page - step 4: Verify error existing email message displayed");
		Assert.assertEquals(registerPageObject.getErrorExistingEmailMessage(), "The specified email already exists");

	}

	@Test
	public void TC_05_Register_Less_Than_6_Charactes() {
		
		System.out.println("Home Page - step 1: Click to register link");
		homePageObject.clickToRegisterLink();
		
		System.out.println("Register Page - step 2: Input to all required fields");
		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailTextbox(emailAddress);
		registerPageObject.inputToPasswordTextbox("123");
		registerPageObject.inputToConfirmPasswordTextbox(password);

		System.out.println("Register Page - step 3: Click to register button");
		registerPageObject.clickToRegisterButton();
		
		System.out.println("Register Page - step 4: Verify error message displayed");
		Assert.assertEquals(registerPageObject.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void TC_06_Register_Confirm_Password_Missmatch() {

		System.out.println("Home Page - step 1: Click to register link");
		homePageObject.clickToRegisterLink();
		
		System.out.println("Register Page - step 2: Input to all required fields");
		registerPageObject.inputToFirstNameTextbox(firstName);
		registerPageObject.inputToLastNameTextbox(lastName);
		registerPageObject.inputToEmailTextbox(emailAddress);
		registerPageObject.inputToPasswordTextbox(password);
		registerPageObject.inputToConfirmPasswordTextbox(emailAddress);

		System.out.println("Register Page - step 3: Click to register button");
		registerPageObject.clickToRegisterButton();

		System.out.println("Register Page - step 4: Verify error message displayed");
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
