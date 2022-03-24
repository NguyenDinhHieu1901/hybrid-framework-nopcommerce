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

public class OrderProductsByCash extends BaseTest {
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
	public void TC_01_Add_Product_To_Cart() {
		log.info("Add_Product_01 - Step 01: Open 'Desktops' submenu");
		homePage.openSubMenuByPageName(driver, "Computers", "Desktops");
		desktopsPage = PageGeneratorManager.getUserDesktopsPage(driver);

		log.info("Add_Product_01 - Step 02: Click to 'Build your own computer' link");
		desktopsPage.clickToProductTitleLinkByName(driver, "Build your own computer");

		log.info("Add_Product_01 - Step 03: Choosing to satisfy the configuration you want");
		desktopsPage.selectItemInProcessorAndRamDropdown("product_attribute_1", processor2Point5Ghz);
		desktopsPage.selectItemInProcessorAndRamDropdown("product_attribute_2", ram8GB);
		desktopsPage.checkToCheckboxOrRadioByLabel(hdd400GB);
		desktopsPage.checkToCheckboxOrRadioByLabel(vistaPremium);
		desktopsPage.checkToCheckboxOrRadioByLabel(office);
		desktopsPage.checkToCheckboxOrRadioByLabel(reader);
		desktopsPage.checkToCheckboxOrRadioByLabel(commander);

		log.info("Add_Product_01 - Step 04: Click to 'Add to Cart' button");
		desktopsPage.clickToButtonByText(driver, "Add to cart");

		log.info("Add_Product_01 - Step 05: Verify is Add to cart message displayed");
		verifyEquals(desktopsPage.getSuccessMessage(driver), "The product has been added to your shopping cart");

		log.info("Add_Product_01 - Step 06: Click to message close");
		desktopsPage.clickToCloseSuccessMessageIcon(driver);

		log.info("Add_Product_01 - Step 07: Get quantity and price of satisfy product");
		quantityProduct = desktopsPage.getQuantityOfSatisfyProduct(driver, "value");
		unitPrice = desktopsPage.getUnitPriceOfProduct(driver);
		System.out.println("Unit Price: " + unitPrice);
		totalPrice = desktopsPage.convertPriceFromStringToFloat(unitPrice) * quantityProduct;
		System.out.println("Total Price: " + totalPrice);

		log.info("Add_Product_01 - Step 08: Verify is product added to Shopping cart");
		verifyEquals(desktopsPage.getAmountOfProductByClass(driver, "cart-qty"), String.valueOf(quantityProduct));

		log.info("Add_Product_01 - Step 09: Verify are all of information in Shopping cart displayed correctly");
		verifyTrue(desktopsPage.isCountProductTitleDisplayed(driver, "count", "There are " + quantityProduct + " item(s) in your cart."));
		verifyTrue(desktopsPage.isInformationOfProductDisplayed(driver, "items", buildOwnComputer));
		verifyTrue(desktopsPage.isInformationOfProductDisplayed(driver, "items", processor2Point5Ghz));
		verifyTrue(desktopsPage.isInformationOfProductDisplayed(driver, "items", ram8GB));
		verifyTrue(desktopsPage.isInformationOfProductDisplayed(driver, "items", hdd400GB));
		verifyTrue(desktopsPage.isInformationOfProductDisplayed(driver, "items", vistaPremium));
		verifyTrue(desktopsPage.isInformationOfProductDisplayed(driver, "items", office));
		verifyTrue(desktopsPage.isInformationOfProductDisplayed(driver, "items", reader));
		verifyTrue(desktopsPage.isInformationOfProductDisplayed(driver, "items", commander));
		verifyTrue(desktopsPage.isInformationOfProductDisplayed(driver, "items", unitPrice));
		verifyTrue(desktopsPage.isInformationOfProductDisplayed(driver, "items", String.valueOf(quantityProduct)));
		verifyTrue(desktopsPage.isTotalPriceDisplayed(driver, "totals", totalPrice));
	}

