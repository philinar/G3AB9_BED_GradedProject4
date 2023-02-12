package com.gl.EmployeeMgmtRestAPI.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.EmployeeMgmtRestAPI.model.Employee;
import com.gl.EmployeeMgmtRestAPI.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmpController {
	@Autowired
	EmployeeService empservice;
	
	@RequestMapping("/list")
	public String listEmployee(Model model) {
		List<Employee> empList = empservice.getAllEmployees();
		model.addAttribute("Employees", empList);
		return "listemployees";
	}

	@RequestMapping("/showform")
	public String showForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("Employee", employee);
		return "employeeform";
	}
	@RequestMapping("delete/{id}")	//RequestMapping
	public String deleteTicket(@PathVariable("id") long id){	
		empservice.deleteEmployeeById(id);	
		return "redirect:/tickets";
	}
	@PostMapping("/save")
	public String showsave(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email) {
		Employee employee = new Employee();
		employee.setId(id);
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setEmail(email);
		
		empservice.insertRecords(employee);
		return "redirect:/employee/list";
	}
	@RequestMapping("/showFormForUpdate/{id}")
	public String updateemployee(@ModelAttribute("employee") Employee employee, @PathVariable("id") long id){
		Employee existingEmployee = empservice.getEmployeeById(id);
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		empservice.insertRecords(employee);
		return "redirect:/employee/list";
	}

}