package com.nopcommerce.payment;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.commons.Commons_01_Login;

import commons.BaseTest;
import environmentConfig.Environment;
import pageObjects.nopCommerce.user.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCheckoutPageObject;
import pageObjects.nopCommerce.user.UserDesktopsPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyAccountPageObject;
import pageObjects.nopCommerce.user.UserShoppingCartPageObject;

public class OrderProductsByCreditCard extends BaseTest {
	@Parameters({ "browser", "environment" })
	@BeforeClass
	public void preCondition(String browserName, String environmentName) {
		ConfigFactory.setProperty("env", environmentName);
		environment = ConfigFactory.create(Environment.class);

		buildOwnComputer = "Build your own computer";
		lenovoPC = "Lenovo IdeaCentre 600 All-in-One PC";
		processor2Point5Ghz = "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]";
		processor2Point2Ghz = "2.2 GHz Intel Pentium Dual-Core E2200";
		ram8GB = "8GB [+$60.00]";
		ram4GB = "4GB [+$20.00]";
		hdd320GB = "320 GB";
		hdd400GB = "400 GB [+$100.00]";
		vistaHome = "Vista Home [+$50.00]";
		vistaPremium = "Vista Premium [+$60.00]";
		office = "Microsoft Office [+$50.00]";
		reader = "Acrobat Reader [+$10.00]";
		commander = "Total Commander [+$5.00]";
		country = "Viet Nam";
		city = "Ho Chi Minh";
		billingAddress = "33 Nguyen Trai";
		zipCode = "70000";
		phoneNumber = "0909333333";
		shippingAddress = "33 Nguyen Du";
		amountOfProduct = "5";

		log.info("Pre-condition - Step 01: Open application Url");
		driver = getBrowserDriver(browserName, environment.getApplicationUrl());
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Pre-condition - Step 02: Click to Login link");
		loginPage = homePage.clickToLoginLink();

		log.info("Pre-condition - Step 02: Register and Login to system as User role");
		loginPage.setAllCookies(driver, Commons_01_Login.cookiesLoginPage);
		loginPage.sleepInSecond(3);
		loginPage.refreshCurrentPage(driver);
		homePage = loginPage.clickToNopCommerceImage();
	}

