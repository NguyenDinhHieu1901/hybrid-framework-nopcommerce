package javaOOP.knowledge;

public class Topic_02_Property {
	private String motorName;
	
	public void setMotorName(String motorName) {
		this.motorName = motorName;
	}
	
	public String getMotorName() {
		return motorName;
	}

	public static void main(String[] args) {
		
		// When objects are created from class, class's properties are into that object's properties
		Topic_02_Property motor = new Topic_02_Property();
		motor.setMotorName("Vespa");
		System.out.println(motor.getMotorName());
	}

}
