package javaOOP.inheritance;

public class Topic_11_Inheritance_PC extends Topic_11_Inheritance_Computer {

	public void showInfo() {
		showCPU();
		showOS();
	}
	
	public void performance() {
		System.out.println("Personal computer has better performance!");
	}

	public static void main(String[] args) {
		Topic_11_Inheritance_PC pc = new Topic_11_Inheritance_PC();
		pc.showInfo();
		pc.performance();
	}

}
