package javaOOP;

public class Topic_04_Non_Access_Modifier {

	// static variable is used to access wide range and often access through class
	public static String motorBrand;
	protected static String motorName;

	// static method
	static void showMotorInfo() {
		System.out.println(motorBrand);
		System.out.println(motorName);
	}

	// final variable is used to unchanged value
	public final int tireNumber = 2;

	// final method is used to avoiding overriding method
	final void showTireNumber() {
		System.out.println(tireNumber);
	}
	
	// final class is used to avoiding other classes inheritance it but allowing init it 
	final class This_Is_Final_Class {

	}

	// static final variable is used to create a constant
	public static final String FUEL_TYPE = "petrol";
}
