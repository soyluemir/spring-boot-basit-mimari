package com.emirhansoylu.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.emirhansoylu.model.Employee;

@Configuration //configurasyon sınıfı olduğunu belirttik
public class AppConfig {
	
	@Bean   //VERİTABANI OLMADIĞI İÇİN VERİLERİMİN OLDUĞU YERİ CONTEXTE BELİRTTİK hayali veriler
	public List<Employee> employeeList(){
		List<Employee> employeeList =  new ArrayList<>();
		employeeList.add(new Employee("1","enes","bayram"));
		employeeList.add(new Employee("2","emir","vural"));
		employeeList.add(new Employee("3","barış","bsam"));
		employeeList.add(new Employee("4","ahmet","soylu"));
		employeeList.add(new Employee("5","ersin","düzen"));
		
		return employeeList;
		
	}
	

}
