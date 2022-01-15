package javaOOP.polymorphism;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Topic_13_Polymorphism_Overloading {
	private int firstNumber;
	private int secondNumber;
	
	public void sum() {
		setFirstNumber(10);
		setSecondNumber(20);
		System.out.println(getFirstNumber() + getSecondNumber());
	}
	
	public void sum(int a, int b) {
		System.out.println(a + b);
	}
	
	public void sum(long a, long b) {
		System.out.println(a + b);
	}
	
	public void sum(float a, float b) {
		System.out.println(a + b);
	}
	
	public void sum(double a, double b) {
		System.out.println(a + b);
	}
	
	public void sum(int a, float b) {
		System.out.println(a + b);
	}
	
	public static void main(String[] args) {
		Topic_13_Polymorphism_Overloading obj = new Topic_13_Polymorphism_Overloading();
		obj.sum();
		obj.sum(100, 200);
		obj.sum(56.6d, 55.4d);
		obj.sum(1000l, 2000l);
		obj.sum(2.5f, 1.5f);
	}
	
}
