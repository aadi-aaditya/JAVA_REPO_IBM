package com.ibm.Junit5_demo2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class FullTest 
   {
    	
	private EmployeeService ES;
	private Employee emp1;
	private Employee emp2;
	private Employee emp3;
	
	@BeforeEach
	void setup()
	{
		ES = new EmployeeService();
		
		emp1 = new Employee(101, "Alice", 50000.0);
        emp2 = new Employee(102, "Bob", 75000.0);
        emp3 = new Employee(103, "Charlie", 60000.0);
		
		ES.addEmployee(emp1);
		ES.addEmployee(emp2);
	}
	
	@Test
	@DisplayName("Trying to Add EMP:...")
	void TestADD()
	{
		ES.addEmployee(emp3);
		assertEquals(3,ES.getTotalEmployees());
		assertTrue(ES.getAllEmployees().contains(emp3));	
	}
	
	@Test
	@DisplayName("Employee DATA PULL...")
	void getdata()
	{
		List<Employee> allEmployees = ES.getAllEmployees();
        assertEquals(2, allEmployees.size());
        assertTrue(allEmployees.contains(emp1));
        assertTrue(allEmployees.contains(emp2));	
	}
	
	 @Test
	    @DisplayName("Should return null when finding a non-existent employee ID")
	    void testFindEmployee_NotFound() {
	        Employee found = ES.findEmployee(999);
	        assertNull(found);
	    }

	    @Test
	    @DisplayName("Should return true and delete an employee if ID exists")
	    void testDeleteEmployee_Success() {
	        boolean isDeleted = ES.deleteEmployee(101);
	        assertTrue(isDeleted);
	        assertEquals(1, ES.getTotalEmployees());
	        assertNull(ES.findEmployee(101));
	    }

	    @Test
	    @DisplayName("Should return false when attempting to delete a non-existent ID")
	    void testDeleteEmployee_Failure() {
	        boolean isDeleted = ES.deleteEmployee(999);
	        assertFalse(isDeleted);
	        assertEquals(2, ES.getTotalEmployees());
	    }
	
	    @Test
	    @DisplayName("Should return employees sorted ascending by salary")
	    void testSortBySalary() {
	        ES.addEmployee(emp3);

	        List<Employee> sortedList = ES.sortBySalary();
	        assertEquals(emp1, sortedList.get(0));
	        assertEquals(emp3, sortedList.get(1));
	        assertEquals(emp2, sortedList.get(2));
	    }

	    @Test
	    @DisplayName("Should calculate the correct highest salary")
	    void testGetHighestSalary() {
	        ES.addEmployee(emp3);
	        double maxSalary = ES.getHighestSalary();
	        assertEquals(75000.0, maxSalary, 0.001); 
	    }
	
	    @Test
	    @DisplayName("Should return 0 for highest salary when list is empty")
	    void testGetHighestSalary_EmptyList() {
	        EmployeeService emptyService = new EmployeeService();
	        assertEquals(0.0, emptyService.getHighestSalary(), 0.001);
	    }

	    @Test
	    @DisplayName("Should return accurate total count of employees")
	    void testGetTotalEmployees() {
	        assertEquals(2, ES.getTotalEmployees());
	    }
	
	
	
	
	
	
	
}
