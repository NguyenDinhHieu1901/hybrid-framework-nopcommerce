package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_08_while_doWhile {
	
	Scanner keyboard = new Scanner(System.in);
	
	@Test
	public void TC_01_Printing_Even_Number() {
		
		System.out.print("enter your number: ");
		int number = keyboard.nextInt();
		
		while(number <= 100) {
			if (number % 2 == 0) {
				System.out.print(number + " ");
			}
			number++;
		}
		System.out.println();
	}
	
	@Test
	public void TC_02_Number_Module_3_And_5() {
		System.out.print("Enter the first number: ");
		int a = keyboard.nextInt();
		
		System.out.print("Enter the second number: ");
		int b = keyboard.nextInt();
		
		while (a <= b) {
			if (a % 3 == 0 && a % 5 == 0) {
				System.out.print(a + " ");
			}
			a++;
		}
		System.out.println();
	}
	
	@Test
	public void TC_03_Recursion() {
		
		System.out.print("what number do you wanna calculate: ");
		int number = keyboard.nextInt();
		
		int temp = 1;
		int total = 1;
		
		while (temp <= number) {
			total *= temp;
			temp++;
		}
		System.out.println(number + "! = " + total);
	}
}
