package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;

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
public class HomePageObject extends BasePage {
	
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterLink() {
		waitForClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		
	}

	public void clickToLoginLink() {
		waitForClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		
	}

	public void clickToMyAccountLink() {
		waitForClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		
	}

	public String getTitleHomePage() {
		return getPageTitle(driver);
	}

	public void hoverToComputersMenu() {
		waitForElementVisible(driver, HomePageUI.COMPUTERS_MENU_LINK);
		hoverMouseToElement(driver, HomePageUI.COMPUTERS_MENU_LINK);
	}

	public void clickToSubmenuDesktopsLink() {
		waitForClickable(driver, HomePageUI.DESKTOPS_SUBMENU_LINK);
		clickToElement(driver, HomePageUI.DESKTOPS_SUBMENU_LINK);
	}

}
