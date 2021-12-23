package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_05_If_Else_Statement {

	Scanner keyboard = new Scanner(System.in);

	@Test
	public void TC_01_Printing_Number_Odd_Or_Even() {

		System.out.print("Please enter your number: ");
		int number = keyboard.nextInt();

		if (number % 2 == 0) {
			System.out.println(number + " is an even number");
		} else {
			System.out.println(number + " is an odd number");
		}

	}

	@Test
	public void TC_02_Compare_Two_Number() {
		System.out.print("Please enter the first number: ");
		int number1 = keyboard.nextInt();

		System.out.print("Please enter the second number: ");
		int number2 = keyboard.nextInt();

		if (number1 > number2) {
			System.out.println(number1 + " is greater than " + number2);
		} else if (number1 == number2) {
			System.out.println(number1 + " is equal " + number2);
		} else {
			System.out.println(number1 + " is smaller than " + number2);

		}
	}

	@Test
	public void TC_03_Checking_The_Same_Name() {
		System.out.print("Please enter the first name: ");
		String name1 = keyboard.nextLine();

		System.out.print("Please enter the second name: ");
		String name2 = keyboard.nextLine();

		if (!name1.equals(name2)) {
			System.out.println(name1 + " is different with " + name2);
		} else {
			System.out.println(name1 + " is same with " + name2);
		}
	}

	@Test
	public void TC_04_Finding_Max_Number() {
		System.out.print("Please enter the first number: ");
		int number1 = keyboard.nextInt();

		System.out.print("Please enter the second number: ");
		int number2 = keyboard.nextInt();

		System.out.print("Please enter the third number: ");
		int number3 = keyboard.nextInt();

		if (number1 > number2 && number1 > number3) {
			System.out.println(number1 + " is the max number in number list");

		} else if (number1 > number2 && number1 < number3) {

			System.out.println(number3 + " is the max number in number list");

		} else {

			System.out.println(number2 + " is the max number in number list");

		}
	}

	@Test
	public void TC_05_Number_Entered_In_Range() {
		System.out.print("Please enter your number: ");
		int number = keyboard.nextInt();

		if (number >= 10 && number <= 100) {
			System.out.println(number + " is in range 10-100");
		} else {
			System.out.println(number + " is not in range 10-100");
		}
	}

	@Test
	public void TC_06_Convert_Number_Score_To_Character_Score() {
		System.out.print("Please enter your score: ");
		float score = keyboard.nextFloat();

		char characterScore = 'F';

		if (score > 0 && score < 5) {
			characterScore = 'D';

		} else if (score >= 5 && score < 7.5) {
			characterScore = 'C';
		} else if (score >= 7.5 && score < 8.5) {
			characterScore = 'B';
		} else if (score >= 8.5 && score <= 10) {
			characterScore = 'A';
		} else {
			System.out.println("Your score invalid!");
		}

		System.out.println("Your score in character score is: " + characterScore);
	}

	@Test
	public void TC_07_Display_Day_Number_Of_A_Month() {
		System.out.print("What month do you like see? ");
		int month = keyboard.nextInt();

		if (month == 4 || month == 6 || month == 9 || month == 11) {
			System.out.println("Month " + month + " have 30 days.");
		} else if (month == 2) {
			System.out.println("Month " + month + " have 28 or 29 days.");
		} else {
			System.out.println("Month " + month + " have 31 days.");
		}
	}
}
