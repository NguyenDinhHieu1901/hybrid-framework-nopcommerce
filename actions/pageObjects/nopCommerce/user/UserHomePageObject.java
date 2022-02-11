package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.user.UserHomePageUI;

/**
 * <h2>Page object model (POM) hay còn gọi là Page object pattern là 1 kiểu thiết kế dựa theo các hành vi (actions) và các thành phần (locator)
 * của các màn hình hiển thị (pages) để mà chia nhỏ các chức năng của 1 ứng dụng web thành các phần nhỏ hơn giúp cho việc dễ quản lý và dễ bảo
 * trì cũng như là mở rộng và linh hoạt hơn.</h2>
 * <br>
 * Nên nguyên tắc là: hành động nào và đối tượng nào sẽ tương ứng với page đó. Và để biết được có bao nhiêu page thì chúng ta phải nắm rõ
 * business/ flow của các testcase để mà thiết kế số lượng page cũng như là các hành động, locator trên page tương ứng.
 * 
 * Chúng ta sẽ sử dụng 1 kỹ thuật là viết mã giả ở trong class test rồi sau đó mới implement các hàm.
 * 
 * Các hàm của BasePage sẽ được dùng chung cho tầng pageObjects nên các class ở trong tầng này sẽ kế thừa class BasePage để sử dụng các hàm của nó.
 * @author Hieu Nguyen
 *
 */
public class UserHomePageObject extends BasePage {
	
	private WebDriver driver;
	
	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	@Step("Click to Register link")
	public UserRegisterPageObject clickToRegisterLink() {
		waitForClickable(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPage(driver);
	}
	
	@Step("Click to Login link")
	public UserLoginPageObject clickToLoginLink() {
		waitForClickable(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}
	
	@Step("Click to My Account link")
	public UserCustomerInfoPageObject clickToMyAccountLink() {
		waitForClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);
	}

	public String getTitleHomePage() {
		return getPageTitle(driver);
	}

	public void hoverToComputersMenu() {
		waitForElementVisible(driver, UserHomePageUI.COMPUTERS_MENU_LINK);
		hoverMouseToElement(driver, UserHomePageUI.COMPUTERS_MENU_LINK);
	}

	public void clickToSubmenuDesktopsLink() {
		waitForClickable(driver, UserHomePageUI.DESKTOPS_SUBMENU_LINK);
		clickToElement(driver, UserHomePageUI.DESKTOPS_SUBMENU_LINK);
	}
	
	@Step("Verify My Account Link is displayed")
	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplay(driver, UserHomePageUI.MY_ACCOUNT_LINK);
	}

}
