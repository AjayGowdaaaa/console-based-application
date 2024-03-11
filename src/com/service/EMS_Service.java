package com.service;

import java.util.List;

import com.entity.Employee;
import com.repository.EMS_Repo;
import com.repository.EMS_RepoImpl;

public class EMS_Service {

	EMS_Repo repo = new EMS_RepoImpl();

	public List<Employee> fetchAllEmployees() {
		return repo.fetchAllEmployees();
	}

	public Employee addEmployee(Employee emp) {

		return repo.addEmployee(emp);
	}

	public Employee fetchById(Long id) {
		return repo.fetchById(id);
	}

	public Employee fetchByMobile(Long mobile) {
		return repo.fetchByMobile(mobile);
	}

	public List<Employee> fetchByName(String name) {
		return repo.fetchByName(name);
	}

	public Employee updateEmployee(Long id, Employee employee) {
		return repo.updateEmployee(id, employee);
	}
	
	public String deleteEmployee(Long id) {
		return repo.deleteEmployee(id);
	}
}
