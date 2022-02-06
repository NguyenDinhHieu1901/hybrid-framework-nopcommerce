package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class HomePageObject extends BasePageFactory{
	
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//a[@class='ico-register']")
	private WebElement registerLink;
	
	@CacheLookup
	@FindBy(css = "a.ico-login")
	private WebElement loginLink;
	
	@CacheLookup
	@FindBy(xpath = "//a[@class='ico-account']")
	private WebElement myAccountLink;
	
	
	public void clickToRegisterLink() {
		waitForClickable(driver, registerLink);
		clickToElement(registerLink);
	}
	
	public void clickToLoginLink() {
		waitForClickable(driver, loginLink);
		clickToElement(loginLink);
	}
	
	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, myAccountLink);
		return isElementDisplay(myAccountLink);
	}
}
