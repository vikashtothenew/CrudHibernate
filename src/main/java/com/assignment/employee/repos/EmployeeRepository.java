package com.assignment.employee.repos;

import com.assignment.employee.entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository <Employee,Integer>{
    List<Employee> findByName(String name);
    List<Employee> findByNameLike(String name);
    List<Employee> findByAgeBetween(Integer min, Integer max);

}

//public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Integer> {
//}
