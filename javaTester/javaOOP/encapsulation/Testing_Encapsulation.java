package javaOOP.encapsulation;

public class Testing_Encapsulation {
	
	public static void main(String[] args) {
		Topic_12_Encapsulation obj = new Topic_12_Encapsulation();
		obj.setCarName("Honda");
		obj.setCarType("Sport Car");
		obj.setCarColor("Orange");
		obj.setCarCC(300);
		
		System.out.println(obj.getCarName());
		System.out.println(obj.getCarType());
		System.out.println(obj.getCarColor());
		System.out.println(obj.getCarCC());
		obj.engine();
	}

}
