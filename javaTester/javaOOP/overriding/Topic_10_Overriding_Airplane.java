package javaOOP.overriding;

public class Topic_10_Overriding_Airplane extends Topic_10_Overriding_Vehicle {
	@Override
	public void engine() {
		System.out.println("This airplane uses Jet engine");
	}

	public void brake() {
		System.out.println("Airplane's brake is Aircraft disc used to brake the wheels!");
	}

	public void fuel() {
		System.out.println("Airplane's fuel is diesel");
	}

}
