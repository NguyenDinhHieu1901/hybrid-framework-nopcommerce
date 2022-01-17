package javaException.java;

public class Topic_15_NumberFormatException {
	
	public static void main(String[] args) {
		String number10 = "10";
		int ten = Integer.parseInt(number10);
		System.out.println(ten);
		
		String numberNine = "9.9";
		float nine = Float.parseFloat(numberNine);
		System.out.println(nine);
		
		String name = "Testing";
		int number = Integer.parseInt(name);
		System.out.println(number);
	}
}
