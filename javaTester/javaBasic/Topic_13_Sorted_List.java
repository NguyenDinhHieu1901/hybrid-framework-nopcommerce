package javaBasic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Topic_13_Sorted_List {
	
	public static void main(String[] args) {
		List<String> allProducts = new ArrayList<String>();
		String[] products = {"Apple MacBook Pro 13-inch", "Asus N551JK-XO076H Laptop", "HP Envy 6-1180ca 15.6-Inch Sleekbook", "Samsung Series 9 NP900X4C Premium Ultrabook"};
		
		for (String i : products) {
			allProducts.add(i);
		}
		
		// List<String> sortedList = allProducts.stream().sorted().collect(Collectors.toList());
		// sortedList.forEach(System.out::println);
		
		Collections.sort(allProducts);
		System.out.println(allProducts);
	}
}
