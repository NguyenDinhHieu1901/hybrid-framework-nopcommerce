package handledatepicker;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.openqa.selenium.WebElement;

public class DateUtil {
	// Get current today
	public static String getCurrentDay() {
		// Create a calendar object
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

		// Get current today as a number
		int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println("Today int: " + todayInt);

		// Convert from Integer to String
		String todayStr = String.valueOf(todayInt);
		System.out.println("Today String: " + todayStr);

		return todayStr;
	}

	// Get the current day plus days
	public static String getCurrentDayPlus(int days) {
		int currentDate = Integer.parseInt(getCurrentDay());
		int dayPlus = currentDate + days;
		String datePlus = Integer.toString(dayPlus);
		System.out.println("Day plus: " + datePlus);
		return datePlus;
	}

	// Click to given day
	public static void clickGivenDay(List<WebElement> elementList, String day) {
		// DatePicker is a table. Thus we can navigate to each cell
		// and if a cell matches with the current date then we will click it.
		elementList.stream().filter(element -> element.getText().contains(day)).findFirst().ifPresent(WebElement::click);

		/** Non-functional JAVA version of this method. */
		// for (
		// WebElement cell : elementList) {
		// String cellText = cell.getText();
		// if (cellText.contains(day)) {
		// cell.click();
		// break;
		// }
		// }
	}
}
