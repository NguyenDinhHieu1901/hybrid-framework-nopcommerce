package regex;

public class as {
	public static void main(String[] args) {
		String priceString = "$1,500.00";
		Float price = Float.valueOf(priceString.replaceAll("[$,]", ""));
		System.out.println(price);
		
		String test = "Order number: 1033";
		System.out.println(test.split(": ")[1]);
	}		
}
