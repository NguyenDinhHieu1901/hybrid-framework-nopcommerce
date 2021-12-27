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
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Level_03_Page_Object_02_Login {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	private String emailExisting, emailInvalid, emailNotFound, password, firstName, lastName;
	private HomePageObject homePageObject;
	private RegisterPageObject registerPageObject;
	private LoginPageObject loginPageObject;

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
		emailExisting = firstName + lastName + getEmailFaker() + "@mail.net";
		emailNotFound = firstName + lastName + getEmailFaker() + "@mail.com";
		emailInvalid = "123@gmail.com#@.vn";
		password = "123456";
		
		System.out.println("Pre-condition - step 1: Click to register link");
		homePageObject.clickToRegisterLink();
		
		System.out.println("Pre-condition - step 2: Input to all required fields");
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
		homePageObject = new HomePageObject(driver);
		homePageObject.clickToLoginLink();
		
		System.out.println("Login_01 - step 2: click to login button");
		loginPageObject = new LoginPageObject(driver);
		loginPageObject.clickToLoginButton();
		
		System.out.println("Login_01 - step 3: verify error message at email field");
		Assert.assertEquals(loginPageObject.getErrorMessageAtEmailTextbox(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email() {
		
		System.out.println("Login_02 - step 1: click to login link");
		homePageObject = new HomePageObject(driver);
		homePageObject.clickToLoginLink();
		
		System.out.println("Login_02 - step 2: input to email field");
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
		homePageObject = new HomePageObject(driver);
		homePageObject.clickToLoginLink();
		
		System.out.println("Login_03 - step 2: input to email field");
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
		homePageObject = new HomePageObject(driver);
		homePageObject.clickToLoginLink();
		
		System.out.println("Login_04 - step 2: input to email field");
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
		homePageObject = new HomePageObject(driver);
		homePageObject.clickToLoginLink();
		
		System.out.println("Login_05 - step 2: input to email field");
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
		homePageObject = new HomePageObject(driver);
		homePageObject.clickToLoginLink();
		
		System.out.println("Login_06 - step 2: input to email field");
		loginPageObject = new LoginPageObject(driver);
		loginPageObject.inputToEmailTextbox(emailExisting);
		loginPageObject.inputToPasswordTextbox(password);
		
		System.out.println("Login_06 - step 3: click to login button");
		loginPageObject.clickToLoginButton();

		System.out.println("Login_06 - step 4: verify my account link displayed");
		Assert.assertTrue(homePageObject.isMyAccountLinkDisplayed());
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
