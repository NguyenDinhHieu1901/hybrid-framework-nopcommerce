package javaOOP.encapsulation;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Topic_12_Encapsulation {
	private String carName;
	private String carType;
	private String carColor;
	private int carCC;
	
	private void engineV8() {
		System.out.println("This engine type is V8");
	}
	
	public void engine() {
		engineV8();
	}
}
