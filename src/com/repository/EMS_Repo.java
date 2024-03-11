package com.repository;

import java.util.List;

import com.entity.Employee;

public interface EMS_Repo {

	Employee addEmployee(Employee employee);

	List<Employee> fetchAllEmployees();

	Employee fetchById(Long id);

	Employee fetchByMobile(Long mobile);

	List<Employee> fetchByName(String name);

	Employee updateEmployee(Long id, Employee employee);

	String deleteEmployee(Long id);

}
