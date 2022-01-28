package com.ibs.project;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EmployeeList {

	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee("A-1", "Bibi", 100, "Active", "150000"));
		employeeList.add(new Employee("A-2", "Unni", 100, "Inactive", "5000"));
		employeeList.add(new Employee("A-3", "Angel", 101, "Active", "75000"));
		employeeList.add(new Employee("A-4", "Lekshmi", 101, "Inactive", "150000"));
		employeeList.add(new Employee("A-5", "Rashad", 101, "Active", "22000"));
		employeeList.add(new Employee("A-6", "Anoop", 105, "Active", "160000"));
		employeeList.add(new Employee("A-7", "Nikhil", 105, "Active", "150000"));
		employeeList.add(new Employee("A-8", "Gayathri", 106, "Active", "50000"));
		employeeList.add(new Employee("A-9", "Kalyani", 108, "Inactive", "22000"));
		employeeList.add(new Employee("A-10", "Shanthanu", 108, "Active", "150000"));
		System.out.println("-------------Employee details in each department------------------");
		Map<Integer, List<Employee>> empdetails = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepId, Collectors.toList()));

		empdetails.entrySet().forEach(entry -> {
			System.out.println(entry.getKey() + " " + entry.getValue());
		});

		System.out.println("--------------Employees count working in each department-----------------");

		Map<Integer, Long> empCoutByDept = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepId, Collectors.counting()));
		empCoutByDept.entrySet().forEach(entry -> {
			System.out.println("Department" + entry.getKey() + " " + entry.getValue());
		});
		System.out.println("-----------Active and inactive employees in the given collection--------------------");
		long activeemployeeList = employeeList.stream().filter(e -> "Active".equals(e.getStatus())).count();
		System.out.println(" Active Employee count " + activeemployeeList);
		long inactiveemployeeList = employeeList.stream().filter(e -> "Inactive".equals(e.getStatus())).count();
		System.out.println(" Inactive Employee count " + inactiveemployeeList);

		System.out.println("------------Max/Min Salary from the given collection-------------------");
		Optional<Employee> maxEmpSal = employeeList.stream().max(Comparator.comparing(Employee::getSalary));
		System.out.println(maxEmpSal);
		Optional<Employee> minEmpSal = employeeList.stream().min(Comparator.comparing(Employee::getSalary));
		System.out.println(minEmpSal);

		System.out.println("------------max salary of an employee from each department-------------------");
		Map<Integer, Optional<Employee>> deptWiseMaxSal = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepId,
						Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary)))));
		deptWiseMaxSal.entrySet().forEach(entry -> {
			System.out.println("Department " + entry.getKey() + "Top Emp" + entry.getValue());
		});
		System.out.println("----------------------------------------------------------");
	}

}