package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.Employee;
import com.boot.service.ServiceI;

@RestController
public class Maincontroller {
	
	@Autowired
	private ServiceI se;
	@PostMapping("/add")
	public void addEmp(@RequestBody Employee e) {
		System.out.println("adding at main controller : "+e);
		se.addEmp(e);
	}
	
	@GetMapping("/{eId}")
	public Employee getalldata(@PathVariable int eId){
		System.out.println("Get data By ID");
		return se.getalldata(eId);	
	}
	
	@GetMapping("/{uName}/{pass}")
	public List<Employee> getadmindata(@PathVariable String uName ,@PathVariable String pass){
		System.out.println("get All data By admin:");
		List<Employee> l=se.getadmindata(uName, pass);
		return l;	
	}
	
	@PutMapping("/up")
	public List<Employee> updatingdata(@RequestBody Employee e){
		System.out.println("updating data");
		return se.updatingdata(e);
		}
	
	@DeleteMapping("/del/{eId}")
	public List<Employee> deletedata(@PathVariable int eId){
		System.out.println("deleted by ID :");
		return se.deletingdata(eId);
		
	}
	
}
