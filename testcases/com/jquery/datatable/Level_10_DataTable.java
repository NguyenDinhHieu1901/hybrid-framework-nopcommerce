package com.jquery.datatable;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.HomePageObject;
import pageObjects.jQuery.PageGeneratorManager;

public class Level_10_DataTable extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String urlApp) {
		driver = getBrowserDriver(browserName, urlApp);
		homePage = PageGeneratorManager.getHomePage(driver);
	}
	
	public void Table_01_Paging() {
		homePage.openPageUrl(driver, "https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/");
		homePage.openPageByNumber("15");
		Assert.assertTrue(homePage.isPageActivedByNumber("15"));
		homePage.sleepInSecond(2);
		
		homePage.openPageByNumber("10");
		Assert.assertTrue(homePage.isPageActivedByNumber("10"));
		homePage.sleepInSecond(2);
		
		homePage.openPageByNumber("24");
		Assert.assertTrue(homePage.isPageActivedByNumber("24"));
		homePage.sleepInSecond(2);
	}
	
	public void Table_02_Input_Header_Textbox() {
		homePage.inputToHeaderTextboxByName("Females", "3704000");
		homePage.sleepInSecond(2);
		
		homePage.inputToHeaderTextboxByName("Country", "Albania");
		homePage.sleepInSecond(2);
		
		homePage.inputToHeaderTextboxByName("Males", "709");
		homePage.sleepInSecond(2);
		
		homePage.inputToHeaderTextboxByName("Total", "34718000");
		homePage.sleepInSecond(2);
	}
	
	public void Table_03_Click_Icon() {
		homePage.clickToIconByCountryName("Afghanistan", "remove");
		homePage.sleepInSecond(2);
		homePage.refreshCurrentPage(driver);
		
		homePage.clickToIconByCountryName("Algeria", "edit");
		homePage.sleepInSecond(2);
		homePage.refreshCurrentPage(driver);
		
		homePage.clickToIconByCountryName("Argentina", "remove");
		homePage.sleepInSecond(2);
	}
	
	public void Table_04_Verify_Row_Values() {
		homePage.inputToHeaderTextboxByName("Females", "384187");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isRowValueDisplayed("384187", "Afghanistan", "407124", "791312"));
		homePage.refreshCurrentPage(driver);
		
		homePage.inputToHeaderTextboxByName("Country", "Argentina");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isRowValueDisplayed("338282", "Argentina", "349238", "687522"));
	}
	
	public void Table_05_Input_Row_Table() {
		homePage.clickToAppendRowButton();
		homePage.clickToAppendRowButton();
		homePage.inputToTextboxByRowNumber("Album", "1", "Bad Habits");
		homePage.sleepInSecond(2);
		
		homePage.inputToTextboxByRowNumber("Artist", "1", "Ed Sheeran");
		homePage.sleepInSecond(2);
		
		homePage.inputToTextboxByRowNumber("Year", "1", "2021");
		homePage.sleepInSecond(2);
	}
	
	@Test
	public void Table_06_Click_Icon_At_Row() {
		homePage.clickToAppendRowButton();
		homePage.clickToAppendRowButton();
		homePage.clickToAppendRowButton();
		homePage.inputToTextboxByRowNumber("Album", "2", "The way that I love You");
		
		homePage.clickToIconByRow("2", "Move Up");
		homePage.sleepInSecond(2);
		homePage.clickToIconByRow("1", "Move Down");
		homePage.sleepInSecond(2);
		
		homePage.clickToIconByRow("4", "Remove Current Row");
		homePage.clickToIconByRow("3", "Remove Current Row");
		homePage.sleepInSecond(2);
		homePage.clickToIconByRow("2", "Remove Current Row");
		homePage.clickToIconByRow("1", "Remove Current Row");
		homePage.sleepInSecond(2);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
