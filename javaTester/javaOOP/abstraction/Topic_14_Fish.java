package javaOOP.abstraction;

public class Topic_14_Fish extends Animal implements ISwimable {

	@Override
	public void swim() {
		System.out.println("Fish is swimming...");
	}

}
