package javaOOP.overloading;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Topic_09_Overloading {
	private String employeeName;
	private int employeeID;
	private int employeeAge;
	
	public Topic_09_Overloading() {
		System.out.println("This is no parameter constructor!");
	}
	
	public Topic_09_Overloading(int id) {
		System.out.println("This is one parameter constructor with ID = " + id);
	}
	
	public Topic_09_Overloading(int id, String type) {
		System.out.println("This is two parameter constructor with ID = " + id + " and Type = " + type);
	}
	
	public Topic_09_Overloading(String type) {
		System.out.println("This is one parameter constructor with Type = " + type);
	}
	
	public void showEmployeeInfo() {
		setEmployeeName("El Nino");
		setEmployeeID(888888);
		setEmployeeAge(21);
		System.out.println(getEmployeeName());
		System.out.println(getEmployeeID());
		System.out.println(getEmployeeAge());
	}
	
	public void showEmployeeInfo(String employeeName) {
		setEmployeeID(123456);
		setEmployeeAge(25);
		System.out.println(employeeName);
		System.out.println(getEmployeeID());
		System.out.println(getEmployeeAge());
	}
	
	public void showEmployeeInfo(String employeeName, int employeeID) {
		setEmployeeAge(28);
		System.out.println(employeeName);
		System.out.println(employeeID);
		System.out.println(getEmployeeAge());
	}
	
	public void showEmployeeInfo(String employeeName, int employeeID, int employeeAge) {
		System.out.println(employeeName);
		System.out.println(employeeID);
		System.out.println(employeeAge);
	}
	
	public static void main(String[] args) {
		Topic_09_Overloading obj = new Topic_09_Overloading();
		Topic_09_Overloading obj1 = new Topic_09_Overloading(123456);
		Topic_09_Overloading obj2 = new Topic_09_Overloading("Hype");
		Topic_09_Overloading obj3 = new Topic_09_Overloading(456789, "Native");
		System.out.println("==================");
		obj.showEmployeeInfo();
		System.out.println("==================");
		obj.showEmployeeInfo("Xavi");
		System.out.println("==================");
		obj.showEmployeeInfo("Iniesta", 999999);
		System.out.println("==================");
		obj.showEmployeeInfo("Puyol", 555555, 35);
		
		obj1.showEmployeeInfo();
		obj2.showEmployeeInfo();
		obj3.showEmployeeInfo();
	}
}