	@Test
	public void TC_02_Edit_Product_In_Shopping_Cart() {
		log.info("Edit_Product_02 - Step 01: Click to 'Shopping Cart' link");
		shoppingCartPage = desktopsPage.clickToShoppingCartLink(driver);

		log.info("Edit_Product_02 - Step 02: Click to 'Edit' link");
		shoppingCartPage.clickToEditLink();
		desktopsPage = PageGeneratorManager.getUserDesktopsPage(driver);

		log.info("Edit_Product_02 - Step 03: Changing configuration of product");
		desktopsPage.selectItemInProcessorAndRamDropdown("product_attribute_1", processor2Point2Ghz);
		desktopsPage.selectItemInProcessorAndRamDropdown("product_attribute_2", ram4GB);
		desktopsPage.checkToCheckboxOrRadioByLabel(hdd320GB);
		desktopsPage.checkToCheckboxOrRadioByLabel(vistaHome);
		desktopsPage.checkToCheckboxOrRadioByLabel(office);
		desktopsPage.uncheckToCheckboxByLabel(reader);
		desktopsPage.uncheckToCheckboxByLabel(commander);
		desktopsPage.setAmoutOfProduct(driver, "value", "2");

		log.info("Edit_Product_02 - Step 04: Click to 'Update' button");
		desktopsPage.clickToButtonByText(driver, "Update");

		log.info("Edit_Product_02 - Step 05: Get quantity and unit price of product");
		quantityProduct = desktopsPage.getQuantityOfSatisfyProduct(driver, "value");
		unitPrice = desktopsPage.getUnitPriceOfProduct(driver);
		totalPrice = desktopsPage.convertPriceFromStringToFloat(unitPrice) * quantityProduct;

		log.info("Edit_Product_02 - Step 05: Verify is Add to cart message displayed");
		verifyEquals(desktopsPage.getSuccessMessage(driver), "The product has been added to your shopping cart");

		log.info("Edit_Product_02 - Step 06: Click to message close");
		desktopsPage.clickToCloseSuccessMessageIcon(driver);

		log.info("Edit_Product_02 - Step 07: Verify are all of informations updated correctly");
		verifyEquals(desktopsPage.getAmountOfProductByClass(driver, "cart-qty"), String.valueOf(quantityProduct));
		verifyTrue(desktopsPage.isCountProductTitleDisplayed(driver, "count", "There are " + quantityProduct + " item(s) in your cart."));
		verifyTrue(desktopsPage.isInformationOfProductDisplayed(driver, "items", buildOwnComputer));
		verifyTrue(desktopsPage.isInformationOfProductDisplayed(driver, "items", processor2Point2Ghz));
		verifyTrue(desktopsPage.isInformationOfProductDisplayed(driver, "items", ram4GB));
		verifyTrue(desktopsPage.isInformationOfProductDisplayed(driver, "items", hdd320GB));
		verifyTrue(desktopsPage.isInformationOfProductDisplayed(driver, "items", vistaHome));
		verifyTrue(desktopsPage.isInformationOfProductDisplayed(driver, "items", office));
		verifyTrue(desktopsPage.isInformationOfProductDisplayed(driver, "items", unitPrice));
		verifyTrue(desktopsPage.isInformationOfProductDisplayed(driver, "items", String.valueOf(quantityProduct)));
		verifyTrue(desktopsPage.isTotalPriceDisplayed(driver, "totals", totalPrice));
	}

	@Test
	public void TC_03_Remove_Product_From_Shopping_Cart() {
		log.info("Remove_Product_03 - Step 01: Click to 'Shopping Cart' link");
		shoppingCartPage = desktopsPage.clickToShoppingCartLink(driver);

		log.info("Remove_Product_03 - Step 02: Click to 'Remove' button");
		shoppingCartPage.clickToRemoveButton();

		log.info("Remove_Product_03 - Step 03: Verify is Empty message displayed");
		verifyEquals(shoppingCartPage.isEmptyMessageDisplayed(), "Your Shopping Cart is empty!");

		log.info("Remove_Product_03 - Step 04: Verify is product undisplayed");
		verifyTrue(shoppingCartPage.isInformationProductUndisplayed());
	}

