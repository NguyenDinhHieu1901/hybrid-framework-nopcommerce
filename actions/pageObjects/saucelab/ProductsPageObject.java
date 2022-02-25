package pageObjects.saucelab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.saucelab.ProductsPageUI;

public class ProductsPageObject extends BasePage {
	private WebDriver driver;

	public ProductsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectSortInDefaultDropdownByText(String textValue) {
		waitForClickable(driver, ProductsPageUI.SORT_DROPDOWN);
		selectItemInDefaultDropdown(driver, ProductsPageUI.SORT_DROPDOWN, textValue);
	}

	public boolean isProductNameSortAscending() {
		List<String> productNames = getAllElementText(driver, ProductsPageUI.NAME_PRODUCTS);

		System.out.println("Before sort Ascending: --------------------");
		for (String product : productNames) {
			System.out.println(product);
		}

		List<String> sortProductNames = new ArrayList<String>(productNames);
		Collections.sort(sortProductNames);

		System.out.println("After sort Ascending: --------------------");
		for (String product : sortProductNames) {
			System.out.println(product);
		}

		return sortProductNames.equals(productNames);
	}

	public boolean isProductNameSortDescending() {
		List<String> productNames = getAllElementText(driver, ProductsPageUI.NAME_PRODUCTS);

		System.out.println("Before sort Descending: --------------------");
		for (String product : productNames) {
			System.out.println(product);
		}

		List<String> sortProductNames = new ArrayList<String>(productNames);
		Collections.sort(sortProductNames);
		Collections.reverse(sortProductNames);

		System.out.println("After sort Descending: --------------------");
		for (String product : sortProductNames) {
			System.out.println(product);
		}

		return sortProductNames.equals(productNames);
	}

	public boolean isProductPriceSortHighToLow() {
		List<String> productPrices = getAllElementText(driver, ProductsPageUI.PRICE_PRODUCTS);

		List<Float> productPricesFloat = new ArrayList<Float>();
		for (String price : productPrices) {
			productPricesFloat.add(Float.parseFloat(price.replace("$", "")));
		}

		System.out.println("Before sort high to low: --------------------");
		for (Float product : productPricesFloat) {
			System.out.println(product);
		}

		List<Float> sortProductPrices = new ArrayList<Float>(productPricesFloat);
		Collections.sort(sortProductPrices);
		Collections.reverse(sortProductPrices);

		System.out.println("After sort high to low: --------------------");
		for (Float product : sortProductPrices) {
			System.out.println(product);
		}

		return productPricesFloat.equals(sortProductPrices);
	}

	public boolean isProductPriceSortLowToHigh() {
		List<String> productPrices = getAllElementText(driver, ProductsPageUI.PRICE_PRODUCTS);

		List<Float> productPricesFloat = new ArrayList<Float>();
		for (String price : productPrices) {
			productPricesFloat.add(Float.parseFloat(price.replace("$", "")));
		}

		System.out.println("Before sort low to high: --------------------");
		for (String product : productPrices) {
			System.out.println(product);
		}

		List<Float> sortProductPrices = new ArrayList<Float>(productPricesFloat);
		Collections.sort(sortProductPrices);

		System.out.println("After sort low to high: --------------------");
		for (Float product : sortProductPrices) {
			System.out.println(product);
		}

		return productPricesFloat.equals(sortProductPrices);
	}
}
