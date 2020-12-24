package com.cybertek.repository;

import com.cybertek.entity.Employee;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.*;

import javax.transaction.Transactional;
import java.time.LocalDate;
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

    //Not Equal
    @Query("select e from Employee e where e.salary<>?1")
    List<Employee> getEmployeeBySalaryNotEqual(int salary);

    //Like / Contains / StartsWith / EndsWith
    @Query("select e from Employee e where e.firstName like ?1")
    List<Employee> getEmployeeByFirstNameLike(String pattern);

    //Less Than
    @Query("select e from Employee e where e.salary < ?1")
    List<Employee> getEmployeeBySalaryLessThan(int salary);

    //Between
    @Query("select e from Employee e where e.salary BETWEEN ?1 and  ?2")
    List<Employee> getEmployeeBySalaryBetween(int salary1, int salary2);

    //Before
    @Query("select e from Employee e where e.hireDate > ?1")
    List<Employee> getEmployeeByHireDateBefore(LocalDate date);

    //Null
    @Query("select e from Employee e where e.email is null")
    List<Employee> getEmployeeByEmailIsNull();

    //Not Null
    @Query("select e from Employee e where e.email is not null")
    List<Employee> getEmployeeByEmailIsNotNull();

    //sort salary in ascending order
    @Query("select e from Employee e order by e.salary")
    List<Employee> getEmployeeBySalaryOrderByAsc();

    //sort salary in descending order
    @Query("select e from Employee e order by e.salary desc")
    List<Employee> getEmployeeBySalaryOrderByDesc();

    //native query
    @Query(value = "select * from Employees where salary = ?1",nativeQuery = true)
    List<Employee> readEmployeeBySalary(int salary);

    @Modifying
    @Transactional
    @Query("update Employee e set e.email='admin@email.com' where e.id=:id")
    void updateEmployeeJPQL(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "update employees set email='admin@email.com' where id=:id", nativeQuery = true)
    void updateEmployeeNativeQuery(@Param("id") Integer id);

    //Named Queries
    List<Employee> retrieveEmployeeSalaryGreaterThan(Integer salary);
}
