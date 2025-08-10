package com.emirhansoylu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emirhansoylu.model.Employee;
import com.emirhansoylu.model.UpdateEmployeeRequest;
import com.emirhansoylu.services.EmployeeService;

@RestController
@RequestMapping("/rest/api/employee") // kök adres tanımlaması yapıyoruz.
public class RestEmployeeController {

	@Autowired // service katmanına gidebilmek için bu anatasyonla contexteki serviceyi
				// controllere enjekteledik.
	private EmployeeService employeeService;

	@GetMapping(path = "/list") // dışarıdan istek attığımızda hangi metotla eşleşeceğini belirtiyoruz
	public List<Employee> getAllEmployeeList() {
		// employeeService.getAllEmployeeList(); // isteği aldın bu isteği service
		// yönlendir. service katmanına geçtik.
		return employeeService.getAllEmployeeList();
	}

	@GetMapping(path = "/list/{id}") // path yol variable değişken. adres satırı içinde sana değişken gelecek
										// diyoruz.
	public Employee getEmployeeById(@PathVariable(name = "id", required = true) String id) {
		return employeeService.getEmployeeById(id); // string id dışarıdan gelecek değeri belirtiyoruz.
													// benim zaten employee listemde idler String id türünde
	}

	@GetMapping(path = "/with-params")
	public List<Employee> getEmployeeWithParams(@RequestParam(name = "firstName", required = false) String firstName,
			@RequestParam(name = "lastName", required = false) String lastName) {

		return employeeService.getEmployeeWithParams(firstName, lastName);

	}

	@PostMapping(path = "/save-employee")
	public Employee saveEmployee(@RequestBody Employee newEmployee) { //dışarıdan Employee tipinde data bekliyorum.
		return employeeService.saveEmployee(newEmployee);
	}
	
	
	@DeleteMapping(path = "/delete-employee/{id}")
	 public boolean deleteEmployee(@PathVariable(name = "id") String id) {
		return employeeService.deleteEmployee(id);
		 
	 }
	
	@PutMapping(path = "/update-employee/{id}")
	public Employee updateEmployee(@PathVariable (name = "id") String id, @RequestBody UpdateEmployeeRequest request) {
		return employeeService.updateEmployee(id, request);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
