package com.backend.metaphorce.repository;

import com.backend.metaphorce.entity.Contract;
import com.backend.metaphorce.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ContractRepository extends CrudRepository<Contract, Long> {

    Optional<Contract> findByEmployee(int id);

    @Query(value = "SELECT * FROM contracts WHERE employees_id = :id;", nativeQuery = true)
    List<Contract> existsByEmployee(int id);
    @Query(value = "SELECT * FROM contracts;", nativeQuery = true)
    List<Contract> findAllWithContract();

}
