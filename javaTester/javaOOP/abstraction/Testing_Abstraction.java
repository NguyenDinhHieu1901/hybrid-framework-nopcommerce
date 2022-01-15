package javaOOP.abstraction;

public class Testing_Abstraction {
	
	public static void main(String[] args) {
		Topic_14_Bird bird = new Topic_14_Bird();
		Topic_14_Cat cat = new Topic_14_Cat();
		Topic_14_Fish fish = new Topic_14_Fish();
		Topic_14_Dragon dragon = new Topic_14_Dragon();
		
		bird.eat();
		bird.drink();
		bird.sleep();
		bird.fly();
		
		cat.eat();
		cat.drink();
		cat.sleep();
		cat.run();
		
		fish.eat();
		fish.drink();
		fish.sleep();
		fish.swim();
		
		dragon.eat();
		dragon.drink();
		dragon.sleep();
		dragon.fly();
		dragon.swim();
		dragon.run();
	}

}
