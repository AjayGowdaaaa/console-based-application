package com.presentation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.entity.Employee;

public class Presentation {
	static Scanner scan = new Scanner(System.in);

	public static LocalDateTime convertStringToLocalDateTime(String dateString, String pattern) {
		// Define the date format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

		// Parse the string to LocalDate
		LocalDate localDate = LocalDate.parse(dateString, formatter);

		// Set a default time, for example, midnight
		LocalTime localTime = LocalTime.MIDNIGHT;

		// Combine LocalDate and LocalTime to create LocalDateTime
		return LocalDateTime.of(localDate, localTime);
	}

	public static void displayMenu() {
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println("	    EMPLOYEE MANAGEMENT SYSTEM");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||");

		System.out.println("1. Create employee record");
		System.out.println("2. Fetch all emplyee details");
		System.out.println("3. Fetch employee details by ID");
		System.out.println("4. Fetch employee details by Mobile");
		System.out.println("5. Fetch employee details by Name");
		System.out.println("6. Update employee details by ID");
		System.out.println("7. Delete employee details by ID");
		System.out.println("8. Exit");
		System.out.println("----------------------------------------------------");
		System.out.println("Please select the option");
		System.out.println("----------------------------------------------------");

	}

	public static void displayEmployeeDetails(List<Employee> employees) {
		if (employees == null) {
			System.out.println("--------------------------");
			System.out.println("Employee details not found");
			System.out.println("--------------------------");
		} else {

			System.out.println("**************************");
			for (Employee employee : employees) {
				System.out.println("Employee ID : " + employee.getId());
				System.out.println("Employee Name : " + employee.getName());
				System.out.println("Date of Birth : " + employee.getDateOfBirth());
				System.out.println("Email ID : " + employee.getEmail());
				System.out.println("Mobile : " + employee.getMobile());
				System.out.println("--------------------------");
			}
			System.out.println("**************************");
		}
	}

	public static void displayEmployee(Employee employee) {
		if (employee == null) {
			System.out.println("--------------------------");
			System.out.println("Employee details not found");
			System.out.println("--------------------------");
		} else {
			System.out.println("--------------------------");
			System.out.println("Employee ID : " + employee.getId());
			System.out.println("Employee Name : " + employee.getName());
			System.out.println("Date of Birth : " + employee.getDateOfBirth());
			System.out.println("Email ID : " + employee.getEmail());
			System.out.println("Mobile : " + employee.getMobile());
			System.out.println("--------------------------");
		}
	}

	public static Employee scanEmployeeDetails() {
		System.out.println("--------------------------");

		System.out.println("Enter name : ");
		String name = scan.next();

		System.out.println("Enter Date of Birth (accepting format [MM-dd-yyyy]) : ");
		String dob = scan.next();
		LocalDateTime dateOfBirth = convertStringToLocalDateTime(dob, "MM-dd-yyyy");

		System.out.println("Enter email id : ");
		String email = scan.next();

		System.out.println("Enter mobile number : ");
		Long phone = scan.nextLong();

		Employee employee = new Employee(name, dateOfBirth, email, phone);
		System.out.println("--------------------------");

		return employee;
	}

	public static Long scanEmployeeId() {
		System.out.println("--------------------------");
		System.out.println("Please enter employee ID : ");
		return scan.nextLong();
	}

	public static Long scanEmployeeMobile() {
		System.out.println("--------------------------");
		System.out.println("Please enter employee mobile number : ");
		return scan.nextLong();
	}

	public static String scanEmployeeName() {
		System.out.println("--------------------------");
		System.out.println("Please enter employee name : ");
		return scan.next();
	}

}
