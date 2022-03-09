package javaException.java;

import java.io.FileReader;
import java.io.IOException;

public class Topic_15_Try_Catch_Finally {
	public static void main(String[] args) {
		try {
			FileReader fileReader = new FileReader("D://testing.txt");
			fileReader.close();
		} catch (IOException e ) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("alway run this script");
		}
	}
}
