package javaOOP.overriding;

public class Topic_10_Overriding_Car extends Topic_10_Overriding_Vehicle {
	
	@Override
	public void engine() {
		System.out.println("This car has a V8 engine");
	}
	
	@Override
	public void brake() {
		System.out.println("Car's brake is used ABS type");
	}
	
	public void fuel() {
		System.out.println("Car's fuel is petrol");
	}
}
