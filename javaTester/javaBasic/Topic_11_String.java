package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_11_String {
	
	Scanner keyboard = new Scanner(System.in);
	
//	@Test
	public void TC_01_Count_Upper_Case_In_String() {
		System.out.print("Please enter your string: ");
		String str = keyboard.nextLine();
		
		int count = 0;
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) <= 'Z' && str.charAt(i) >= 'A') {
				count++;
			}
		}
		
		System.out.println("Total of upper case in string = " + count);
	}
	
//	@Test
	public void TC_02_Interact_With_String() {
		
		String str = "Automation Testing 345 Tutorials Online 789";
		
		int countCharactera = 0;
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'a') {
				countCharactera++;
			}
		}
		
		System.out.println("Total character a in string = " + countCharactera);
		
		System.out.println(str.contains("Testing"));
		System.out.println(str.startsWith("Automation"));
		System.out.println(str.endsWith("Online"));
		
		System.out.println(str.indexOf("Tutorials"));
		
		String newString = str.replace("Online", "Offline");
		System.out.println(newString);
		
		int countNumber = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				countNumber++;
			}
		}
		System.out.println("Total number in string = " + countNumber);
	}
	
	@Test
	public void TC_03_Reverse_String() {
		System.out.print("Please enter your string: ");
		String str = keyboard.nextLine();
		
		char ch[] = str.toCharArray();
		
		String reverseString = "";
		
		for (int i = ch.length - 1; i >= 0; i--) {
			
			reverseString += ch[i];
		}
		
		System.out.println(reverseString);
	}
}
