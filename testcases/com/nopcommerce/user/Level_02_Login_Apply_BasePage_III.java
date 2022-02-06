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

public class Level_02_Login_Apply_BasePage_III extends BasePage {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailAddress, password;

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		emailAddress = "nguyentest" + generateFakerEmail() + "@mail.net";
		password = "123456";

		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_01_Login_Empty_Data() {

		waitForClickable(driver, "//a[@class='ico-login']");
		clickToElement(driver, "//a[@class='ico-login']");

		waitForClickable(driver, "//button[contains(@class,'login-button')]");
		clickToElement(driver, "//button[contains(@class,'login-button')]");

		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Please enter your email");
	}

	@Test
	public void TC_02_Login_Invalid_Email() {

		waitForClickable(driver, "//a[@class='ico-login']");
		clickToElement(driver, "//a[@class='ico-login']");

		sendkeyToElement(driver, "//input[@id='Email']", "123@#123");

		waitForClickable(driver, "//button[contains(@class,'login-button')]");
		clickToElement(driver, "//button[contains(@class,'login-button')]");

		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Wrong email");
	}

	@Test
	public void TC_03_Login_Not_Register_Email() {

		waitForClickable(driver, "//a[@class='ico-login']");
		clickToElement(driver, "//a[@class='ico-login']");

		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Password']", password);

		waitForClickable(driver, "//button[contains(@class,'login-button')]");
		clickToElement(driver, "//button[contains(@class,'login-button')]");

		Assert.assertEquals(getElementText(driver, "//div[contains(@class, 'message-error')]"), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}

	@Test
	public void TC_04_Login_Valid_Email_Without_Password() {

		waitForClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		clickToElement(driver, "//input[@id='gender-male']");
		sendkeyToElement(driver, "//input[@id='FirstName']", "nguyen");
		sendkeyToElement(driver, "//input[@id='LastName']", "test");
		selectItemInDefaultDropdown(driver, "//select[@name='DateOfBirthDay']", "19");
		selectItemInDefaultDropdown(driver, "//select[@name='DateOfBirthMonth']", "December");
		selectItemInDefaultDropdown(driver, "//select[@name='DateOfBirthYear']", "2000");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Company']", "nguyen company");
		sendkeyToElement(driver, "//input[@id='Password']", password);
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", password);

		waitForClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");

		waitForClickable(driver, "//a[@class='ico-logout']");
		clickToElement(driver, "//a[@class='ico-logout']");

		waitForClickable(driver, "//a[@class='ico-login']");
		clickToElement(driver, "//a[@class='ico-login']");

		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);

		waitForClickable(driver, "//button[contains(@class,'login-button')]");
		clickToElement(driver, "//button[contains(@class,'login-button')]");

		Assert.assertEquals(getElementText(driver, "//div[contains(@class, 'message-error')]"), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void TC_05_Login_Valid_Email_Incorrect_Password() {

		waitForClickable(driver, "//a[@class='ico-login']");
		clickToElement(driver, "//a[@class='ico-login']");

		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Password']", "123789");

		waitForClickable(driver, "//button[contains(@class,'login-button')]");
		clickToElement(driver, "//button[contains(@class,'login-button')]");

		Assert.assertEquals(getElementText(driver, "//div[contains(@class, 'message-error')]"), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void TC_06_Login_Valid_Email() {
		waitForClickable(driver, "//a[@class='ico-login']");
		clickToElement(driver, "//a[@class='ico-login']");

		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Password']", password);

		waitForClickable(driver, "//button[contains(@class,'login-button')]");
		clickToElement(driver, "//button[contains(@class,'login-button')]");
		
		waitForElementVisible(driver, "//h2[text()='Welcome to our store']");
		Assert.assertEquals(getPageTitle(driver), "nopCommerce demo store");
		
		waitForClickable(driver, "//a[@class='ico-account']");
		clickToElement(driver, "//a[@class='ico-account']");
		
		Assert.assertEquals(getElementAttribute(driver, "//input[@id='FirstName']", "value"), "nguyen");
		Assert.assertEquals(getElementAttribute(driver, "//input[@id='Email']", "value"), emailAddress);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateFakerEmail() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
}
