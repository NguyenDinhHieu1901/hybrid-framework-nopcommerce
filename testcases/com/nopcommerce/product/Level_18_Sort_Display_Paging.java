package com.nopcommerce.product;

import org.openqa.selenium.WebDriver;
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
		homePageObject.openSubMenuByPageName(driver, "Computers ", "Notebooks ");
		notebooksPageObject = PageGeneratorManager.getUserNotebooksPage(driver);
	}

	@Test
	public void Sort_Display_01_Name_A_Z() {
		log.info("Sort_Display_01 - Step 01: Select item in 'Sort by' dropdown");
		notebooksPageObject.selectItemInDefaultDropdownByID("products-orderby", "Name: A to Z");

		log.info("Sort_Display_01 - Step 02: Verify Ascending Sort is displayed correctly");
		verifyTrue(notebooksPageObject.isProductNameAscendingSort());
	}

	public void Sort_Display_02_Name_Z_A() {
		log.info("Sort_Display_02 - Step 01: Select item in 'Sort by' dropdown");
		notebooksPageObject.selectItemInDefaultDropdownByID("products-orderby", "Name: Z to A");

		log.info("Sort_Display_02 - Step 02: Verify Descending Sort is displayed correctly");
		verifyTrue(notebooksPageObject.isProductNameDescendingSort());
	}

	@Test
	public void Sort_Display_03_Price_Low_High() {
		log.info("Sort_Display_03 - Step 01: Select item in 'Sort by' dropdown");
		notebooksPageObject.selectItemInDefaultDropdownByID("products-orderby", "Price: Low to High");

		log.info("Sort_Display_02 - Step 02: Verify Price sorted Low to High is displayed correctly");
		verifyTrue(notebooksPageObject.isProductPriceLowToHigh());
	}

	@Test
	public void Sort_Display_04_Price_High_Low() {
		log.info("Sort_Display_03 - Step 01: Select item in 'Sort by' dropdown");
		notebooksPageObject.selectItemInDefaultDropdownByID("products-orderby", "Price: High to Low");

		log.info("Sort_Display_02 - Step 02: Verify Price sorted High to Low is displayed correctly");
		verifyTrue(notebooksPageObject.isProductPriceHighToLow());
	}

	@Test
	public void Sort_Display_05_Paging_3() {
		log.info("Paging_05 - Step 01: Select item 3 in 'Paging Size' dropdown");
		notebooksPageObject.selectItemInDefaultDropdownByID("products-pagesize", "3");

		log.info("Paging_05 - Step 02: Verify just only product numbers equal 3 or less then 3 is displayed");
		verifyTrue(notebooksPageObject.getProductNumberSize() <= 3);

		log.info("Paging_05 - Step 03: Verify 'Next page' icon is displayed when current page is 1");
		verifyEquals(notebooksPageObject.getCurrentPageNumber(), "1");
		verifyTrue(notebooksPageObject.isPageIconDisplayedByClass("next-page"));

		log.info("Paging_05 - Step 04: Click to 'Next page' icon");
		notebooksPageObject.clickToPageIconByClass("next-page");

		log.info("Paging_05 - Step 05: Verify 'Previous page' icon is displayed when current page is 2");
		verifyEquals(notebooksPageObject.getCurrentPageNumber(), "2");
		verifyTrue(notebooksPageObject.isPageIconDisplayedByClass("previous-page"));
	}

	@Test
	public void Sort_Display_06_Paging_6() {
		log.info("Paging_06 - Step 01: Select item 6 in 'Paging Size' dropdown");
		notebooksPageObject.selectItemInDefaultDropdownByID("products-pagesize", "6");

		log.info("Paging_06 - Step 02: Verify just only product numbers equal 6 or less then 6 is displayed");
		verifyTrue(notebooksPageObject.getProductNumberSize() <= 6);

		log.info("Paging_06 - Step 03: Verify page icon is undisplayed");
		verifyTrue(notebooksPageObject.isPageIconUndisplayedByClass("next-page"));
		verifyTrue(notebooksPageObject.isPageIconUndisplayedByClass("previous-page"));
	}

	@Test
	public void Sort_Display_07_Paging_9() {
		log.info("Paging_07 - Step 01: Select item 9 in 'Paging Size' dropdown");
		notebooksPageObject.selectItemInDefaultDropdownByID("products-pagesize", "9");

		log.info("Paging_07 - Step 02: Verify just only product numbers equal 6 or less then 6 is displayed");
		verifyTrue(notebooksPageObject.getProductNumberSize() <= 9);

		log.info("Paging_07 - Step 03: Verify page icon is undisplayed");
		verifyTrue(notebooksPageObject.isPageIconUndisplayedByClass("next-page"));
		verifyTrue(notebooksPageObject.isPageIconUndisplayedByClass("previous-page"));
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		log.info("Post-condition: Cleaning the Browser and the Driver");
		closeBrowserAndDriver();
	}

	private WebDriver driver;
	private UserHomePageObject homePageObject;
	private UserNotebooksPageObject notebooksPageObject;
}