	@Test
	public void TC_06_Checkout_Order_Product_By_Card() {
		log.info("Checkout_Product_By_Card_06 - Step 01: Open 'Notebooks' submenu");
		homePage.openSubMenuByPageName(driver, "Computers", "Notebooks");
		desktopsPage = PageGeneratorManager.getUserDesktopsPage(driver);

		log.info("Checkout_Product_By_Card_06 - Step 02: Click to 'Lenovo IdeaCentre' link");
		desktopsPage.clickToProductTitleLinkByName(driver, "Apple MacBook Pro 13-inch");

		log.info("Checkout_Product_By_Card_06 - Step 03: Click To 'Add to Cart' button");
		desktopsPage.clickToButtonByText(driver, "Add to cart");

		log.info("Checkout_Product_By_Card_06 - Step 04: Verify is Add success message displayed");
		verifyEquals(desktopsPage.getSuccessMessage(driver), "The product has been added to your shopping cart");

		log.info("Checkout_Product_By_Card_06 - Step 05: Click to close message");
		desktopsPage.clickToCloseSuccessMessageIcon(driver);

		log.info("Checkout_Product_By_Card_06 - Step 06: Click to 'Shopping Cart' link");
		shoppingCartPage = desktopsPage.clickToShoppingCartLink(driver);

		log.info("Checkout_Product_By_Card_06 - Step 07: Verify is total price of product equal $3,600.00");
		totalOfProduct = shoppingCartPage.getTotalPriceOfProduct();
		System.out.println("Total of Product: " + totalOfProduct);
		verifyEquals(totalOfProduct, "$3,600.00");

		log.info("Checkout_Product_By_Card_06 - Step 08: Select item in 'Gift wrapping' dropdown");
		shoppingCartPage.selectItemInDropdownByName(driver, "checkout_attribute_1", "No");

		log.info("Checkout_Product_By_Card_06 - Step 09: Click to 'I agree the terms' checkbox");
		shoppingCartPage.checkToCheckboxOrRadioByLabel(driver, "I agree with the terms of service and I adhere to them unconditionally");

		log.info("Checkout_Product_By_Card_06 - Step 10: Click to 'Checkout' button");
		checkoutPage = shoppingCartPage.clickToCheckoutButton();

		log.info("Checkout_Product_By_Card_06 - Step 11: Check to 'Ship to the same address' checkbox");
		checkoutPage.checkToCheckboxOrRadioByLabel(driver, "Ship to the same address");
		checkoutPage.selectItemInDropdownByName(driver, "BillingNewAddress.CountryId", country);
		checkoutPage.sendkeyToTextboxByID(driver, "BillingNewAddress_City", city);
		checkoutPage.sendkeyToTextboxByID(driver, "BillingNewAddress_Address1", billingAddress);
		checkoutPage.sendkeyToTextboxByID(driver, "BillingNewAddress_ZipPostalCode", zipCode);
		checkoutPage.sendkeyToTextboxByID(driver, "BillingNewAddress_PhoneNumber", phoneNumber);

		log.info("Checkout_Product_By_Card_06 - Step 12: Click to 'Continue' button");
		checkoutPage.clickToButtonByTextForCheckout("Continue", "Loading next step...");

		log.info("Checkout_Product_By_Card_06 - Step 13: Select 'Next Day Air' shipping method");
		checkoutPage.checkToCheckboxOrRadioByLabel(driver, "Next Day Air ($0.00)");
		checkoutPage.clickToContinueButtonInShippingMethod("Loading next step...");

		log.info("Checkout_Product_By_Card_06 - Step 14: Select 'Credit Card' payment method");
		checkoutPage.checkToCheckboxOrRadioByLabel(driver, "Credit Card");
		checkoutPage.clickToContinueButtonInPaymentMethod("Loading next step...");

		log.info("Checkout_Product_By_Card_06 - Step 15: Enter all of required fileds in Credit Card field");
		checkoutPage.selectItemInDropdownByName(driver, "CreditCardType", "Visa");
		checkoutPage.sendkeyToTextboxByID(driver, "CardholderName", "Nguyen Test");
		checkoutPage.sendkeyToTextboxByID(driver, "CardNumber", "4009 5985 8869 5177");
		checkoutPage.selectItemInDropdownByName(driver, "ExpireMonth", "02");
		checkoutPage.selectItemInDropdownByName(driver, "ExpireYear", "2023");
		checkoutPage.sendkeyToTextboxByID(driver, "CardCode", "769");
		checkoutPage.clickToContinueButtonInPaymentInformation("Loading next step...");

		log.info("Checkout_Product_By_Card_06 - Step 16: Verify is Order information correctly");
		verifyTrue(checkoutPage.isInformationOrderDisplayed("billing-info-wrap", "billing-info", "phone", phoneNumber));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("billing-info-wrap", "billing-info", "address1", billingAddress));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("billing-info-wrap", "billing-info", "city-state-zip", city));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("billing-info-wrap", "billing-info", "city-state-zip", zipCode));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("billing-info-wrap", "billing-info", "country", country));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("billing-info-wrap", "payment-method-info", "payment-method", "Credit Card"));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("shipping-info-wrap", "shipping-info", "phone", phoneNumber));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("shipping-info-wrap", "shipping-info", "address1", billingAddress));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("shipping-info-wrap", "shipping-info", "city-state-zip", city));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("shipping-info-wrap", "shipping-info", "city-state-zip", zipCode));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("shipping-info-wrap", "shipping-info", "country", country));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("shipping-info-wrap", "shipping-method-info", "shipping-method", "Next Day Air"));
		verifyEquals(checkoutPage.getTotalPriceOfProduct(), totalOfProduct);
		checkoutPage.clickToConfirmOrderButton("Submitting order information...");

		log.info("Checkout_Product_By_Card_06 - Step 17: Verify is success message displayed");
		verifyEquals(checkoutPage.getSuccessOrderMessage(), "Your order has been successfully processed!");

		log.info("Checkout_Product_By_Card_06 - Step 18: Verify is order number displayed");
		orderNumber = checkoutPage.getOrderNumber();
		verifyTrue(checkoutPage.isOrderNumberDisplayed(orderNumber));

		log.info("Checkout_Product_By_Card_06 - Step 19: Click to 'My Account' link");
		checkoutPage.openHeaderPageByText(driver, "My account");
		myAccoutPage = PageGeneratorManager.getUserMyAccountPage(driver);

		log.info("Checkout_Product_By_Card_06 - Step 20: Click to 'Orders' sidebar");
		myAccoutPage.openPagesAtMyAccountByPageName(driver, "Orders");

		log.info("Checkout_Product_By_Card_06 - Step 21: Click to 'Details' link");
		myAccoutPage.clickToButtonByText(driver, "Details");
		checkoutPage = PageGeneratorManager.getUserCheckoutPage(driver);

		log.info("Checkout_Product_By_Card_06 - Step 22: Verify is order information displayed correctly");
		verifyTrue(checkoutPage.isOrderNumberDisplayed(orderNumber));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("billing-info-wrap", "billing-info", "phone", phoneNumber));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("billing-info-wrap", "billing-info", "address1", billingAddress));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("billing-info-wrap", "billing-info", "city-state-zip", city));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("billing-info-wrap", "billing-info", "city-state-zip", zipCode));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("billing-info-wrap", "billing-info", "country", country));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("billing-info-wrap", "payment-method-info", "payment-method", "Credit Card"));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("shipping-info-wrap", "shipping-info", "phone", phoneNumber));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("shipping-info-wrap", "shipping-info", "address1", billingAddress));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("shipping-info-wrap", "shipping-info", "city-state-zip", city));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("shipping-info-wrap", "shipping-info", "city-state-zip", zipCode));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("shipping-info-wrap", "shipping-info", "country", country));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("shipping-info-wrap", "shipping-method-info", "shipping-method", "Next Day Air"));
	}

	@Test
	public void TC_07_ReOrder_Product() {
		log.info("Re-Order_Product - Step 01: Click to 'Re-order' button");
		shoppingCartPage = checkoutPage.clickToReorderButton();

		log.info("Re-Order_Product - Step 02: Set Amount of product equals 10");
		shoppingCartPage.setAmoutOfProduct(driver, "value", "5");

		log.info("Re-Order_Product - Step 03: Click to 'Update shopping cart' button");
		shoppingCartPage.clickToButtonByText(driver, "Update shopping cart");

		log.info("Re-Order_Product - Step 04: Verify is total price of product equal $9,000.00");
		totalOfProduct = shoppingCartPage.getTotalPriceOfProduct();
		System.out.println("Total of Product: " + totalOfProduct);
		verifyEquals(totalOfProduct, "$9,000.00");

		log.info("Re-Order_Product - Step 05: Select item in 'Gift wrapping' dropdown");
		shoppingCartPage.selectItemInDropdownByName(driver, "checkout_attribute_1", "No");

		log.info("Re-Order_Product - Step 06: Click to 'I agree the terms' checkbox");
		shoppingCartPage.checkToCheckboxOrRadioByLabel(driver, "I agree with the terms of service and I adhere to them unconditionally");

		log.info("Re-Order_Product - Step 07: Click to 'Checkout' button");
		checkoutPage = shoppingCartPage.clickToCheckoutButton();

		log.info("Re-Order_Product - Step 08: Check to 'Ship to the same address' checkbox");
		checkoutPage.checkToCheckboxOrRadioByLabel(driver, "Ship to the same address");
		checkoutPage.selectItemInDropdownByName(driver, "billing_address_id", "New Address");
		checkoutPage.sendkeyToTextboxByID(driver, "BillingNewAddress_FirstName", "Nguyen");
		checkoutPage.sendkeyToTextboxByID(driver, "BillingNewAddress_LastName", "Nguyen");
		checkoutPage.sendkeyToTextboxByID(driver, "BillingNewAddress_Email", "NguyenTest3333@gmail.net");
		checkoutPage.selectItemInDropdownByName(driver, "BillingNewAddress.CountryId", country);
		checkoutPage.sendkeyToTextboxByID(driver, "BillingNewAddress_City", city);
		checkoutPage.sendkeyToTextboxByID(driver, "BillingNewAddress_Address1", "1 Le Lai");
		checkoutPage.sendkeyToTextboxByID(driver, "BillingNewAddress_ZipPostalCode", zipCode);
		checkoutPage.sendkeyToTextboxByID(driver, "BillingNewAddress_PhoneNumber", phoneNumber);

		log.info("Re-Order_Product - Step 09: Click to 'Continue' button");
		checkoutPage.clickToButtonByTextForCheckout("Continue", "Loading next step...");

		log.info("Re-Order_Product - Step 10: Select '2nd Day Air' shipping method");
		checkoutPage.checkToCheckboxOrRadioByLabel(driver, "2nd Day Air ($0.00)");
		checkoutPage.clickToContinueButtonInShippingMethod("Loading next step...");

		log.info("Re-Order_Product - Step 11: Select 'Credit Card' payment method");
		checkoutPage.checkToCheckboxOrRadioByLabel(driver, "Credit Card");
		checkoutPage.clickToContinueButtonInPaymentMethod("Loading next step...");

		log.info("Re-Order_Product - Step 12: Enter all of required fileds in Credit Card field");
		checkoutPage.selectItemInDropdownByName(driver, "CreditCardType", "Visa");
		checkoutPage.sendkeyToTextboxByID(driver, "CardholderName", "Nguyen Nguyen");
		checkoutPage.sendkeyToTextboxByID(driver, "CardNumber", "4576009228850613");
		checkoutPage.selectItemInDropdownByName(driver, "ExpireMonth", "08");
		checkoutPage.selectItemInDropdownByName(driver, "ExpireYear", "2030");
		checkoutPage.sendkeyToTextboxByID(driver, "CardCode", "263");
		checkoutPage.clickToContinueButtonInPaymentInformation("Loading next step...");

		log.info("Re-Order_Product - Step 13: Verify is Order information correctly");
		verifyTrue(checkoutPage.isInformationOrderDisplayed("billing-info-wrap", "billing-info", "phone", phoneNumber));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("billing-info-wrap", "billing-info", "address1", "1 Le Lai"));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("billing-info-wrap", "billing-info", "city-state-zip", city));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("billing-info-wrap", "billing-info", "city-state-zip", zipCode));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("billing-info-wrap", "billing-info", "country", country));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("billing-info-wrap", "payment-method-info", "payment-method", "Credit Card"));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("shipping-info-wrap", "shipping-info", "phone", phoneNumber));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("shipping-info-wrap", "shipping-info", "address1", "1 Le Lai"));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("shipping-info-wrap", "shipping-info", "city-state-zip", city));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("shipping-info-wrap", "shipping-info", "city-state-zip", zipCode));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("shipping-info-wrap", "shipping-info", "country", country));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("shipping-info-wrap", "shipping-method-info", "shipping-method", "2nd Day Air"));
		verifyEquals(checkoutPage.getTotalPriceOfProduct(), totalOfProduct);
		checkoutPage.clickToConfirmOrderButton("Submitting order information...");
		checkoutPage.isAlertPresence("Submitting order information...");
		
		log.info("Re-Order_Product - Step 14: Verify is success message displayed");
		verifyEquals(checkoutPage.getSuccessOrderMessage(), "Your order has been successfully processed!");

		log.info("Re-Order_Product - Step 15: Verify is order number displayed");
		orderNumber = checkoutPage.getOrderNumber();
		verifyTrue(checkoutPage.isOrderNumberDisplayed(orderNumber));

		log.info("Re-Order_Product - Step 16: Click to 'My Account' link");
		checkoutPage.openHeaderPageByText(driver, "My account");
		myAccoutPage = PageGeneratorManager.getUserMyAccountPage(driver);

		log.info("Re-Order_Product - Step 17: Click to 'Orders' sidebar");
		myAccoutPage.openPagesAtMyAccountByPageName(driver, "Orders");

		log.info("Re-Order_Product - Step 18: Click to 'Details' link");
		myAccoutPage.clickToButtonByText(driver, "Details");
		checkoutPage = PageGeneratorManager.getUserCheckoutPage(driver);

		log.info("Re-Order_Product - Step 19: Verify is order information displayed correctly");
		verifyTrue(checkoutPage.isOrderNumberDisplayed(orderNumber));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("billing-info-wrap", "billing-info", "phone", phoneNumber));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("billing-info-wrap", "billing-info", "address1", "1 Le Lai"));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("billing-info-wrap", "billing-info", "city-state-zip", city));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("billing-info-wrap", "billing-info", "city-state-zip", zipCode));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("billing-info-wrap", "billing-info", "country", country));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("billing-info-wrap", "payment-method-info", "payment-method", "Credit Card"));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("shipping-info-wrap", "shipping-info", "phone", phoneNumber));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("shipping-info-wrap", "shipping-info", "address1", "1 Le Lai"));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("shipping-info-wrap", "shipping-info", "city-state-zip", city));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("shipping-info-wrap", "shipping-info", "city-state-zip", zipCode));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("shipping-info-wrap", "shipping-info", "country", country));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("shipping-info-wrap", "shipping-method-info", "shipping-method", "2nd Day Air"));

	}

	@Parameters("browser")
	@AfterClass
	public void afterClass(String browserName) {
		log.info("Cleaning the browser '" + browserName + "' and Driver.");
		closeBrowserAndDriver();
	}

	private WebDriver driver;
	private Environment environment;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserShoppingCartPageObject shoppingCartPage;
	private UserDesktopsPageObject desktopsPage;
	private UserCheckoutPageObject checkoutPage;
	private UserMyAccountPageObject myAccoutPage;
	int quantityProduct;
	float totalPrice;
	String buildOwnComputer, macbookPro, asus, lenovoPC, unitPrice;
	String processor2Point5Ghz, processor2Point2Ghz, ram8GB, ram4GB, hdd320GB, hdd400GB, vistaHome, vistaPremium, office, reader, commander;
	String country, city, billingAddress, zipCode, phoneNumber, shippingAddress, amountOfProduct, totalOfProduct, orderNumber;
}
