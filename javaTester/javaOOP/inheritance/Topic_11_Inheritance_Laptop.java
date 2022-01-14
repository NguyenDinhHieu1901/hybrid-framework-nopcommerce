package javaOOP.inheritance;

public class Topic_11_Inheritance_Laptop extends Topic_11_Inheritance_PC {
	
	public void showInfo() {
		showCPU();
		showOS();
	}
	
	public void flexible() {
		System.out.println("Laptop can move anywhere");
	}
	
	public static void main(String[] args) {
		Topic_11_Inheritance_Laptop laptop = new Topic_11_Inheritance_Laptop();
		laptop.showInfo();
		laptop.flexible();
		laptop.performance();
	}
}
