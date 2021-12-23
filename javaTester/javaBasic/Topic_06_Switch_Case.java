package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_06_Switch_Case {
	
	Scanner keyboard = new Scanner(System.in);
	
	@Test
	public void TC_01_Conver_Number_To_Text_English() {
		System.out.print("What number do you wanna convert: ");
		int number = keyboard.nextInt();
		
		switch (number) {
		case 1:
			System.out.println("One");
			break;
		case 2:
			System.out.println("Two");
			break;
		case 3:
			System.out.println("Three");
			break;
		case 4:
			System.out.println("Four");
			break;
		case 5:
			System.out.println("Five");
			break;
		case 6:
			System.out.println("Six");
			break;
		case 7:
			System.out.println("Seven");
			break;
		case 8:
			System.out.println("Eight");
			break;
		case 9:
			System.out.println("Nine");
			break;
		case 10:
			System.out.println("Ten");
			break;

		default:
			System.out.println("Number invalid!");
			break;
		}
	}
	
	@Test
	public void TC_02_Calculate_Two_Number() {
		System.out.print("Enter the first number: ");
		float number1 = keyboard.nextFloat();
		
		System.out.print("Enter the second number: ");
		float number2 = keyboard.nextFloat();
		
		System.out.print("Enter operator: ");
		char operator = keyboard.next().charAt(0);
		
		switch (operator) {
		case '+':
			System.out.println("A + B = " + (number1 + number2));
			break;
		case '-':
			System.out.println("A - B = " + (number1 - number2));
			break;
		case '*':
			System.out.println("A * B = " + (number1 * number2));
			break;
		case '/':
			System.out.println("A / B = " + (number1 / number2));
			break;
		case '%':
			System.out.println("A % B = " + (number1 % number2));
			break;

		default:
			System.out.println("Operator invalid!");
			break;
		}
	}

	@Test
	public void TC_03_Display_Day_Numner_In_A_Month() {
		System.out.print("What month do you like to see: ");
		String month = keyboard.nextLine();
		
		switch (month) {
		case "january":
		case "march":
		case "may":
		case "july":
		case "august":
		case "october":
		case "december":
			System.out.println("Month " + month + " have 31 days!");
			break;
		
		case "february":
			System.out.println("Month " + month + " have 28 or 29 days!");
			break;
		case "april":
		case "june":
		case "september":
		case "november":
			System.out.println("Month " + month + " have 30 days!");
			break;
		default:
			System.out.println("Input invalid!");
			break;
		}
	}
}

