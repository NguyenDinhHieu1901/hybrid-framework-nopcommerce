package javaOOP.knowledge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class StudentManegement {

	private static Scanner keyboard = new Scanner(System.in);
	private static char option;

	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<>();

		do {
			displayProgram();
			System.out.print("Please enter your choice (1-6): ");
			option = keyboard.next().charAt(0);

			switch (option) {
			case '1':
				inputData(students);
				break;
			case '2':
				showStudentInfo(students);
				break;
			case '3':
				sortedStudentFollowToAverageScore(students);
				break;
			case '4':
				ratingStudent(students);
				break;
			case '5':
				System.out.println("Student list is dowloading ....");
				break;
			case '6':
				System.out.println("Thank you for using my service. See you later");
				break;
			default:
				System.out.println("Options 1-6 only!");
				break;
			}

		} while (option != '6');
	}
	
	public static void displayProgram() {
		System.out.println("-----------------------------------------");
		System.out.println("	STUDENT MANAGEMENT PROGRAMMING	");
		System.out.println(" 		1. Input data");
		System.out.println(" 		2. Printing out student list");
		System.out.println(" 		3. Sorted student following average score");
		System.out.println(" 		4. Student rating");
		System.out.println(" 		5. Exporting student list");
		System.out.println(" 		6. Quitting");
		System.out.println("-----------------------------------------");
	}

	public static void inputData(ArrayList<Student> students) {
		System.out.println("================INPUT DATA================");
		System.out.print("Please enter id of student: ");
		int id = keyboard.nextInt();
		System.out.print("Please enter name of student: ");
		String name = keyboard.next();
		System.out.print("Please enter principle score of student: ");
		double principleScore = keyboard.nextDouble();
		System.out.print("Please enter examine score of student: ");
		double examineScore = keyboard.nextDouble();

		Student student = new Student(id, name, principleScore, examineScore);
		students.add(student);
	}

	public static void showStudentInfo(ArrayList<Student> students) {
		for (Student student : students) {
			System.out.println("Id: " + student.getIdStudent());
			System.out.println("Name: " + student.getNameStudent());
			System.out.println("Average score: " + student.getAverageScore());
		}
	}
	
	public static void sortedStudentFollowToAverageScore(ArrayList<Student> students) {
		students.sort(Comparator.comparing(Student::getAverageScore).reversed());
		
		for (Student student : students) {
			System.out.println("List student from high to low: " + student.getNameStudent());
		}
	}
	
	public static void ratingStudent(ArrayList<Student> students) {
		for (Student student : students) {
			System.out.println("Rating of " + student.getNameStudent() + " = " + student.getRatingStudent());
		}
	}

}
