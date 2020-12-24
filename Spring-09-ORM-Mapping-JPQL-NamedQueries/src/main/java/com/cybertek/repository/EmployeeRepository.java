package com.cybertek.repository;

import com.cybertek.entity.Employee;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

   @Query("SELECT e from Employee e where e.email = 'dtrail8@tamu.edu'")
    Employee getEmployeeDetail();

   @Query("select e.salary from Employee e WHERE e.email = 'dtrail8@tamu.edu'")
    Integer getEmployeeSalary();

   //single bind parameter
   @Query("select e from Employee e where e.email = ?1")
   Optional<Employee> getEmployeeByEmail(String email);

   //multiple bind parameter
   @Query("select  e from  Employee e where e.email = ?1 and e.salary = ?2")
   Employee getEmployeeByEmailAndSalary(String email, int salary);

   //single named parameter
   @Query("select e from Employee e where e.salary=:salary")
   Employee getEmployeeBySalary(@Param("salary") int salary);

   //multiple named parameters
    @Query("select e from Employee e where e.firstName=:name or e.salary=:salary")
    List<Employee> getEmployeeByFirstNameOrSalary(@Param("name") String name, @Param("salary") int salary);

}
