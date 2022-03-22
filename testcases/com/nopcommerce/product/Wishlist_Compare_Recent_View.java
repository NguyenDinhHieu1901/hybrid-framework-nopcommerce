package com.nopcommerce.product;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.UserData;

import commons.BaseTest;
import environmentConfig.Environment;
import pageObjects.nopCommerce.user.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCompareProductPageObject;
import pageObjects.nopCommerce.user.UserDesktopsPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserNotebooksPageObject;
import pageObjects.nopCommerce.user.UserRecentlyViewedProductsPO;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserShoppingCartPageObject;
import pageObjects.nopCommerce.user.UserWishlistPageObject;

public class Wishlist_Compare_Recent_View extends BaseTest {
	@Parameters({ "browser", "environment" })
	@BeforeClass
	public void preCondition(String browserName, String environmentName) {
		ConfigFactory.setProperty("env", environmentName);
		environment = ConfigFactory.create(Environment.class);

		firstName = UserData.Register.firstName;
		lastName = UserData.Register.lastName;
		emailAddress = UserData.Register.emailAddress;
		password = UserData.Register.password;
		macbookPro = "Apple MacBook Pro 13-inch";
		asus = "Asus N551JK-XO076H Laptop";
		hpSleekbook = "HP Envy 6-1180ca 15.6-Inch Sleekbook";
		hpUltraBook = "HP Spectre XT Pro UltraBook";
		lenovoThinkpad = "Lenovo Thinkpad X1 Carbon Laptop";
		samsung = "Samsung Series 9 NP900X4C Premium Ultrabook";
		digitalStormPC = "Digital Storm VANQUISH 3 Custom Performance PC";
		lenovoPC = "Lenovo IdeaCentre 600 All-in-One PC";

		log.info("Pre-condition - Step 01: Open application Url");
		driver = getBrowserDriver(browserName, environment.getApplicationUrl());
		homePage = PageGeneratorManager.getUserHomePage(driver);
		System.out.println("username: " + environment.getApplicationUserName());
		System.out.println("password: " + environment.getApplicationPassword());

		log.info("Pre-condition - Step 02: Click to 'Register' link");
		registerPage = homePage.clickToRegisterLink();

		log.info("Pre-condition - Step 03: Register to system as User role");
		registerPage.registerAsUser(firstName, lastName, emailAddress, password);

		log.info("Pre-condition - Step 04: Click to 'Logout' link");
		homePage = registerPage.clickToLogoutLinkAtUser(driver);

		log.info("Pre-condition - Step 05: Click to 'Login' link");
		loginPage = homePage.clickToLoginLink();

		log.info("Pre-condition - Step 06: Login to system as User role");
		homePage = loginPage.loginAsUser(emailAddress, password);
	}

	@Test
	public void TC_01_Add_To_Wishlist() {
		log.info("Add_To_Wishlist_01 - Step 01: Open Notebooks submenu");
		homePage.openSubMenuByPageName(driver, "Computers", "Notebooks");
		notebooksPage = PageGeneratorManager.getUserNotebooksPage(driver);

		log.info("Add_To_Wishlist_01 - Step 02: Click to 'Apple Macbook Pro' link");
		notebooksPage.clickToProductTitleLinkByName(driver, macbookPro);
		quantityProduct = notebooksPage.getQuantityOfProductByValue("value");

		log.info("Add_To_Wishlist_01 - Step 03: Click to 'Add To Wishlist' button");
		notebooksPage.clickToAddToWishlistButton(driver);

		log.info("Add_To_Wishlist_01 - Step 04: Verify message is displayed");
		verifyEquals(notebooksPage.getSuccessMessage(driver), "The product has been added to your wishlist");

		log.info("Add_To_Wishlist_01 - Step 05: Closing add to wishlist message");
		notebooksPage.clickToCloseSuccessMessageIcon(driver);

		log.info("Add_To_Wishlist_01 - Step 06: Click to 'Wishlist' link");
		wishlistPage = notebooksPage.clickToWishlistLink(driver);

		log.info("Add_To_Wishlist_01 - Step 07: Verify product is added to wishlist page");
		verifyEquals(wishlistPage.getDataTableFromColumnNameAndRowIndex("1", "Product(s)"), macbookPro);
	}

