package com.saucelab.sort;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.saucelab.LoginPageObject;
import pageObjects.saucelab.PageGeneratorManager;
import pageObjects.saucelab.ProductsPageObject;

public class Level_18_Sort extends BaseTest {
	private WebDriver driver;
	private LoginPageObject loginPage;
	private ProductsPageObject productsPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		log.info("Pre-Condition - Step 01: Open web application with '" + browserName + "' browser");
		driver = getBrowserDriverWithUrl(browserName, url);
		loginPage = PageGeneratorManager.getLoginPage(driver);

		log.info("Pre-Condition - Step 02: Login to system");
		loginPage.inputToUserNameTextbox("standard_user");
		loginPage.inputToPasswordTextbox("secret_sauce");
		productsPage = loginPage.clickToLoginButton();
	}

	@Test
	public void TC_01_Sort_Name() {
		log.info("TC_01_Sort_Name - Step 01: Sort Ascending");
		productsPage.selectSortInDefaultDropdownByText("Name (A to Z)");
		verifyTrue(productsPage.isProductNameSortAscending());

		log.info("TC_01_Sort_Name - Step 02: Sort Descending");
		productsPage.selectSortInDefaultDropdownByText("Name (Z to A)");
		verifyTrue(productsPage.isProductNameSortDescending());

		verifyTrue(productsPage.isProductNameSortAscending());
	}

	@Test
	public void TC_02_Sort_Price() {
		log.info("TC_02_Sort_Price - Step 01: Sort High to Low");
		productsPage.selectSortInDefaultDropdownByText("Price (high to low)");
		verifyTrue(productsPage.isProductPriceSortHighToLow());

		log.info("TC_02_Sort_Price - Step 02: Sort low to High");
		productsPage.selectSortInDefaultDropdownByText("Price (low to high)");
		verifyTrue(productsPage.isProductPriceSortLowToHigh());

		verifyTrue(productsPage.isProductPriceSortHighToLow());

	}

	@AfterClass
	public void afterClass() {
		log.info("Post-Condition: Cleaning the Browser and the Driver");
		closeBrowserAndDriver();
	}
}
