package javaOOP;

import java.util.ArrayList;
import java.util.Scanner;

public class Topic_01_Class_Object_Student {
	private static Scanner keyboard;
	private int studentID;
	private String studentName;
	private Float knowledgePoint;
	private Float practisePoint;
	private static char option;

	protected Topic_01_Class_Object_Student(int studentID, String studentName, Float knowledgePoint, Float practisePoint) {
		setStudentID(studentID);
		setStudentName(studentName);
		setKnowledgePoint(knowledgePoint);
		setPractisePoint(practisePoint);
	}

	protected void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	protected int getStudentID() {
		return studentID;
	}

	protected String getStudentName() {
		return studentName;
	}

	protected void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	protected Float getKnowledgePoint() {
		return knowledgePoint;
	}

	protected void setKnowledgePoint(Float knowledgePoint) {
		this.knowledgePoint = knowledgePoint;
	}

	protected Float getPractisePoint() {
		return practisePoint;
	}

	protected void setPractisePoint(Float practisePoint) {
		this.practisePoint = practisePoint;
	}

	public static void main(String[] args) {
		ArrayList<Topic_01_Class_Object_Student> students = new ArrayList<>();
		students = getInputData();
		
		for (Topic_01_Class_Object_Student student : students) {
			student.showStudentInfo();
		}
	}

	protected static ArrayList<Topic_01_Class_Object_Student> getInputData() {
		ArrayList<Topic_01_Class_Object_Student> students = new ArrayList<>();
		keyboard = new Scanner(System.in);
		do {
			System.out.print("Please enter student ID: ");
			int id = keyboard.nextInt();
			System.out.print("Please enter student name: ");
			String name = keyboard.next();
			System.out.print("Please enter knowledge point: ");
			float knowledge = keyboard.nextFloat();
			System.out.print("Please enter practise point: ");
			float practise = keyboard.nextFloat();
			Topic_01_Class_Object_Student student = new Topic_01_Class_Object_Student(id, name, knowledge, practise);
			students.add(student);

			System.out.print("Do you wanna continue the input data? (y/n) ");
			option = keyboard.next().charAt(0);
		} while (option == 'y' || option == 'Y');
		return students;
	}

	protected Float getAveragePoint() {
		return (getKnowledgePoint() + getPractisePoint() * 2) / 3;
	}

	protected void showStudentInfo() {
		System.out.println("Student ID = " + getStudentID());
		System.out.println("Student Name = " + getStudentName());
		System.out.println("Knowledge Point = " + getKnowledgePoint());
		System.out.println("Practise Point = " + getPractisePoint());
		System.out.println("Average Point = " + getAveragePoint());
		System.out.println("------------------------");
	}
}
