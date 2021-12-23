package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_07_For_ForEach {
	
	Scanner keyboard = new Scanner(System.in);
	
	@Test
	public void TC_01_Printing_n_Number() {
		System.out.print("Enter your number: ");
		int number = keyboard.nextInt();
		
		for (int i = 1; i <= number; i++) {
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println();
	}
	
	@Test
	public void TC_02_Printing_Number_From_A_To_B() {
		System.out.print("Enter the first number: ");
		int a = keyboard.nextInt();
		
		System.out.print("Enter the second number: ");
		int b = keyboard.nextInt();
		
		for (int i = a; i <= b; i++) {
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println();
	}
	
	@Test
	public void TC_03_Sum_Of_Even_Number() {
		
		int sum = 0;
		
		for (int i = 0; i <= 10; i++) {
			if (i % 2 == 0) {
				sum += i;
				
			}
		}
		
		System.out.println("Sum of even number from 0 to 10 is: " + sum);
	}
	
	@Test
	public void TC_04_Sum_From_A_To_B() {
		System.out.print("enter the first number: ");
		int a = keyboard.nextInt();
		
		System.out.print("enter the second number: ");
		int b = keyboard.nextInt();
		
		int sum = 0;
		
		for (int i = a; i <= b; i++) {
			sum += i;
		}
		System.out.println("the sum of number from a to b: " + sum);
	}
	
	@Test
	public void TC_05_Number_Module_3() {
		System.out.print("enter the first number: ");
		int a = keyboard.nextInt();
		
		System.out.print("enter the second number: ");
		int b = keyboard.nextInt();
		
		for (int i = a; i <= b; i++) {
			if (i % 3 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}
}
