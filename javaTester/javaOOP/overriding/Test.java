package javaOOP.overriding;

public class Test {

	public static void main(String[] args) {
//		Topic_10_Overriding_Airplane airplane = new Topic_10_Overriding_Airplane();
//		Topic_10_Overriding_Car car = new Topic_10_Overriding_Car();
//		Topic_10_Overriding_Vehicle vehicle = new Topic_10_Overriding_Vehicle();
//		
//		vehicle.engine();
//		vehicle.brake();
//		vehicle.fuel();
//		
//		airplane.engine();
//		airplane.brake();
//		airplane.fuel();
//		
//		car.engine();
//		car.brake();
//		car.fuel();
		
		Chihuahua chihuahua = new Chihuahua();
		Bulk bulk = new Bulk();
		Husky husky = new Husky();
		
		chihuahua.run();
		chihuahua.bark();
		chihuahua.eat();
		chihuahua.drink();
		chihuahua.jumping();
		
		bulk.run();
		bulk.bark();
		bulk.eat();
		bulk.drink();
		bulk.hunting();
		
		husky.run();
		husky.bark();
		husky.eat();
		husky.drink();
		husky.fur();
	}

}
