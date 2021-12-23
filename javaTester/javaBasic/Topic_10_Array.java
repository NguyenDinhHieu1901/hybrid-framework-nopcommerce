package javaBasic;

import org.testng.annotations.Test;

public class Topic_10_Array {

	int ID, age, score;
	String name;

	public Topic_10_Array(String name, int ID, int age, int score) {
		this.ID = ID;
		this.age = age;
		this.score = score;
		this.name = name;
	}


//	@Test
	public void TC_01_Finding_Max_Element_In_Array() {

		int[] arr = { 2, 7, 8, 6, 9, 100, 101 };

		int maxNumber = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > maxNumber) {
				maxNumber = arr[i];
			}
		}

		System.out.println(maxNumber + " is the max number in the array.");
	}

//	@Test
	public void TC_02_Printing_Out_Even_Number_In_Array() {
		int arr[] = { 2, 7, 6, 8, 9, 16, 20, 30, 35 };

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println();
	}

//	@Test
	public void TC_03_Calculate_Sum_And_Average() {
		int arr[] = { 3, 5, 7, 8, 9, 11, 23, 0, -3 };

		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}

		int average = sum / arr.length;

		System.out.println("Sum = " + sum);
		System.out.println("Average = " + average);
	}

	public static void main(String[] args) {
		
		Topic_10_Array[] topic10 = new Topic_10_Array[3];
		topic10[0] = new Topic_10_Array("El Nino", 223344, 35, 9);
		topic10[1] = new Topic_10_Array("Xavi", 334455, 23, 8);
		topic10[2] = new Topic_10_Array("Iniesta", 445566, 35, 9);
		
		for (int i = 0; i < topic10.length; i++) {
			topic10[i].display_Information();
		}
	}
	
	
	public void display_Information() {
		System.out.println("ID: " + ID);
		System.out.println("Age: " + age);
		System.out.println("Score: " + score);
		System.out.println("Name: " + name);
	}
}
