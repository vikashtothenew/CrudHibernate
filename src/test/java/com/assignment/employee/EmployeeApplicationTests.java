package com.assignment.employee;

import com.assignment.employee.entities.Employee;
import com.assignment.employee.repos.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeApplicationTests {

	@Autowired
	EmployeeRepository repository;

	@Test
	void contextLoads() {
	}
	@Test
	public void testCreate(){
		Employee employee = new Employee();
		Employee employee2 = new Employee();
		Employee employee3 = new Employee();

		employee.setId(1);
		employee.setName("Prakash");
		employee.setAge(21);
		employee.setLocation("LKO");

		employee2.setId(2);
		employee2.setName("Vikash");
		employee2.setAge(22);
		employee2.setLocation("VNS");

		employee3.setId(3);
		employee3.setName("Shivam");
		employee3.setAge(23);
		employee3.setLocation("GZP");

		repository.save(employee);
		repository.save(employee2);
		repository.save(employee3);
	}

	@Test
	public void testRead(){
		Employee employee = repository.findById(1).get();
		assertNotNull(employee);
		assertEquals("Prakash",employee.getName());
		System.out.println(">>>>>>"+employee.getLocation());
	}

	@Test
	public void testUpdate(){
		Employee employee = repository.findById(1).get();
		employee.setName("PrakshSingh");
		repository.save(employee);
	}

	@Test
	public void testDelete(){
		repository.deleteById(1);
	}

	@Test
	public void testCount(){
		System.out.println("Total rows :: "+repository.count());
	}

//	@Test
//	public void testFindAllPaging(){
//		PageRequest pageable = PageRequest.of(0,2);
//
//		Page<Employee> results = repository.findAll(pageable);
//		results.forEach(p-> System.out.println(p.getName()));
//	}

//	@Test
//	public void testFindAllSorting()
//	{
//		PageRequest pageable=  PageRequest.of(0,2, Sort.Direction.DESC,"age");
//				repository.findAll(pageable).forEach(p-> System.out.println(p.getName()));
//	}

	@Test
	public void testfindByName(){
		List<Employee> emloyee = repository.findByName("Vikash");
		emloyee.forEach(p-> System.out.println(p.getLocation()));
	}


	@Test
	public void testfindByNameLike(){
		List<Employee> emloyee = repository.findByNameLike("A%");
		emloyee.forEach(p-> System.out.println(p.getLocation()));
	}

	@Test
	public void testfindByAgeBetween(){
		List<Employee> emloyee = repository.findByAgeBetween(18,22);
		emloyee.forEach(p-> System.out.println(p.getLocation()));
	}
}

