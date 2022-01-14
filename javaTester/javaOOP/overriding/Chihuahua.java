package javaOOP.overriding;

public class Chihuahua implements IDog {

	@Override
	public void run() {
		System.out.println("Chihuahua is running...");
	}

	@Override
	public void bark() {
		System.out.println("Chihuahua is barking when she meet stranger!");
	}

	@Override
	public void eat() {
		System.out.println("Chihuahua's favorite food is fish");
	}

	@Override
	public void drink() {
		System.out.println("Chihuahua is drinking mineral water...");
	}

	public void jumping() {
		System.out.println("Chihuahua jumps very high!");
	}
}
