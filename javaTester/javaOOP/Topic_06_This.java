package javaOOP;

public class Topic_06_This {
	private String namePlayer;
	private int numberPlayer;
	
	public Topic_06_This(String namePlayer) {
		// this keyword is used to accessing to global variable has same name with local variable
		// and name of parameter in constructor is usually named the same with global variable to it take same mean with class
		this.namePlayer = namePlayer;
	}
	
	// Set private modifier for constructor to avoiding initalizing instances at other classes
	private Topic_06_This(int numberPlayer) {
		this.numberPlayer = numberPlayer;
	}
	
	public void clickToElement() {
		// this keyword here is presented as a class
		this.waitToElement();
		this.sendkeyToElement();
		System.out.println("Click To Element");
	}
	
	public void waitToElement() {
		System.out.println("Wait to element");
	}
	
	private void sendkeyToElement() {
		System.out.println("Sendkey To Element");
	}
	
	private void display(Topic_06_This obj) {
		System.out.println(obj.namePlayer);
		System.out.println(obj.numberPlayer);
	}
	
	// this keyword is passed as an argument in a method
	private void getDisplay() {
		display(this);
	}
	
	public static void main(String[] args) {
		Topic_06_This obj1 = new Topic_06_This(3);
		Topic_06_This obj2 = new Topic_06_This("Torres");
		
		System.out.println(obj1.numberPlayer);
		System.out.println(obj2.namePlayer);
		
		obj1.clickToElement();
		obj2.clickToElement();
		obj1.getDisplay();
		obj2.getDisplay();
	}
}
