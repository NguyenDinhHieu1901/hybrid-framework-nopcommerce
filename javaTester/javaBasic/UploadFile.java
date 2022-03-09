package javaBasic;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFile {
	private WebDriver driver;
	private String england, france, germany, japan, taiwan;

	@BeforeClass
	public void preCondition() {
		WebDriverManager.firefoxdriver().setup();;
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");

		england = "England.jpg";
		france = "France.jpg";
		germany = "Germany.jpg";
		japan = "Japan.jpg";
		taiwan = "Taiwan.jpg";
	}

	@Test
	public void TC_01() throws InterruptedException  {
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(uploadMultipleFiles(england, france, germany, japan, taiwan));
		Thread.sleep(5000);
	}

	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}

	String uploadMultipleFiles(String... fileNames) {
		String rootUploadFiles = GlobalConstants.UPLOAD_FILE_FOLDER;
		String fullnameFiles = "";
		for (String fileName : fileNames) {
			fullnameFiles += rootUploadFiles + File.separator + fileName + File.separator + "\n";
		}
		return fullnameFiles.trim();
	}
}
