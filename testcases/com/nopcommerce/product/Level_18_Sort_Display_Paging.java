package com.nopcommerce.product;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.user.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserNotebooksPageObject;

public class Level_18_Sort_Display_Paging extends BaseTest {
	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		log.info("Pre-condition - Step 01: Open Web Application");
		driver = getBrowserDriver(browserName);
		homePageObject = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Pre-condition - Step 02: Open Submenu 'Notebooks' page");
		homePageObject.openPagesAtMenuByName(driver, "Computers ", "Notebooks ");
		notebooksPageObject = PageGeneratorManager.getUserNotebooksPage(driver);
	}

	@Test
	public void Sort_Display_01_Name_A_Z() {
		log.info("Sort_Display_01 - Step 01: Select item in 'Sort by' dropdown");
		notebooksPageObject.selectItemInSortByDropdown("Name: A to Z");
		
		log.info("Sort_Display_01 - Step 02: Verify Ascending Sort is displayed correctly");
		verifyTrue(notebooksPageObject.isProductNameAscendingSort());
	}

	@Test
	public void Sort_Display_02_Name_Z_A() {
		log.info("Sort_Display_02 - Step 01: Select item in 'Sort by' dropdown");
		notebooksPageObject.selectItemInSortByDropdown("Name: Z to A");
		
		log.info("Sort_Display_02 - Step 02: Verify Descending Sort is displayed correctly");
		verifyTrue(notebooksPageObject.isProductNameDescendingSort());
	}

	@Test
	public void Sort_Display_03_Price_Low_High() {
		log.info("Sort_Display_03 - Step 01: Select item in 'Sort by' dropdown");
		notebooksPageObject.selectItemInSortByDropdown("Price: High to Low");
		
		log.info("Sort_Display_02 - Step 02: Verify Price sorted Low to High is displayed correctly");
		verifyTrue(notebooksPageObject.isProductPriceLowToHigh());
	}

	@Test
	public void Sort_Display_04_Price_High_Low() {
		log.info("Sort_Display_03 - Step 01: Select item in 'Sort by' dropdown");
		notebooksPageObject.selectItemInSortByDropdown("Price: Low to High");
		
		log.info("Sort_Display_02 - Step 02: Verify Price sorted High to Low is displayed correctly");
		verifyTrue(notebooksPageObject.isProductPriceHighToLow());
	}

	public void Sort_Display_05_Paging_3() {
		notebooksPageObject.selectDisplayNumberPerPaging("3");
		List<String> expectedProductTitleList = notebooksPageObject.getExpectedProductTitleList();
		Assert.assertTrue(expectedProductTitleList.size() <= 3);
		Assert.assertTrue(notebooksPageObject.isNextPageButtonDisplay());
		notebooksPageObject.clickToNextPageButton();
		Assert.assertTrue(notebooksPageObject.isPreviousPageButtonDisplay());
	}

	public void Sort_Display_06_Paging_6() {
		notebooksPageObject.scrollToBeginnerPage();
		notebooksPageObject.openPagesAtMenuByName(driver, "Computers ", "Notebooks ");
		notebooksPageObject = PageGeneratorManager.getUserNotebooksPage(driver);
		List<String> expectedProductTitleList = notebooksPageObject.getExpectedProductTitleList();
		Assert.assertTrue(expectedProductTitleList.size() <= 6);
	}

	public void Sort_Display_07_Paging_9() {
		notebooksPageObject.scrollToBeginnerPage();
		notebooksPageObject.openPagesAtMenuByName(driver, "Computers ", "Notebooks ");
		notebooksPageObject = PageGeneratorManager.getUserNotebooksPage(driver);
		notebooksPageObject.selectDisplayNumberPerPaging("9");
		List<String> expectedProductTitleList = notebooksPageObject.getExpectedProductTitleList();
		Assert.assertTrue(expectedProductTitleList.size() <= 9);
	}

	@AfterClass
	public void afterClass() {
		log.info("Post-condition: Quitting out the browser");
		driver.quit();
	}

	private WebDriver driver;
	private UserHomePageObject homePageObject;
	private UserNotebooksPageObject notebooksPageObject;
}
