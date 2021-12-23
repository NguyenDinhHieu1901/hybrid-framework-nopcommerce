package javaBasic;

import org.testng.annotations.Test;

public class Topic_02_DataType {
	
	@Test
	public void TC_01_() {
		int a = 6;
		int b = 2;
		System.out.println("a + b = " + (a+b));
		System.out.println("a - b = " + (a-b));
		System.out.println("a * b = " + (a*b));
		System.out.println("a / b = " + (a/b));
	}
	
	@Test
	public void TC_02() {
		float length = 7.5f;
		float width = 3.8f;
		
		System.out.println("Area = " + length * width);
	}
	
	@Test
	public void TC_03() {
		String name = "Automation Testing";
		System.out.println("Hello " + name);
	}
}
