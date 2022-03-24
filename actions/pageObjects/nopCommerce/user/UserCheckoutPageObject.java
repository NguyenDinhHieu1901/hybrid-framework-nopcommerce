package pageObjects.nopCommerce.user;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserCheckoutPageUI;

public class UserCheckoutPageObject extends BasePage {
	private WebDriver driver;

	public UserCheckoutPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToButtonByTextForCheckout(String textValue, String loadingText) {
		waitForClickable(driver, UserCheckoutPageUI.BUTTON_BY_TEXT, textValue);
		clickToElement(driver, UserCheckoutPageUI.BUTTON_BY_TEXT, textValue);
		waitForElementInvisible(driver, UserCheckoutPageUI.WAIT_FOR_LOADING, loadingText);
	}

	public boolean isInformationPaymentForCashDisplayed() {
		waitForElementVisible(driver, UserCheckoutPageUI.INFORMATION_PAYMENT_FOR_CASH);
		return isElementDisplayed(driver, UserCheckoutPageUI.INFORMATION_PAYMENT_FOR_CASH);
	}

	public boolean isInformationOrderDisplayed(String typeOfInfoWrap, String typeOfInfo, String attributeClass, String actualText) {
		waitForElementVisible(driver, UserCheckoutPageUI.INFORMATION_ORDER, typeOfInfoWrap, typeOfInfo, attributeClass);
		return getElementText(driver, UserCheckoutPageUI.INFORMATION_ORDER, typeOfInfoWrap, typeOfInfo, attributeClass).contains(actualText);
	}

	public String getTotalPriceOfProduct() {
		waitForElementVisible(driver, UserCheckoutPageUI.TOTAL_PRICE);
		return getElementText(driver, UserCheckoutPageUI.TOTAL_PRICE);
	}

	public String getSuccessOrderMessage() {
		waitForElementVisible(driver, UserCheckoutPageUI.ORDER_SUCCESS_MESSAGE);
		return getElementText(driver, UserCheckoutPageUI.ORDER_SUCCESS_MESSAGE);
	}

	public String getOrderNumber() {
		waitForElementVisible(driver, UserCheckoutPageUI.ORDER_NUMBER);
		return getElementText(driver, UserCheckoutPageUI.ORDER_NUMBER).split(": ")[1];
	}

	public boolean isOrderNumberDisplayed(String orderNumber) {
		waitForElementVisible(driver, UserCheckoutPageUI.ORDER_NUMBER);
		return getElementText(driver, UserCheckoutPageUI.ORDER_NUMBER).contains(orderNumber);
	}

	public void clickToContinueButtonInShippingAddress(String loadingText) {
		waitForClickable(driver, UserCheckoutPageUI.CONTINUE_BUTTON_IN_SHIPPING_ADDRESS);
		clickToElement(driver, UserCheckoutPageUI.CONTINUE_BUTTON_IN_SHIPPING_ADDRESS);
		waitForElementInvisible(driver, UserCheckoutPageUI.WAIT_FOR_LOADING, loadingText);
	}

	public void clickToContinueButtonInShippingMethod(String loadingText) {
		waitForClickable(driver, UserCheckoutPageUI.CONTINUE_BUTTON_IN_SHIPPING_METHOD);
		clickToElement(driver, UserCheckoutPageUI.CONTINUE_BUTTON_IN_SHIPPING_METHOD);
		waitForElementInvisible(driver, UserCheckoutPageUI.WAIT_FOR_LOADING, loadingText);
	}

	public void clickToContinueButtonInPaymentMethod(String loadingText) {
		waitForClickable(driver, UserCheckoutPageUI.CONTINUE_BUTTON_IN_PAYMENT_METHOD);
		clickToElement(driver, UserCheckoutPageUI.CONTINUE_BUTTON_IN_PAYMENT_METHOD);
		waitForElementInvisible(driver, UserCheckoutPageUI.WAIT_FOR_LOADING, loadingText);
	}

	public void clickToContinueButtonInPaymentInformation(String loadingText) {
		waitForClickable(driver, UserCheckoutPageUI.CONTINUE_BUTTON_IN_PAYMENT_INFORMATION);
		clickToElement(driver, UserCheckoutPageUI.CONTINUE_BUTTON_IN_PAYMENT_INFORMATION);
		waitForElementInvisible(driver, UserCheckoutPageUI.WAIT_FOR_LOADING, loadingText);
	}

	public void isAlertPresence(String loadingText) {
		try {
			waitForClickable(driver, UserCheckoutPageUI.CONFIRM_ORDER_BUTTON);
			clickToElement(driver, UserCheckoutPageUI.CONFIRM_ORDER_BUTTON);
			waitForElementInvisible(driver, UserCheckoutPageUI.WAIT_FOR_LOADING, loadingText);
		} catch (UnhandledAlertException f) {
			try {
				waitForAlertPresence(driver);
				String alertText = getAlertText(driver);
				System.out.println("Alert data: " + alertText);
				acceptAlert(driver);
			} catch (NoAlertPresentException e) {
				e.printStackTrace();
			}
		}
	}

	public void clickToConfirmOrderButton(String loadingText) {
		// try {
		waitForClickable(driver, UserCheckoutPageUI.CONFIRM_ORDER_BUTTON);
		clickToElement(driver, UserCheckoutPageUI.CONFIRM_ORDER_BUTTON);
		waitForElementInvisible(driver, UserCheckoutPageUI.WAIT_FOR_LOADING, loadingText);
		// } catch (UnhandledAlertException f) {
		// try {
		// waitForAlertPresence(driver);
		// String alertText = getAlertText(driver);
		// System.out.println("Alert data: " + alertText);
		// acceptAlert(driver);
		// } catch (NoAlertPresentException e) {
		// e.printStackTrace();
		// }
		// }
	}

	public UserShoppingCartPageObject clickToReorderButton() {
		waitForClickable(driver, UserCheckoutPageUI.REORDER_BUTTON);
		clickToElement(driver, UserCheckoutPageUI.REORDER_BUTTON);
		return PageGeneratorManager.getUserShoppingCartPage(driver);
	}
}
