package com.gl.EmployeeMgmtRestAPI.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.EmployeeMgmtRestAPI.model.Employee;
import com.gl.EmployeeMgmtRestAPI.repository.EmployeeRepository;
import com.gl.EmployeeMgmtRestAPI.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository emprepo;
	
	@Override
	public void insertRecords(Employee employee) {
		emprepo.save(employee);
		
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return emprepo.findAll();
	}
	
	@Override
	public Employee getEmployeeById(long id) {
		return emprepo.findById(id).get();
	}

	@Override
	public void deleteEmployeeById(long id) {
		emprepo.deleteById(id);
	}

}