package javaOOP.overriding;

public class Bulk implements IDog {

	@Override
	public void run() {
		System.out.println("Bulk is running...");
	}

	@Override
	public void bark() {
		System.out.println("Bulk is barking when she meet stranger and grab that!");
	}

	@Override
	public void eat() {
		System.out.println("Bulk's favorite food is salmon");
	}

	@Override
	public void drink() {
		System.out.println("Bulk is drinking mineral water...");
	}

	public void hunting() {
		System.out.println("Bulk can hunt enemy");
	}
}
