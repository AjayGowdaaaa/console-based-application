package com.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.entity.Employee;

public class EMS_RepoImpl implements EMS_Repo {
	public final static String QUERY_TO_GET_MAX_ID = "select MAX(id) from employee";

	private Long getMaxId() {
		Connection con = DBConfig.getConnection();
		ResultSet resultSet = null;
		Statement statement = null;
		Long id;
		try {
			statement = con.createStatement();
			resultSet = statement.executeQuery(QUERY_TO_GET_MAX_ID);
			if (resultSet.next()) {
				id = resultSet.getLong("MAX(id)");
				return id;
			}
		} catch (SQLException e) {
			System.out.println("Failed to Add Employee details due to : " + e.getMessage());
			e.printStackTrace();
		} finally {
			DBConfig.closeConnections(con, statement, resultSet);

		}
		return null;
	}

	@Override
	public Employee addEmployee(Employee employee) {

		Connection con = DBConfig.getConnection();
		Statement stmt = null;

		Long id = getMaxId();
		id++;
		employee.setId(id);
		String name = employee.getName();
		LocalDateTime dob = employee.getDateOfBirth();
		String email = employee.getEmail();
		Long mobile = employee.getMobile();

		String addQuery = "INSERT INTO employee (id, name, dateOfBirth, email, mobile) VALUES (" + id + ", '" + name
				+ "', '" + dob + "', '" + email + "', " + mobile + ");";

		try {
			stmt = con.createStatement();
			int rowsAffected = stmt.executeUpdate(addQuery);
			if (rowsAffected == 1)
				return employee;

		} catch (SQLException e) {
			System.out.println("Failed to Add Employee details due to : " + e.getMessage());
			e.printStackTrace();

		} finally {
			DBConfig.closeConnections(con, stmt);
		}

		return null;
	}

	@Override
	public List<Employee> fetchAllEmployees() {

		List<Employee> employees = new ArrayList<>();
		Connection connection = DBConfig.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			String query = "select * from employee";
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				Long id = resultSet.getLong("id");
				String name = resultSet.getString("name");

				Date date = resultSet.getDate("dateOfBirth");

				LocalDateTime localDateTime = date.toLocalDate().atStartOfDay();

				String email = resultSet.getString("email");
				Long mobile = resultSet.getLong("mobile");

				Employee employee = new Employee(id, name, localDateTime, email, mobile);

				employees.add(employee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConfig.closeConnections(connection, statement, resultSet);
		}

		return employees;
	}

	@Override
	public Employee fetchById(Long id) {
		Employee employee = null;
		Connection connection = DBConfig.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			String query = "select * from employee where id = " + id;
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				Long idVal = resultSet.getLong("id");
				String name = resultSet.getString("name");

				Date date = resultSet.getDate("dateOfBirth");

				LocalDateTime localDateTime = date.toLocalDate().atStartOfDay();

				String email = resultSet.getString("email");
				Long mobile = resultSet.getLong("mobile");

				employee = new Employee(idVal, name, localDateTime, email, mobile);

			}
			return employee;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConfig.closeConnections(connection, statement, resultSet);
		}
		return null;

	}

	@Override
	public Employee fetchByMobile(Long mobile) {
		Employee employee = null;
		Connection connection = DBConfig.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			String query = "select * from employee where mobile = " + mobile;
			System.out.println(query);
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				Long idVal = resultSet.getLong("id");
				String name = resultSet.getString("name");

				Date date = resultSet.getDate("dateOfBirth");

				LocalDateTime localDateTime = date.toLocalDate().atStartOfDay();

				String email = resultSet.getString("email");
				Long mobileDetails = resultSet.getLong("mobile");

				employee = new Employee(idVal, name, localDateTime, email, mobileDetails);

			}
			return employee;
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBConfig.closeConnections(connection, statement, resultSet);
		}
		return null;

	}

	@Override
	public List<Employee> fetchByName(String name) {
		List<Employee> employees = new ArrayList<>();
		Connection connection = DBConfig.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			String query = "select * from employee where LOWER(name) = LOWER('" + name + "')";
			System.out.println(query);
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				Long id = resultSet.getLong("id");
				String fetchedName = resultSet.getString("name");

				Date date = resultSet.getDate("dateOfBirth");

				LocalDateTime localDateTime = date.toLocalDate().atStartOfDay();

				String email = resultSet.getString("email");
				Long mobile = resultSet.getLong("mobile");

				Employee employee = new Employee(id, fetchedName, localDateTime, email, mobile);

				employees.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConfig.closeConnections(connection, statement, resultSet);
		}

		return employees;
	}

	@Override
	public Employee updateEmployee(Long id, Employee employee) {

		Connection con = DBConfig.getConnection();
		Statement stmt = null;
		employee.setId(id);
		String name = employee.getName();
		LocalDateTime dob = employee.getDateOfBirth();
		String email = employee.getEmail();
		Long mobile = employee.getMobile();

		String updateQuery = "UPDATE employee SET name = '" + name + "', dateOfBirth = '" + dob + "', email = '" + email
				+ "', mobile = " + mobile + " WHERE id = " + id + "";

		try {
			stmt = con.createStatement();
			int rowsAffected = stmt.executeUpdate(updateQuery);
			if (rowsAffected == 1)
				return employee;

		} catch (SQLException e) {
			System.out.println("Failed to Update Employee details due to : " + e.getMessage());
			e.printStackTrace();

		} finally {
			DBConfig.closeConnections(con, stmt);
		}

		return null;
	}

	@Override
	public String deleteEmployee(Long id) {
		// DELETE FROM employee WHERE id = 0;
		Connection con = DBConfig.getConnection();
		Statement stmt = null;

		String deleteQuery = "DELETE FROM employee WHERE id = " + id + " ;";

		try {
			stmt = con.createStatement();
			int rowsAffected = stmt.executeUpdate(deleteQuery);
			if (rowsAffected == 1)
				return "Employee details for ID : " + id + " Deleted sucesfully";

		} catch (SQLException e) {
			System.out.println("Failed to Update Employee details due to : " + e.getMessage());
			e.printStackTrace();

		} finally {
			DBConfig.closeConnections(con, stmt);
		}

		return null;
	}

}
