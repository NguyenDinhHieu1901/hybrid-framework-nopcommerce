//package com.nopcommerce.product;
//
//import java.util.List;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import commons.BaseTest;
//import pageObjects.nopCommerce.user.PageGeneratorManager;
//import pageObjects.nopCommerce.user.UserHomePageObject;
//import pageObjects.nopCommerce.user.UserNotebooksPageObject;
//
//public class Level_09_Dynamic_Xpath_Sort_Display_Paging extends BaseTest {
//	@Parameters({ "browser" })
//	@BeforeClass
//	public void beforeClass(String browserName) {
//		driver = getBrowserDriver(browserName);
//		homePageObject = PageGeneratorManager.getUserHomePage(driver);
//
//		System.out.println("Pre-condition: enter in Notebooks field");
//		homePageObject.openPagesAtMenuByName(driver, "Computers ", "Notebooks ");
//		notebooksPageObject = PageGeneratorManager.getUserNotebooksPage(driver);
//	}
//
//	@Test
//	public void Sort_Display_01_Name_A_Z() {
//		List<String> actualProductTitleListAscending = notebooksPageObject.getActualProductTitleAscending();
//		notebooksPageObject.selectSortByNameAToZ("Name: A to Z");
//		List<String> expectedProductTitleListDescending = notebooksPageObject.getExpectedProductTitleList();
//		Assert.assertEquals(expectedProductTitleListDescending, actualProductTitleListAscending);
//	}
//
//	@Test
//	public void Sort_Display_02_Name_Z_A() {
//		notebooksPageObject.openPagesAtMenuByName(driver, "Computers ", "Notebooks ");
//		notebooksPageObject = PageGeneratorManager.getUserNotebooksPage(driver);
//		List<String> actualProductTitleListDescending = notebooksPageObject.getActualProductTitleDescending();
//		notebooksPageObject.selectSortByNameAToZ("Name: Z to A");
//		List<String> expectedProductTitleListDescending = notebooksPageObject.getExpectedProductTitleList();
//		Assert.assertEquals(expectedProductTitleListDescending, actualProductTitleListDescending);
//	}
//
//	@Test
//	public void Sort_Display_03_Price_Low_High() {
//		notebooksPageObject.openPagesAtMenuByName(driver, "Computers ", "Notebooks ");
//		notebooksPageObject = PageGeneratorManager.getUserNotebooksPage(driver);
//		List<String> actualProductPriceListAscending = notebooksPageObject.getActualProductPriceAscending();
//		notebooksPageObject.selectSortByNameAToZ("Price: Low to High");
//		List<String> expectedProductPriceListAscending = notebooksPageObject.getExpectedProductPriceList();
//		Assert.assertEquals(expectedProductPriceListAscending, actualProductPriceListAscending);
//	}
//
//	@Test
//	public void Sort_Display_04_Price_High_Low() {
//		notebooksPageObject.openPagesAtMenuByName(driver, "Computers ", "Notebooks ");
//		notebooksPageObject = PageGeneratorManager.getUserNotebooksPage(driver);
//		List<String> actualProductPriceListDescending = notebooksPageObject.getActualProductPriceDescending();
//		notebooksPageObject.selectSortByNameAToZ("Price: High to Low");
//		List<String> expectedProductPriceListDescending = notebooksPageObject.getExpectedProductPriceList();
//		Assert.assertEquals(expectedProductPriceListDescending, actualProductPriceListDescending);
//	}
//
//	@Test
//	public void Sort_Display_05_Paging_3() {
//		notebooksPageObject.openPagesAtMenuByName(driver, "Computers ", "Notebooks ");
//		notebooksPageObject = PageGeneratorManager.getUserNotebooksPage(driver);
//		notebooksPageObject.selectDisplayNumberPerPaging("3");
//		List<String> expectedProductTitleList = notebooksPageObject.getExpectedProductTitleList();
//		Assert.assertTrue(expectedProductTitleList.size() <= 3);
//		Assert.assertTrue(notebooksPageObject.isNextPageButtonDisplay());
//		notebooksPageObject.clickToNextPageButton();
//		Assert.assertTrue(notebooksPageObject.isPreviousPageButtonDisplay());
//	}
//
//	@Test
//	public void Sort_Display_06_Paging_6() {
//		notebooksPageObject.scrollToBeginnerPage();
//		notebooksPageObject.openPagesAtMenuByName(driver, "Computers ", "Notebooks ");
//		notebooksPageObject = PageGeneratorManager.getUserNotebooksPage(driver);
//		List<String> expectedProductTitleList = notebooksPageObject.getExpectedProductTitleList();
//		Assert.assertTrue(expectedProductTitleList.size() <= 6);
//	}
//
//	@Test
//	public void Sort_Display_07_Paging_9() {
//		notebooksPageObject.scrollToBeginnerPage();
//		notebooksPageObject.openPagesAtMenuByName(driver, "Computers ", "Notebooks ");
//		notebooksPageObject = PageGeneratorManager.getUserNotebooksPage(driver);
//		notebooksPageObject.selectDisplayNumberPerPaging("9");
//		List<String> expectedProductTitleList = notebooksPageObject.getExpectedProductTitleList();
//		Assert.assertTrue(expectedProductTitleList.size() <= 9);
//	}
//
//	@AfterClass
//	public void afterClass() {
//		System.out.println("Post-condition: Quitting out the browser");
//		driver.quit();
//	}
//
//	private WebDriver driver;
//	private UserHomePageObject homePageObject;
//	private UserNotebooksPageObject notebooksPageObject;
//}
