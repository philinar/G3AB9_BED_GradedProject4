package com.gl.EmployeeMgmtRestAPI.service;

import java.util.List;

import com.gl.EmployeeMgmtRestAPI.model.Employee;

public interface EmployeeService {
	
	// INSERT NEW RECORDS
	public void insertRecords(Employee employee);

    // PRINT ALL RECORDS
	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeById(long id);

	public void deleteEmployeeById(long id);

}