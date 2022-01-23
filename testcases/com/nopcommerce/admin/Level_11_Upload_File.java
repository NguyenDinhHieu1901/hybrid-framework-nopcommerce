package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.admin.AdminPageGeneratorManager;
import pageObjects.nopCommerce.admin.AdminProductDetailPageObject;
import pageObjects.nopCommerce.admin.AdminProductSearchPageObject;

public class Level_11_Upload_File extends BaseTest {
	@Parameters({ "browser", "environment" })
	@BeforeClass
	public void beforeClass(String browserName, String environmentName) {
		driver = getBrowserDriver(browserName, environmentName);
		loginPage = AdminPageGeneratorManager.getLoginPage(driver);

		productName = "Windows 8 Pro";
		panelName = "Pictures";
		fileName = "window.jpg";

		System.out.println("Pre-condition: Opening application and navigate to Product Details Page");
		loginPage.enterToEmailTextbox("admin@yourstore.com");
		loginPage.enterToPasswordTextbox("admin");
		dashboardPage = loginPage.clickToLoginButton();
		dashboardPage.clickToSubmenuProductByTagName(driver, "Catalog", "Products");
		productSearchPage = AdminPageGeneratorManager.getProductSearchPage(driver);
		productSearchPage.enterToProductNameTextbox(productName);
		productSearchPage.clickToSearchButton();
		productDetailPage = productSearchPage.clickToEditButtonByProductName(productName);
	}

	@Test
	public void Upload_File_01() {
		productDetailPage.clickToExpandByName(panelName);
		productDetailPage.deleteExistImageByProductName(productName, "Delete");
		Assert.assertEquals(productDetailPage.isEmptyDataTableMessage(), "No data available in table");
		productDetailPage.clickToSaveAndContinueEditButton("save-continue");
		Assert.assertTrue(productDetailPage.isSuccessMessageDisplayed());
		productDetailPage.uploadPictureByFileNames(fileName);
		Assert.assertTrue(productDetailPage.isPictureUploadedSuccessByFileName(fileName));
		productDetailPage.enterToAltTextbox("Window Alt");
		productDetailPage.enterToTitleTextbox("Window Title");
		productDetailPage.clickToIncreaseDisplayOrder(panelName, "increase");
		productDetailPage.clickToAddProductPictureButton();
		Assert.assertTrue(productDetailPage.isPictureImageDisplayed(productName, "1", "Window Alt", "Window Title"));
		productSearchPage = productDetailPage.clickToSaveButton("save");
		Assert.assertTrue(productSearchPage.isSuccessMessageDisplayed());
		productSearchPage.enterToProductNameTextbox(productName);
		productSearchPage.clickToSearchButton();
		Assert.assertTrue(productSearchPage.isPictureImageDisplayed(productName, productName));
		productDetailPage = productSearchPage.clickToEditButtonByProductName(productName);
		productDetailPage.clickToExpandByName(panelName);
		productDetailPage.deleteImageByProductName(productName, "Delete");
		Assert.assertEquals(productDetailPage.isEmptyDataTableMessage(), "No data available in table");
		productSearchPage = productDetailPage.clickToSaveButton("save");
		productSearchPage.enterToProductNameTextbox(productName);
		productSearchPage.clickToSearchButton();
		Assert.assertTrue(productSearchPage.isPictureImageDisplayed("default-image", productName));
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Post-condition: Clean up the browser!");
		driver.quit();
	}

	private WebDriver driver;
	private AdminLoginPageObject loginPage;
	private AdminDashboardPageObject dashboardPage;
	private AdminProductSearchPageObject productSearchPage;
	private AdminProductDetailPageObject productDetailPage;
	private String fileName, productName, panelName;
}
