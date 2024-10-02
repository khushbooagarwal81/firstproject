package com.firstspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.firstspring.entities.Employee;
import com.firstspring.repo.EmployeeRepo;

@RestController
public class MyController {
	
	@Autowired
	private EmployeeRepo emprepo;
	
	@GetMapping("/hello")
	public String helloWelcome() {
		
		return "Hello Khushboo";
		
	}
	

	@GetMapping("/name")
	public String khushboo() {
		
		return "Welcom Khushboo";
		
	}
	
	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployee(){
		return emprepo.findAll();
	}
	
	@GetMapping("/getEmployee/{id}")
	public Employee getEmployeeById(@PathVariable("id") int id){
		
		return emprepo.findById(id).get();
		
	}
	
	@PostMapping("/add")
	public String addEmploye(@RequestBody Employee emp) {
		
		emprepo.save(emp);
		return "Employeed added succesfully";
		
	}
	
	@PutMapping("/update")
	public String updateEmploye(@RequestBody Employee emp) {
		
		emprepo.save(emp);
		return "Employeed updated succesfully";
		
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployeeById(@PathVariable("id") int id){
		emprepo.deleteById(id);
		return "Employee delete successfully";
		
	}
	
	@GetMapping("/getempcount")
	public int getEmpCount() {
		
		return emprepo.getCount();
		
	}
	
	
	@GetMapping("/getage/{id}")
	public int getAgeById(@PathVariable("id") int id) {
		
		return emprepo.getAgeById(id);
		
	}
	
	@GetMapping("/getbycity/{city}")
	public List<Employee> getEmployeeByCity(@PathVariable("city") String city){
		return emprepo.findByEmpcityContaining(city);
	}
	
	
	
}
