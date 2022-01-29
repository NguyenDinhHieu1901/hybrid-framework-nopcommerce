package com.facebook.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.PageGeneratorManagerFacebook;
import pageObjects.facebook.RegisterPageObject;

public class Level_12_Element_Undisplayed extends BaseTest {
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void preCondition(String browserName, String url) {
		driver = getBrowserDriverWithUrl(browserName, url);
		registerPage = PageGeneratorManagerFacebook.getRegisterPage(driver);
	}

	@Test
	public void Register_01_Element_Displayed() {
		registerPage.inputToEmailTextbox("nguyentest@gmail.net");
		registerPage.sleepInSecond(3);
		// Assert.assertTrue(registerPage.isConfirmEmailTextboxDisplayed());
		Assert.assertFalse(registerPage.isConfirmEmailTextboxUndisplayed());
	}

	@Test
	public void Register_02_Element_Undisplayed_In_DOM() {
		registerPage.inputToEmailTextbox("");
		registerPage.sleepInSecond(3);
		Assert.assertTrue(registerPage.isConfirmEmailTextboxUndisplayed());
	}

	@Test
	public void Register_03_Element_Undisplayed_Not_In_DOM() {
		Assert.assertTrue(registerPage.isLoginButtonUndisplayed());
	}

	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}

	private WebDriver driver;
	private RegisterPageObject registerPage;
}