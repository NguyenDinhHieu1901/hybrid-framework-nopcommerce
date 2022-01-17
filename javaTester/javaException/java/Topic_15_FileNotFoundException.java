package javaException.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Topic_15_FileNotFoundException {
	
	public static void main(String[] args) throws IOException {
		File file = new File("C://testing.xml");
		System.out.println(file.getPath());
		System.out.println(file.getName());
		System.out.println(file.canExecute());
		
		FileReader fileReader = new FileReader(file);
		System.out.println(fileReader.read());
		fileReader.close();
	}
}
