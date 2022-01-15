package javaOOP.polymorphism;

public class Polymorphism_Overriding_Lyon extends Polymorphism_Overriding_Animal {
	protected void run() {
		System.out.println("Lyon is running....");
	}

	protected void eat() {
		System.out.println("Lyon is eating....");
	}

	protected void hunt() {
		System.out.println("Lyon is hunting....");
	}
}
