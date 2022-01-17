package javaException.java;

public class Topic_15_ArrayIndexOutOfBoundsException {
	
	public static void main(String[] args) {
		int number[] = new int[5];
		number[0] = 1;
		number[1] = 1;
		number[2] = 1;
		number[3] = 1;
		number[4] = 1;
		number[5] = 1;
		
		String[] cities = {"New York", "Manhattan", "Washington", "California"};
		System.out.println(cities[0]);
		System.out.println(cities[1]);
		System.out.println(cities[2]);
		System.out.println(cities[3]);
		System.out.println(cities[4]);
	}
}
