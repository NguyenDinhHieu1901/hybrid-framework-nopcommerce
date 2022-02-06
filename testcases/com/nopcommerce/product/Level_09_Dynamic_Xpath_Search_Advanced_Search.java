package com.nopcommerce.product;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.user.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserSearchPageObject;

public class Level_09_Dynamic_Xpath_Search_Advanced_Search extends BaseTest {
	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePageObject = PageGeneratorManager.getUserHomePage(driver);

		firstName = "nguyen";
		lastName = "test";
		emailAddress = firstName + lastName + generatorNumberRandom() + "@gmail.net";
		password = "123456";

		System.out.println("Pre-condition: Register and Login account");
		registerPageObject = homePageObject.clickToRegisterLink();
		registerPageObject.registerAsUser(firstName, lastName, emailAddress, password);
		Assert.assertEquals(registerPageObject.getRegisterSuccessMessage(), "Your registration completed");
		homePageObject = registerPageObject.clickToLogoutLinkAtUser(driver);
		loginPageObject = homePageObject.clickToLoginLink();
		homePageObject = loginPageObject.loginAsUser(emailAddress, password);
	}

	@Test
	public void Search_01_Empty_Data() {
		homePageObject.openPagesAtFooterByName(driver, "Search");
		searchPageObject = PageGeneratorManager.getUserSearchPage(driver);
		searchPageObject.clickToSearchButton();
		Assert.assertEquals(searchPageObject.getEmptyDataErrorMessage(), "Search term minimum length is 3 characters");
	}

	@Test
	public void Search_02_Data_Not_Exist() {
		searchPageObject.openPagesAtFooterByName(driver, "Search");
		searchPageObject = PageGeneratorManager.getUserSearchPage(driver);
		searchPageObject.inputToSearchKeywordTextbox("Macbook Pro 2050");
		searchPageObject.clickToSearchButton();
		Assert.assertEquals(searchPageObject.getNotFoundProductErrorMessage(), "No products were found that matched your criteria.");
	}

	@Test
	public void Search_03_Relative_Product_Name() {
		searchPageObject.openPagesAtFooterByName(driver, "Search");
		searchPageObject = PageGeneratorManager.getUserSearchPage(driver);
		searchPageObject.inputToSearchKeywordTextbox("Lenovo");
		searchPageObject.clickToSearchButton();
		Assert.assertEquals(searchPageObject.getTotalProductFound(), 2);
		Assert.assertTrue(searchPageObject.isProductNameFound("Lenovo"));
	}

	@Test
	public void Search_04_Absolutely_Product_Name() {
		searchPageObject.openPagesAtFooterByName(driver, "Search");
		searchPageObject = PageGeneratorManager.getUserSearchPage(driver);
		searchPageObject.inputToSearchKeywordTextbox("Thinkpad X1 Carbon");
		searchPageObject.clickToSearchButton();
		Assert.assertEquals(searchPageObject.getTotalProductFound(), 1);
		Assert.assertTrue(searchPageObject.isProductNameFound("Thinkpad X1 Carbon"));
	}

	@Test
	public void Search_05_Advanced_With_Parent_Categories() {
		searchPageObject.openPagesAtFooterByName(driver, "Search");
		searchPageObject = PageGeneratorManager.getUserSearchPage(driver);
		searchPageObject.inputToSearchKeywordTextbox("Apple MacBook Pro");
		searchPageObject.clickToAdvancedSearchCheckbox();
		searchPageObject.selectCategoryInDefaultDropdown("Computers");
		searchPageObject.clickToSearchButton();
		Assert.assertEquals(searchPageObject.getNotFoundProductErrorMessage(), "No products were found that matched your criteria.");
	}

	@Test
	public void Search_06_Advanced_With_Sub_Categories() {
		searchPageObject.openPagesAtFooterByName(driver, "Search");
		searchPageObject = PageGeneratorManager.getUserSearchPage(driver);
		searchPageObject.inputToSearchKeywordTextbox("Apple Macbook Pro");
		searchPageObject.clickToAdvancedSearchCheckbox();
		searchPageObject.selectCategoryInDefaultDropdown("Computers");
		searchPageObject.clickToAutomaticallySearchSubCategoriesCheckbox();
		searchPageObject.clickToSearchButton();
		Assert.assertEquals(searchPageObject.getTotalProductFound(), 1);
		Assert.assertTrue(searchPageObject.isProductNameFound("Apple MacBook Pro"));
	}

	@Test
	public void Search_07_Advanced_With_Incorrect_Manufacturer() {
		searchPageObject.openPagesAtFooterByName(driver, "Search");
		searchPageObject = PageGeneratorManager.getUserSearchPage(driver);
		searchPageObject.inputToSearchKeywordTextbox("Apple Macbook Pro");
		searchPageObject.clickToAdvancedSearchCheckbox();
		searchPageObject.selectCategoryInDefaultDropdown("Computers");
		searchPageObject.clickToAutomaticallySearchSubCategoriesCheckbox();
		searchPageObject.selectManufacturerInDefaultDropdown("HP");
		searchPageObject.clickToSearchButton();
		Assert.assertEquals(searchPageObject.getNotFoundProductErrorMessage(), "No products were found that matched your criteria.");
	}

	@Test
	public void Search_08_Advanced_With_Correct_ManuFacturer() {
		searchPageObject.openPagesAtFooterByName(driver, "Search");
		searchPageObject = PageGeneratorManager.getUserSearchPage(driver);
		searchPageObject.inputToSearchKeywordTextbox("Apple Macbook Pro");
		searchPageObject.clickToAdvancedSearchCheckbox();
		searchPageObject.selectCategoryInDefaultDropdown("Computers");
		searchPageObject.clickToAutomaticallySearchSubCategoriesCheckbox();
		searchPageObject.selectManufacturerInDefaultDropdown("Apple");
		searchPageObject.clickToSearchButton();
		Assert.assertEquals(searchPageObject.getTotalProductFound(), 1);
		Assert.assertTrue(searchPageObject.isProductNameFound("Apple MacBook Pro"));
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Post-condition: Quitting out the browser");
		driver.quit();
	}

	private WebDriver driver;
	private String emailAddress, password, firstName, lastName;
	private UserHomePageObject homePageObject;
	private UserRegisterPageObject registerPageObject;
	private UserLoginPageObject loginPageObject;
	private UserSearchPageObject searchPageObject;
}
