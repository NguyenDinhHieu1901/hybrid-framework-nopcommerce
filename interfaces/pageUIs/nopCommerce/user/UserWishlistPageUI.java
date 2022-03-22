package pageUIs.nopCommerce.user;

public class UserWishlistPageUI {
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//table[@class='cart']//thead//th[string()='%s']//preceding-sibling::th";
	public static final String DATA_TABLE_BY_COLUMN_NAME_AND_ROW_INDEX = "xpath=//table[@class='cart']/tbody/tr[%s]/td[%s]";
	public static final String ADD_TO_CART_CHECKBOX = "xpath=//table[@class='cart']//tbody/tr[%s]/td[@class='add-to-cart']/input";
	public static final String REMOVE_BUTTON = "xpath=//table[@class='cart']/tbody/tr[%s]/td[@class='remove-from-cart']/button";
	public static final String EMPTY_MESSAGE = "xpath=//div[@class='page wishlist-page']//div[contains(text(),'%s')]";
}
