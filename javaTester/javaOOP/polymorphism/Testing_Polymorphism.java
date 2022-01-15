package javaOOP.polymorphism;

public class Testing_Polymorphism {
	
	public static void main(String[] args) {
		Polymorphism_Overriding_Animal animal = new Polymorphism_Overriding_Animal();
		animal.run();
		animal.eat();
		animal.hunt();
		
		animal = new Polymorphism_Overriding_Jaguar();
		animal.run();
		animal.eat();
		animal.hunt();
		
		animal = new Polymorphism_Overriding_Lyon();
		animal.run();
		animal.eat();
		animal.hunt();
		
		animal = new Polymorphism_Overriding_Tiger();
		animal.run();
		animal.eat();
		animal.hunt();
	}

}
