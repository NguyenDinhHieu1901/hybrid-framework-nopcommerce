package javaOOP.polymorphism;

public class Polymorphism_Overriding_Tiger extends Polymorphism_Overriding_Animal {
	protected void run() {
		System.out.println("Tiger is running....");
	}

	protected void eat() {
		System.out.println("Tiger is eating....");
	}

	protected void hunt() {
		System.out.println("Tiger is hunting....");
	}
}
