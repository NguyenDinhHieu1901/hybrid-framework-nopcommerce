package com.nopcommerce.user;

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

		System.out.println("Pre-condition - step 1: Click to register link");
		registerPageObject = homePageObject.clickToRegisterLink();

		System.out.println("Pre-condition - step 2: input all required fields");
		registerPageObject.registerAsUser(firstName, lastName, emailAddress, password);

		System.out.println("Pre-condition - step 3: verify register success message");
		Assert.assertEquals(registerPageObject.getRegisterSuccessMessage(), "Your registration completed");

		System.out.println("Pre-condition - step 4: Click to logout link");
		homePageObject = registerPageObject.clickToLogoutLinkAtUser(driver);

		System.out.println("Pre-condition - step 5: click to login link");
		loginPageObject = homePageObject.clickToLoginLink();

		System.out.println("Pre-condition - step 6: input to email and password fields");
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
	}

	@Test
	public void Search_04_Absolutely_Product_Name() {
		searchPageObject.openPagesAtFooterByName(driver, "Search");
		searchPageObject = PageGeneratorManager.getUserSearchPage(driver);
		searchPageObject.inputToSearchKeywordTextbox("Thinkpad x1 Carbon");
		searchPageObject.clickToSearchButton();
		Assert.assertEquals(searchPageObject.getTotalProductFound(), 1);
	}

	@Test
	public void Search_05_Advanced_With_Parent_Categories() {
		searchPageObject.openPagesAtFooterByName(driver, "Search");
		searchPageObject = PageGeneratorManager.getUserSearchPage(driver);
		searchPageObject.inputToSearchKeywordTextbox("Apple Macbook Pro");
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
