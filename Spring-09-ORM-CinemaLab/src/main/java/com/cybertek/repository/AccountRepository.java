package com.cybertek.repository;

import com.cybertek.entity.Account;
import com.cybertek.enums.UserRole;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

    // ------------------- DERIVED QUERIES ------------------- //
//Write a derived query to list all accounts with a specific country or state
    List<Account> findAllByCountryOrState(String country, String state);

//Write a derived query to list all accounts with age lower than or equal to a specific value
    List<Account> findAllByAgeLessThanEqual(Integer age);

//Write a derived query to list all accounts with a specific role
    List<Account> findAllByRole(UserRole role);

//Write a derived query to list all accounts between a range of ages
    List<Account> findAllByAgeBetween(Integer age1, Integer age2);

//Write a derived query to list all accounts where the beginning of the address contains the keyword
    List<Account> findAllByAddressStartingWith(String address);

//Write a derived query to sort the list of accounts with age
    List<Account> findByOrderByAgeDesc();

// ------------------- JPQL QUERIES ------------------- //
//Write a JPQL query that returns all accounts
    @Query("select a from Account a")
    List<Account> fetchAllJPQL();

//Write a JPQL query to list all admin accounts
    @Query("select a from Account a where a.role='USER'")
    List<Account> fetchAdminUsers();

//Write a JPQL query to sort all accounts with age
    @Query("select a from Account a order by a.age desc")
    List<Account> orderWithAgeJPQL();

// ------------------- Native QUERIES ------------------- //
//Write a native query to read all accounts with an age lower than a specific value
    @Query(value = "select * from account_details where age < ?1",nativeQuery = true)
    List<Account> retrieveAllByAgeLowerThan(Integer age);

//Write a native query to read all accounts that a specific value can be containable in the name, address, country, state city
    @Query(value = "select * from account_details where name ilike concat('%',?1,'%') " +
            "or country ilike concat('%',?1,'%') or address ilike concat('%',?1,'%') or state ilike concat('%',?1,'%')",nativeQuery = true)
    List<Account> retrieveBySearchCriteria(String pattern);

//Write a native query to read all accounts with an age lower than a specific value
    @Query(value = "select * from account_details where age < ?1",nativeQuery = true)
    List<Account> retrieveLessThanAge(int age);

}
