package pageUIs.jQuery;

public class HomePageUI {
	public static final String PAGING_BY_NUMBER = "xpath=//a[@class='qgrd-pagination-page-link' and  text()='%s']";
	public static final String PAGE_NUMBER_ACTIVED = "xpath=//a[@class='qgrd-pagination-page-link active']";
	public static final String HEADER_TEXTBOX_BY_NAME = "xpath=//div[text()='%s']/parent::div/following-sibling::input";
	public static final String ICON_BY_COUNTRY_NAME = "xpath=//td[@data-key='country' and text()='%s']/preceding-sibling::td[@class]/button[contains(@class,'%s')]";
	public static final String ROW_VALUE_BY_FEMALE_COUNTRY_MALE_TOTAL = "xpath=//td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='males' and text()='%s']/following-sibling::td[@data-key='total' and text()='%s']";
	public static final String CELL_VALUE_BY_ROW_COLUMN_INDEX = "xpath=//tr[@id][%s]//td[%s]//input";
	public static final String HEADER_NAME_INDEX = "xpath=//td[text()='%s']/preceding-sibling::td";
	public static final String APPEND_ROW = "xpath=//button[@title='Append Row']";
	public static final String ICON_BY_ROW_NUMBER = "xpath=//tr[@id][%s]//button[@title='%s']";
}
