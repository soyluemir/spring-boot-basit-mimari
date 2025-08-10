package com.enesbayram.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enesbayram.model.Employee;
import com.enesbayram.model.UpdateEmployeeRequest;
import com.enesbayram.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired //repository katmanını enjekte ettik buraya ki oraya geçebilelim.
	private EmployeeRepository employeeRepository; //nulldur @Autowired etmezsek nullpointer hatası yeriz
	
	public List<Employee> getAllEmployeeList(){
		
		// employeeRepository.getAllEmployeeList(); // repository katmanına git // ikinci aşamada bura iptal
		return employeeRepository.getAllEmployeeList(); // controller katmanına döner listeyi
	}
	
	public Employee getEmployeeById(String id) {
		return employeeRepository.getEmployeeById(id);
	}

	public List<Employee> getEmployeeWithParams(String firstName , String lastName){
		return employeeRepository.getEmployeeWithParams(firstName, lastName);
	}
	
	public Employee saveEmployee(Employee newEmployee) {
		return employeeRepository.saveEmployee(newEmployee);
	}
	public boolean deleteEmployee(String id) {
		return employeeRepository.deleteEmployee(id);
	}
	public Employee updateEmployee(String id, UpdateEmployeeRequest request )
	{
		return employeeRepository.updateEmployee(id, request);
	}
}
    
