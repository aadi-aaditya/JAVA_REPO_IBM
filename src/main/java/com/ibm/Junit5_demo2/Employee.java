package com.ibm.Junit5_demo2;

import java.util.Objects;

public class Employee {
	private int id;
	private String name;
	private double salary;

	public Employee() 
	{}

	public Employee(int id, String name, double salary)
	{
	this.id = id;
	this.name = name;
	this.salary = salary;
	}

	public int getId() 
	{
	return id;
	}

	public int setId(int id)
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name=name;
	}

	public double getSalary()
	{
		return salary;
	}

	public void setSalary(double salary)
	{
		this.salary=salary;
	}

	@Override
	public boolean equals(Object o) 
	{

	if(this==o)
		return true;

	if(!(o instanceof Employee))
		return false;
	
	Employee e=(Employee)o;
	return id==e.id;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(id);
	}
	
	
	
	
}