package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_03_Operator {

	Scanner scan = new Scanner(System.in);

	@Test
	public void TC_01() {
		System.out.print("Please enter your name: ");
		String name = scan.nextLine();

		System.out.print("Please enter your age: ");
		int age = scan.nextInt();
		System.out.println("After 15 years, age of " + name + " will be " + (age + 15));
	}

	@Test
	public void TC_02_Swapping_Variable() {
		int a = 3;
		int b = 4;

		System.out.println("a = " + a);
		System.out.println("b = " + b);

		a = a + b;
		b = a - b;
		a = a - b;

		System.out.println("a = " + a);
		System.out.println("b = " + b);
	}

	@Test
	public void TC_03() {
		System.out.print("Please enter first number: ");
		int firstNumber = scan.nextInt();

		System.out.print("Please enter second number: ");
		int secondNumber = scan.nextInt();

		boolean result = (firstNumber > secondNumber) ? true : false;
		System.out.println("Result: " + result);
		
		String re = (firstNumber > secondNumber) ? "first number greater than second number" : "Oppose";
		
		System.out.println(re);
	}
}
