package com.firstspring.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.firstspring.entities.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	
	
	@Query(value = "select count(id) From employee", nativeQuery = true)
	public Integer getCount();
	
	@Query(value = "SELECT empage From employee where id = ?1", nativeQuery = true)
	public Integer getAgeById(Integer id);
	
	public List<Employee> findByEmpcityContaining(String empcity);

}