	@Test
	public void TC_04_Update_Product_Shopping_Cart() {
		log.info("Update_Product_04 - Step 01: Open 'Deskstop' submenu");
		shoppingCartPage.openSubMenuByPageName(driver, "Computers", "Desktops");
		desktopsPage = PageGeneratorManager.getUserDesktopsPage(driver);

		log.info("Update_Product_04 - Step 02: Click to 'Lenovo IdeaCentre' link");
		desktopsPage.clickToProductTitleLinkByName(driver, lenovoPC);

		log.info("Update_Product_04 - Step 03: Click To 'Add to Cart' button");
		desktopsPage.clickToButtonByText(driver, "Add to cart");

		log.info("Update_Product_04 - Step 04: Verify is Add success message displayed");
		verifyEquals(desktopsPage.getSuccessMessage(driver), "The product has been added to your shopping cart");

		log.info("Update_Product_04 - Step 05: Click to close message");
		desktopsPage.clickToCloseSuccessMessageIcon(driver);

		log.info("Update_Product_04 - Step 06: Click to 'Shopping Cart' link");
		shoppingCartPage = desktopsPage.clickToShoppingCartLink(driver);

		log.info("Update_Product_04 - Step 07: Set amount of product equals 5");
		shoppingCartPage.setAmoutOfProduct(driver, "value", amountOfProduct);

		log.info("Update_Product_04 - Step 08: Click To 'Update shopping cart' button");
		shoppingCartPage.clickToButtonByText(driver, "Update shopping cart");

		log.info("Update_Product_04 - Step 07: Verify is total price of product equal $2,500.00");
		totalOfProduct = shoppingCartPage.getTotalPriceOfProduct();
		System.out.println("Total of Product: " + totalOfProduct);
		verifyEquals(totalOfProduct, "$2,500.00");
	}

