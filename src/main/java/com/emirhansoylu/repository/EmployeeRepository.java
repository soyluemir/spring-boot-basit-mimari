package com.emirhansoylu.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emirhansoylu.config.AppConfig;
import com.emirhansoylu.model.Employee;
import com.emirhansoylu.model.UpdateEmployeeRequest;

@Repository // veritabanıyla iletişime geçen katman
public class EmployeeRepository {

	private final AppConfig appConfig;

	@Autowired // repository gitti contexte oluşan emplopyeeListi aldı
	private List<Employee> employeeList;

	EmployeeRepository(AppConfig appConfig) {
		this.appConfig = appConfig;
	}

	public List<Employee> getAllEmployeeList() {
		return employeeList; // veriyi dön serviceye döner
	}

	public Employee getEmployeeById(String id) {
		Employee findEmployee = null;
		for (Employee employee : employeeList) {
			if (id.equals(employee.getId())) {
				findEmployee = employee;
				break;
			}
		}
		return findEmployee;

	}

	public List<Employee> getEmployeeWithParams(String firstName, String lastName) {

		List<Employee> employeeWithParams = new ArrayList<>();

		if (firstName == null && lastName == null) {
			return employeeList;

		}
		for (Employee employee : employeeList) {
			if (firstName != null && lastName != null) {
				if (employee.getFirstName().equalsIgnoreCase(firstName)
						&& employee.getLastName().equalsIgnoreCase(lastName)) {
					employeeWithParams.add(employee);

				}

			}
			if (firstName != null && lastName == null) {
				if (employee.getFirstName().equalsIgnoreCase(firstName)) {
					employeeWithParams.add(employee);

				}

			}
			if (lastName != null && firstName == null) {
				if (employee.getLastName().equalsIgnoreCase(lastName)) {
					employeeWithParams.add(employee);

				}

			}

		}
		return employeeWithParams;

	}

	public Employee saveEmployee(Employee newEmployee) {
		employeeList.add(newEmployee);
		return newEmployee;
	}

	public boolean deleteEmployee(String id) {
		// delete from Employee WHERE id = :id derdik ama veritabanı yok
		Employee deleteEmployee = null;

		for (Employee employee : employeeList) {
			if (id.equals(employee.getId())) {
				deleteEmployee = employee;

				break;

			}

		}
		if(deleteEmployee==null) {
			return false;
		}
		employeeList.remove(deleteEmployee);

		return true;
	}
	
	private Employee findEmployeeById(String id) { 
		
		Employee findEmployee = null;
		for (Employee employee : employeeList) {
			if (employee.getId().equals(id)) {
				findEmployee = employee;
				break;			
			}
			
		}
		return findEmployee;
		
	}
	
	public Employee updateEmployee(String id, UpdateEmployeeRequest request) {
		
		Employee findEmployee = findEmployeeById(id);
				if (findEmployee !=null) {
				deleteEmployee(id);
				
				Employee updatedEmployee = new Employee();
				updatedEmployee.setId(id);
				updatedEmployee.setFirstName(request.getFirstName());
				updatedEmployee.setLastName(request.getLastName());
				
				employeeList.add(updatedEmployee);
				
				return updatedEmployee;
					
				}
		return null;
		
	
	}

}
