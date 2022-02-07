package com.facebook.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import commons.BaseTest;
import pageObjects.facebook.LoginPageObject;
import pageObjects.facebook.PageGeneratorManagerFacebook;

public class Level_13_Assert_Verify extends BaseTest {
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void preCondition(String browserName, String url) {
		driver = getBrowserDriverWithUrl(browserName, url);
		loginPage = PageGeneratorManagerFacebook.getLoginPage(driver);
		soft = new SoftAssert();
	}

	public void Register_01_Hard_Assert() {
		System.out.println("Step 01 - Input to email textbox");
		loginPage.inputToEmailTextbox("");

		System.out.println("Step 02 - Input to password textbox");
		loginPage.inputToPasswordTextbox("");

		System.out.println("Step 03 - Click to Login button");
		loginPage.clickToLoginButton();

		// Pass
		System.out.println("Step 05 - Verify error message displayed");
		Assert.assertTrue(loginPage.isErrorMessagesDisplayedAtEmailTextbox());

		// Failed
		System.out.println("Step 10 - Verify ...");
		Assert.assertTrue(loginPage.isErrorMessagesUndisplayedAtEmailTextbox());

		// Pass
		System.out.println("Step 30 - Verify ...");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "The email address or mobile number you entered isn't connected to an account. ");

		// Failed
		System.out.println("Step 45 - Verify ...");
		Assert.assertTrue(loginPage.isTryAgainButtonUndisplayed());

		// Pass
		System.out.println("Step 70 - Verify ...");
		Assert.assertTrue(loginPage.isLoginButtonDisplayed());
	}

	public void Register_02_Soft_Assert() {
		System.out.println("Step 01 - Input to email textbox");
		loginPage.inputToEmailTextbox("");

		System.out.println("Step 02 - Input to password textbox");
		loginPage.inputToPasswordTextbox("");

		System.out.println("Step 03 - Click to Login button");
		loginPage.clickToLoginButton();

		// Passed
		System.out.println("Step 05 - Verify error message displayed");
		checkTrue(loginPage.isErrorMessagesDisplayedAtEmailTextbox());

		// Failed
		System.out.println("Step 10 - Verify ...");
		checkFalse(loginPage.isErrorMessagesUndisplayedAtEmailTextbox());

		// Passed
		System.out.println("Step 30 - Verify ...");
		checkEquals(loginPage.getErrorMessageAtEmailTextbox(), "The email address or mobile number you entered isn't connected to an account. Find your account and log in.");

		// Failed
		System.out.println("Step 45 - Verify ...");
		checkFalse(loginPage.isTryAgainButtonUndisplayed());

		// Passed
		System.out.println("Step 70 - Verify ...");
		checkTrue(loginPage.isLoginButtonDisplayed());

		// Failed
		System.out.println("Step 80 - Verify ...");
		checkEquals(loginPage.getErrorMessageAtEmailTextbox(), "The email address or mobile number you entered isn't connected to an account.");

		soft.assertAll();
	}

	@Test
	public void Register_03_Verify() {
		System.out.println("Step 01 - Input to email textbox");
		loginPage.inputToEmailTextbox("");

		System.out.println("Step 02 - Input to password textbox");
		loginPage.inputToPasswordTextbox("");

		System.out.println("Step 03 - Click to Login button");
		loginPage.clickToLoginButton();

		// Passed
		System.out.println("Step 05 - Verify error message displayed");
		verifyTrue(loginPage.isErrorMessagesDisplayedAtEmailTextbox());

		// Failed
		System.out.println("Step 10 - Verify ...");
		verifyTrue(loginPage.isErrorMessagesUndisplayedAtEmailTextbox());

		// Passed
		System.out.println("Step 30 - Verify ...");
		verifyEquals(loginPage.getErrorMessageAtEmailTextbox(), "The email address or mobile number you entered isn't connected to an account. Find your account and log in.");

		// Failed
		System.out.println("Step 45 - Verify ...");
		verifyTrue(loginPage.isTryAgainButtonUndisplayed());

		// Passed
		System.out.println("Step 70 - Verify ...");
		verifyFalse(loginPage.isLoginButtonDisplayed());

		// Failed
		System.out.println("Step 80 - Verify ...");
		verifyEquals(loginPage.getErrorMessageAtEmailTextbox(), "The email address or mobile number you entered isn't connected to an account.");
	}

	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}

	private boolean checkTrue(boolean condition) {
		boolean status = true;
		try {
			soft.assertTrue(status);
		} catch (Throwable e) {
			System.out.println("Exception = " + e.getMessage());
			status = false;
		}
		return status;
	}

	private boolean checkFalse(boolean condition) {
		boolean status = true;
		try {
			soft.assertFalse(status);
		} catch (Throwable e) {
			System.out.println("Exception = " + e.getMessage());
			status = false;
		}
		return status;
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean status = true;
		try {
			soft.assertEquals(actual, expected);
		} catch (Throwable e) {
			System.out.println("Exception = " + e.getMessage());
			status = false;
		}
		return status;
	}

	private WebDriver driver;
	private LoginPageObject loginPage;
	private SoftAssert soft;
}