	@Test ()
	public void TC_05_Checkout_Order_Product_By_Order_Cash() {
		log.info("Checkout_Product_By_Cash_05 - Step 01: Select item in 'Gift wrapping' dropdown");
		shoppingCartPage.selectItemInDropdownByName(driver, "checkout_attribute_1", "No");

		log.info("Checkout_Product_By_Cash_05 - Step 02: Click to 'I agree the terms' checkbox");
		shoppingCartPage.checkToCheckboxOrRadioByLabel(driver, "I agree with the terms of service and I adhere to them unconditionally");

		log.info("Checkout_Product_By_Cash_05 - Step 03: Click to 'Checkout' button");
		checkoutPage = shoppingCartPage.clickToCheckoutButton();

		log.info("Checkout_Product_By_Cash_05 - Step 04: Enter to requier fileds in 'Billing Address' tab");
		checkoutPage.uncheckToCheckboxByLabel(driver, "Ship to the same address");
		checkoutPage.selectItemInDropdownByName(driver, "BillingNewAddress.CountryId", country);
		checkoutPage.sendkeyToTextboxByID(driver, "BillingNewAddress_City", city);
		checkoutPage.sendkeyToTextboxByID(driver, "BillingNewAddress_Address1", billingAddress);
		checkoutPage.sendkeyToTextboxByID(driver, "BillingNewAddress_ZipPostalCode", zipCode);
		checkoutPage.sendkeyToTextboxByID(driver, "BillingNewAddress_PhoneNumber", phoneNumber);
		checkoutPage.clickToButtonByTextForCheckout("Continue", "Loading next step...");

		log.info("Checkout_Product_By_Cash_05 - Step 05: Enter to requier fileds in 'Shipping Address' tab");
		checkoutPage.selectItemInDropdownByName(driver, "shipping_address_id", "New Address");
		checkoutPage.selectItemInDropdownByName(driver, "ShippingNewAddress.CountryId", country);
		checkoutPage.sendkeyToTextboxByID(driver, "ShippingNewAddress_City", city);
		checkoutPage.sendkeyToTextboxByID(driver, "ShippingNewAddress_Address1", shippingAddress);
		checkoutPage.sendkeyToTextboxByID(driver, "ShippingNewAddress_ZipPostalCode", zipCode);
		checkoutPage.sendkeyToTextboxByID(driver, "ShippingNewAddress_PhoneNumber", phoneNumber);
		checkoutPage.clickToContinueButtonInShippingAddress("Loading next step...");

		log.info("Checkout_Product_By_Cash_05 - Step 06: Select 'Ground' shipping method");
		checkoutPage.checkToCheckboxOrRadioByLabel(driver, "Ground ($0.00)");
		checkoutPage.clickToContinueButtonInShippingMethod("Loading next step...");

		log.info("Checkout_Product_By_Cash_05 - Step 07: Select 'Check/ Money order' payment method");
		checkoutPage.checkToCheckboxOrRadioByLabel(driver, "Check / Money Order");
		checkoutPage.clickToContinueButtonInPaymentMethod("Loading next step...");

		log.info("Checkout_Product_By_Cash_05 - Step 08: Verify is information payment displayed");
		verifyTrue(checkoutPage.isInformationPaymentForCashDisplayed());
		checkoutPage.clickToContinueButtonInPaymentInformation("Loading next step...");

		log.info("Checkout_Product_By_Cash_05 - Step 09: Verify is Order information correctly");
		verifyTrue(checkoutPage.isInformationOrderDisplayed("billing-info-wrap", "billing-info", "phone", phoneNumber));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("billing-info-wrap", "billing-info", "address1", billingAddress));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("billing-info-wrap", "billing-info", "city-state-zip", city));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("billing-info-wrap", "billing-info", "city-state-zip", zipCode));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("billing-info-wrap", "billing-info", "country", country));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("billing-info-wrap", "payment-method-info", "payment-method", "Check / Money Order"));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("shipping-info-wrap", "shipping-info", "phone", phoneNumber));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("shipping-info-wrap", "shipping-info", "address1", shippingAddress));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("shipping-info-wrap", "shipping-info", "city-state-zip", city));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("shipping-info-wrap", "shipping-info", "city-state-zip", zipCode));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("shipping-info-wrap", "shipping-info", "country", country));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("shipping-info-wrap", "shipping-method-info", "shipping-method", "Ground"));
		verifyEquals(checkoutPage.getTotalPriceOfProduct(), totalOfProduct);
		checkoutPage.clickToConfirmOrderButton("Submitting order information...");

		log.info("Checkout_Product_By_Cash_05 - Step 10: Verify is success message displayed");
		verifyEquals(checkoutPage.getSuccessOrderMessage(), "Your order has been successfully processed!");

		log.info("Checkout_Product_By_Cash_05 - Step 11: Verify is order number displayed");
		orderNumber = checkoutPage.getOrderNumber();
		verifyTrue(checkoutPage.isOrderNumberDisplayed(orderNumber));

		log.info("Checkout_Product_By_Cash_05 - Step 12: Click to 'My Account' link");
		checkoutPage.openHeaderPageByText(driver, "My account");
		myAccoutPage = PageGeneratorManager.getUserMyAccountPage(driver);

		log.info("Checkout_Product_By_Cash_05 - Step 13: Click to 'Orders' sidebar");
		myAccoutPage.openPagesAtMyAccountByPageName(driver, "Orders");

		log.info("Checkout_Product_By_Cash_05 - Step 14: Click to 'Details' link");
		myAccoutPage.clickToButtonByText(driver, "Details");
		checkoutPage = PageGeneratorManager.getUserCheckoutPage(driver);

		log.info("Checkout_Product_By_Cash_05 - Step 15: Verify is order information displayed correctly");
		verifyTrue(checkoutPage.isOrderNumberDisplayed(orderNumber));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("billing-info-wrap", "billing-info", "phone", phoneNumber));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("billing-info-wrap", "billing-info", "address1", billingAddress));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("billing-info-wrap", "billing-info", "city-state-zip", city));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("billing-info-wrap", "billing-info", "city-state-zip", zipCode));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("billing-info-wrap", "billing-info", "country", country));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("billing-info-wrap", "payment-method-info", "payment-method", "Check / Money Order"));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("shipping-info-wrap", "shipping-info", "phone", phoneNumber));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("shipping-info-wrap", "shipping-info", "address1", shippingAddress));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("shipping-info-wrap", "shipping-info", "city-state-zip", city));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("shipping-info-wrap", "shipping-info", "city-state-zip", zipCode));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("shipping-info-wrap", "shipping-info", "country", country));
		verifyTrue(checkoutPage.isInformationOrderDisplayed("shipping-info-wrap", "shipping-method-info", "shipping-method", "Ground"));
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