	@Test
	public void TC_02_Add_Product_To_Cart_From_Wishlist() {
		log.info("Add_Product_To_Cart_02 - Step 01: Verify amount of products in Wishlist equal 2");
		verifyEquals(wishlistPage.getAmountOfProductByClass(driver, "wishlist-qty"), quantityProduct);

		log.info("Add_Product_To_Cart_02 - Step 02: Click to Checkbox Add to cart by row Index");
		wishlistPage.clickToAddToCartCheckboxByRowIndex("1");

		log.info("Add_Product_To_Cart_02 - Step 03: Click to Add To Cart button");
		wishlistPage.clickToButtonByText(driver, "Add to cart");
		shoppingCartPage = PageGeneratorManager.getUserShoppingCartPage(driver);

		log.info("Add_Product_To_Cart_02 - Step 04: Verify is product removed from Wishlist page");
		verifyEquals(shoppingCartPage.getAmountOfProductByClass(driver, "wishlist-qty"), "0");

		log.info("Add_Product_To_Cart_02 - Step 05: Verify is product added to Shopping Cart page");
		verifyEquals(shoppingCartPage.getAmountOfProductByClass(driver, "cart-qty"), quantityProduct);
	}

	@Test
	public void TC_03_Remove_Product_In_Wishlist() {
		log.info("Remove_Product_In_Wishlist_03 - Step 01: Open Notebooks submenu");
		shoppingCartPage.openSubMenuByPageName(driver, "Computers", "Notebooks");
		notebooksPage = PageGeneratorManager.getUserNotebooksPage(driver);

		log.info("Remove_Product_In_Wishlist_03 - Step 02: Click to 'Asus' link");
		notebooksPage.clickToProductTitleLinkByName(driver, asus);

		log.info("Remove_Product_In_Wishlist_03 - Step 03: Click to 'Add to wishlist' button");
		notebooksPage.clickToAddToWishlistButton(driver);

		log.info("Remove_Product_In_Wishlist_03 - Step 04: Verify is success message displayed");
		verifyEquals(notebooksPage.getSuccessMessage(driver), "The product has been added to your wishlist");

		log.info("Remove_Product_In_Wishlist_03 - Step 05: Click to 'Close' message");
		notebooksPage.clickToCloseSuccessMessageIcon(driver);

		log.info("Remove_Product_In_Wishlist_03 - Step 06: Click to 'Wishlist' link");
		wishlistPage = notebooksPage.clickToWishlistLink(driver);

		log.info("Remove_Product_In_Wishlist_03 - Step 07: Verify is Product added to wishlist page");
		verifyEquals(wishlistPage.getDataTableFromColumnNameAndRowIndex("1", "Product(s)"), asus);

		log.info("Remove_Product_In_Wishlist_03 - Step 08: Click to 'Remove' button by Row index");
		wishlistPage.clickToRemoveButtonByRowIndex("1");

		log.info("Remove_Product_In_Wishlist_03 - Step 09: Verify is 'Empty' message displayed");
		verifyTrue(wishlistPage.isEmptyMessageDisplayed("The wishlist is empty!"));
	}

