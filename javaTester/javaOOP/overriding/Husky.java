package javaOOP.overriding;

public class Husky implements IDog {

	@Override
	public void run() {
		System.out.println("Husky is running...");
	}

	@Override
	public void bark() {
		System.out.println("Husky is barking when she meet stranger!");
	}

	@Override
	public void eat() {
		System.out.println("Husky's favorite food is beef");
	}

	@Override
	public void drink() {
		System.out.println("Husky is drinking mineral water...");
	}

	public void fur() {
		System.out.println("Husky's fur is very thick!");
	}
}
