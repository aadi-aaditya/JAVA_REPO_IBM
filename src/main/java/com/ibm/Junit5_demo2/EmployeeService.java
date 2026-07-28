package com.ibm.Junit5_demo2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {

	private List<Employee> employees = new ArrayList<>();

	public void addEmployee(Employee emp)
	{
		employees.add(emp);
	}

	public List<Employee> getAllEmployees() 
	{
		return employees;
	}		

	public Employee findEmployee(int id) {

		for(Employee e : employees) {

            if(e.getId()==id)
                return e;
        }

        return null;
    }

    public boolean deleteEmployee(int id) {

        return employees.removeIf(e->e.getId()==id);
    }

    public List<Employee> sortBySalary() {

        return employees.stream()

                .sorted(Comparator.comparing(Employee::getSalary))

                .collect(Collectors.toList());
    }

    public double getHighestSalary() {

        return employees.stream()

                .mapToDouble(Employee::getSalary)

                .max()

                .orElse(0);
    }

    public int getTotalEmployees() {
        return employees.size();
    }

}