package javaOOP;

public class Topic_07_Super_Child_Constructor extends Topic_07_Super_Parent_Constructor {
	private String carName;
	private String carColor;
	private int carNumber;
	
	public Topic_07_Super_Child_Constructor() {
		super("Mercedes Benz");
		System.out.println("child");
	}
	
	private void setInfoParent() {
		// Direct invoked to property of parent class 
		super.carName = "Porches";
		super.carColor = "Red";
		super.carNumber = 3;
	}
	
	private void setInfoChild() {
		carName = "BMW";
		carColor = "White";
		carNumber = 2;
	}
	
	private void displayChildClass() {
		System.out.println(carName);
		System.out.println(carColor);
		System.out.println(carNumber);
	}
	private void displayInfo() {
		setInfoChild();
		setInfoParent();
		
		// Direct invoked to method of parent class
		super.displayParentClass();
		displayChildClass();
	}
	
	public static void main(String[] args) {
		Topic_07_Super_Child_Constructor obj = new Topic_07_Super_Child_Constructor();
		System.out.println("Child class: " + obj.carName);
		System.out.println("Child class: " + obj.carColor);
		System.out.println("Child class: " + obj.carNumber);
		System.out.println("--------------");
		
		obj.displayInfo();
	
	}

}
