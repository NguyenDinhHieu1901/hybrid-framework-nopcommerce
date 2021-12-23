package javaBasic;

public class Topic_04_Casting_Type {
	
	String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		
		this.name = name;
	}
	
	public void displayName() {
		System.out.println("Employee: " + name);
	}
	
	public static void main(String[] args) {
		
		Topic_04_Casting_Type employee1 = new Topic_04_Casting_Type();
		Topic_04_Casting_Type employee2 = new Topic_04_Casting_Type();
		
		employee1.setName("El Nino");
		employee2.setName("Ring Lord");
		
		System.out.println("Before casting object: ");
		employee1.displayName();
		employee2.displayName();
		
		employee2 = employee1;
		
		System.out.println("After casting object: ");
		employee1.displayName();
		employee2.displayName();
		
		employee2.setName("Harry Potter");
		
		employee1.displayName();
		employee2.displayName();
		
	}

}
