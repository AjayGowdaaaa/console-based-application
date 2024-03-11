package com.controller;

import java.util.List;
import java.util.Scanner;

import com.entity.Employee;
import com.presentation.Presentation;
import com.service.EMS_Service;

public class EMSController {

	EMS_Service service;

	public EMSController() {
		super();
		service = new EMS_Service();
	}

	public void startApplication() {
		Scanner scan = new Scanner(System.in);

		while (true) {
			Presentation.displayMenu();
			int choice = scan.nextInt();
			switch (choice) {
			case 1:

				Employee emp = Presentation.scanEmployeeDetails();
				Employee employee = service.addEmployee(emp);
				Presentation.displayEmployee(employee);
				break;
			case 2:

				List<Employee> employees = service.fetchAllEmployees();
				Presentation.displayEmployeeDetails(employees);
				break;
			case 3:
				// // Display Employee record by ID
				Long id = Presentation.scanEmployeeId();
				Employee employeeById = service.fetchById(id);
				Presentation.displayEmployee(employeeById);
				break;
			case 4:
				// Display Employee record by mobile
				Long mobile = Presentation.scanEmployeeMobile();
				Employee employeeByMob = service.fetchByMobile(mobile);
				Presentation.displayEmployee(employeeByMob);

				break;
			case 5:
				// Display Employee record by name
				String name = Presentation.scanEmployeeName();
				List<Employee> employeesByName = service.fetchByName(name);
				Presentation.displayEmployeeDetails(employeesByName);
				break;
			case 6:
				// Update employee details
				Long updateId = Presentation.scanEmployeeId();
				Employee fetchedEmployee = service.fetchById(updateId);
				if (fetchedEmployee == null) {
					System.out.println("Employee details not found for ID : " + updateId);
					break;
				} else {
					Employee employeeDetailsToUpdate = Presentation.scanEmployeeDetails();
					Employee updatedEmployee = service.updateEmployee(updateId, employeeDetailsToUpdate);
					Presentation.displayEmployee(updatedEmployee);
					break;
				}

			case 7:
				// Delete employee details
				Long deletingId = Presentation.scanEmployeeId();
				Employee deletingEmployee = service.fetchById(deletingId);
				if (deletingEmployee == null) {
					System.out.println("Employee details not found for ID : " + deletingId);
					break;
				} else {
					String message = service.deleteEmployee(deletingId);
					System.out.println(message);
					break;
				}
			case 8:
				// Exit
				scan.close();
				System.exit(0);

				break;
			default:
				break;
			}

		}
	}

}
