package regex;

public class replace {
	public static void main(String[] args) {
		String amount = "(0)";
		System.out.println("after replace: " + amount.replaceAll("[()]", ""));
		
	}
}
