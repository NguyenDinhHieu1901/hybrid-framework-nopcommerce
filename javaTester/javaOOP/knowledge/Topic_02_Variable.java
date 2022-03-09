package javaOOP.knowledge;

public class Topic_02_Variable {
	
	// Non-Static Global variable
	public String name = "Torres";
	protected String type = "Right";
	String hobby = "Football";
	private String position = "Forward";
	
	
	// Static Global variable
	public static int yearOfBirth = 1985;
	protected static int monthOfBirth = 12;
	static int dateOfBirth = 12;
	private static int performance = 96;
	
	public static void main(String[] args) {
		
		// Local variable
		String gender = "male";
		System.out.println(gender);
		
		// Init through Non-Static variable
		Topic_02_Variable  obj = new Topic_02_Variable();
		System.out.println(obj.name);
		System.out.println(obj.type);
		System.out.println(obj.hobby);
		System.out.println(obj.position);
		
		// Init through Static variabke
		System.out.println(yearOfBirth);
		System.out.println(monthOfBirth);
		System.out.println(Topic_02_Variable.dateOfBirth);
		System.out.println(Topic_02_Variable.performance);
	}

}
