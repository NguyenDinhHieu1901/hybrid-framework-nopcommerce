//package com.nopcommerce.user;
//
//import java.lang.reflect.Method;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import com.relevantcodes.extentreports.LogStatus;
//
//import commons.BaseTest;
//import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
//import pageObjects.nopCommerce.user.UserHomePageObject;
//import pageObjects.nopCommerce.user.UserLoginPageObject;
//import pageObjects.nopCommerce.user.PageGeneratorManager;
//import pageObjects.nopCommerce.user.UserRegisterPageObject;
//import reportConfig.ExtentTestManager;
//
//public class Level_14_Log_Extent_Report_V2 extends BaseTest {
//
//	@Parameters("browser")
//	@BeforeClass
//	public void beforeClass(String browserName) {
//		driver = getBrowserDriver(browserName);
//		homePageObject = PageGeneratorManager.getUserHomePage(driver);
//
//		firstName = "nguyen";
//		lastName = "test";
//		emailAddress = firstName + lastName + generatorNumberRandom() + "@mail.net";
//		password = "123456";
//	}
//
//	@Test
//	public void User_01_Register_To_System(Method method) {
//		ExtentTestManager.startTest(method.getName(), "User_01_Register_To_System");
//		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 01: Click to 'Register' link");
//		registerPageObject = homePageObject.clickToRegisterLink();
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 02: Input to all of mandatory fields in 'Register' form");
//		registerPageObject.registerAsUser(firstName, lastName, emailAddress, password);
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 03: Verify 'Register Success Message' is displayed");
//		verifyEquals(registerPageObject.getRegisterSuccessMessage(), "Your registration completed");
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "User_01_Register - Step 04: Click to 'Logout' link");
//		homePageObject = registerPageObject.clickToLogoutLinkAtUser(driver);
//
//		ExtentTestManager.endTest();
//	}
//
//	@Test
//	public void User_02_Login(Method method) {
//		ExtentTestManager.startTest(method.getName(), "User_02_Login");
//		ExtentTestManager.getTest().log(LogStatus.INFO, "User_02-Login - Step 01: Click to 'Login' link");
//		loginPageObject = homePageObject.clickToLoginLink();
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "User_02-Login - Step 02: input to Email Address and Password in 'Login' form with value: " + emailAddress + " " + password);
//		homePageObject = loginPageObject.loginAsUser(emailAddress, password);
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "User_02-Login - Step 03: Verify 'My Account Link' is displayed");
//		verifyTrue(homePageObject.isMyAccountLinkDisplayed());
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "User_02-Login - Step 04: Click to 'My Account' link");
//		customerInfoPageObject = homePageObject.clickToMyAccountLink();
//
//		ExtentTestManager.getTest().log(LogStatus.INFO, "User_02-Login - Step 05: Verify 'News Letter Checkbox' is selected");
//		verifyFalse(customerInfoPageObject.isNewsletterCheckboxSelected());
//		ExtentTestManager.endTest();
//	}
//
//	@AfterClass
//	public void afterClass() {
//		driver.quit();
//	}
//
//	private WebDriver driver;
//	private String emailAddress, password, firstName, lastName;
//	private UserHomePageObject homePageObject;
//	private UserRegisterPageObject registerPageObject;
//	private UserLoginPageObject loginPageObject;
//	private UserCustomerInfoPageObject customerInfoPageObject;
//}
