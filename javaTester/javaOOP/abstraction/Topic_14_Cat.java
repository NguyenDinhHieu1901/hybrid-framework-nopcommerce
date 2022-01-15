package javaOOP.abstraction;

public class Topic_14_Cat extends Animal implements IRunable {

	@Override
	public void run() {
		System.out.println("Cat is running...");
	}

}
