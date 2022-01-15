package javaOOP.abstraction;

public class Topic_14_Bird extends Animal implements IFlyable {

	@Override
	public void fly() {
		System.out.println("Bird is flying...");
	}

}
