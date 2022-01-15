package javaOOP.abstraction;

public class Topic_14_Dragon extends Animal implements IRunable, ISwimable, IFlyable {

	@Override
	public void fly() {
		System.out.println("Dragon is flying...");
	}

	@Override
	public void swim() {
		System.out.println("Dragon is swimming...");
	}

	@Override
	public void run() {
		System.out.println("Dragon is running...");
	}

}