	@Test
	public void TC_04_Add_Product_To_Compare() {
		log.info("Product_Compare_04 - Step 01: Open 'Desktops' submenu");
		wishlistPage.openSubMenuByPageName(driver, "Computers", "Desktops");
		desktopsPage = PageGeneratorManager.getUserDesktopsPage(driver);

		log.info("Product_Compare_04 - Step 02: Click to 'Add to compare list' button with Digital Storm PC");
		desktopsPage.clickToAddToCompareListButtonByProductName(driver, digitalStormPC);

		log.info("Product_Compare_04 - Step 03: Verify is success message displayed");
		verifyEquals(desktopsPage.getSuccessMessage(driver), "The product has been added to your product comparison");

		log.info("Product_Compare_04 - Step 04: Click to 'Add to compare list' button with Lenovo PC");
		desktopsPage.clickToAddToCompareListButtonByProductName(driver, lenovoPC);

		log.info("Product_Compare_04 - Step 05: Verify is success message displayed");
		verifyEquals(desktopsPage.getSuccessMessage(driver), "The product has been added to your product comparison");

		log.info("Product_Compare_04 - Step 06: Open 'Compare Product' page at footer");
		desktopsPage.openPageAtFooterByPageName(driver, "Compare products list");
		compareProductPage = PageGeneratorManager.getUserCompareProductPage(driver);

		log.info("Product_Compare_04 - Step 07: Verify is information in comparision table displayed");
		verifyTrue(compareProductPage.IsDataTableByClassAndTextDisplayed("product-name", lenovoPC));
		verifyTrue(compareProductPage.IsDataTableByClassAndTextDisplayed("product-name", digitalStormPC));
		verifyTrue(compareProductPage.IsDataTableByClassAndTextDisplayed("product-price", "$500.00"));
		verifyTrue(compareProductPage.IsDataTableByClassAndTextDisplayed("product-price", "$1,259.00"));

		log.info("Product_Compare_04 - Step 08: Click to 'Clear List' button");
		compareProductPage.clickToClearListButton();

		log.info("Product_Compare_04 - Step 09: Verify is empty product message displayed");
		verifyTrue(compareProductPage.isNoItemsToCompareMessageDisplayed("You have no items to compare."));

		log.info("Product_Compare_04 - Step 10: Verify is all of products in Compare page Undisplayed");
		verifyTrue(compareProductPage.isProductUndisplayedByClassAndText("product-name", lenovoPC));
		verifyTrue(compareProductPage.isProductUndisplayedByClassAndText("product-name", lenovoPC));
	}

	@Test
	public void TC_05_Recently_Viewed_Products() {
		log.info("Recently_Viewed_05 - Step 01: Open Notebooks submenu");
		compareProductPage.openSubMenuByPageName(driver, "Computers", "Notebooks");
		notebooksPage = PageGeneratorManager.getUserNotebooksPage(driver);

		log.info("Recently_Viewed_05 - Step 02: Click to 'Apple Macbook Pro' link");
		notebooksPage.clickToProductTitleLinkByName(driver, macbookPro);

		log.info("Recently_Viewed_05 - Step 03: Click to 'Asus' link");
		notebooksPage.clickToProductTitleLinkByName(driver, asus);

		log.info("Recently_Viewed_05 - Step 04: Click to 'Samsung' link");
		notebooksPage.clickToProductTitleLinkByName(driver, samsung);

		log.info("Recently_Viewed_05 - Step 05: Click to 'HP UltraBook' link");
		notebooksPage.clickToProductTitleLinkByName(driver, hpUltraBook);

		log.info("Recently_Viewed_05 - Step 06: Click to 'Lenovo Thinkpad' link");
		notebooksPage.clickToProductTitleLinkByName(driver, lenovoThinkpad);

		log.info("Recently_Viewed_05 - Step 07: Click to 'HP SleekBook' link");
		notebooksPage.clickToProductTitleLinkByName(driver, hpSleekbook);

		log.info("Recently_Viewed_05 - Step 08: Open 'Recently Viewed Products' page at footer");
		notebooksPage.openPageAtFooterByPageName(driver, "Recently viewed products");
		recentlyViewedPage = PageGeneratorManager.getUserRecentlyViewedPage(driver);

		log.info("Recently_Viewed_05 - Step 09: Verify is size's product list equal 3");
		verifyEquals(recentlyViewedPage.getSizeOfProductsList(), 3);

		log.info("Recently_Viewed_05 - Step 10: Verify is page contains just only the latest three products");
		verifyTrue(recentlyViewedPage.isPageLinkDisplayed(hpUltraBook));
		verifyTrue(recentlyViewedPage.isPageLinkDisplayed(hpSleekbook));
		verifyTrue(recentlyViewedPage.isPageLinkDisplayed(lenovoThinkpad));
	}

	@Parameters("browser")
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Cleaning the browser '" + browserName + "' and the driver.");
		closeBrowserAndDriver();
	}

	private WebDriver driver;
	private Environment environment;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserNotebooksPageObject notebooksPage;
	private UserWishlistPageObject wishlistPage;
	private UserShoppingCartPageObject shoppingCartPage;
	private UserDesktopsPageObject desktopsPage;
	private UserCompareProductPageObject compareProductPage;
	private UserRecentlyViewedProductsPO recentlyViewedPage;
	String firstName, lastName, emailAddress, password, macbookPro, quantityProduct, asus;
	String digitalStormPC, lenovoPC, hpSleekbook, hpUltraBook, lenovoThinkpad, samsung;
}
