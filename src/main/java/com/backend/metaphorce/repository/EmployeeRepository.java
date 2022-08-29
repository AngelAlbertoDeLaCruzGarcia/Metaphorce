package com.backend.metaphorce.repository;

import com.backend.metaphorce.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    boolean existsByTaxIdNumber(String taxIdNumber);
    Optional<Employee> findByTaxIdNumber(String taxIdNumber);

}
