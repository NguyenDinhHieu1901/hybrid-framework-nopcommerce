package javaOOP.polymorphism;

public class Polymorphism_Overriding_Jaguar extends Polymorphism_Overriding_Animal {
	protected void run() {
		System.out.println("Jaguar is running....");
	}

	protected void eat() {
		System.out.println("Jaguar is eating....");
	}

	protected void hunt() {
		System.out.println("Jaguar is hunting....");
	}
}
