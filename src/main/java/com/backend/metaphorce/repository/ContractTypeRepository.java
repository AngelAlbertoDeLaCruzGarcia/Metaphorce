package com.backend.metaphorce.repository;

import com.backend.metaphorce.entity.Contract;
import com.backend.metaphorce.entity.ContractType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContractTypeRepository extends CrudRepository<ContractType, Integer> {

    @Query(value = "SELECT * FROM contract_types WHERE contract_type_id = :id", nativeQuery = true)
    List<ContractType> listByContract(int id);

}
