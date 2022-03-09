package javaOOP.knowledge;

public class Topic_07_Super_Parent_Constructor {
	protected String carName;
	protected String carColor;
	protected int carNumber;
	
	protected Topic_07_Super_Parent_Constructor() {
		System.out.println("Parent 1");
	}
	
	protected Topic_07_Super_Parent_Constructor(int number) {
		System.out.println("Parent 1 " + number);
	}
	
	protected Topic_07_Super_Parent_Constructor(String name) {
		System.out.println("Parent 1 " + name);
	}
	
	// avoiding initializing instance/ object at other classes
	private Topic_07_Super_Parent_Constructor(int number, String name) {
		System.out.println("Parent 1 " + number + " " + name);
	}
	
	protected void displayParentClass() {
		System.out.println(carName);
		System.out.println(carColor);
		System.out.println(carNumber);
	}
}
