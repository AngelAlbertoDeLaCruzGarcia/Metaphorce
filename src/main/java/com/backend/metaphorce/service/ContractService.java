package com.backend.metaphorce.service;

import com.backend.metaphorce.entity.Contract;
import com.backend.metaphorce.entity.ContractType;
import com.backend.metaphorce.entity.Employee;
import com.backend.metaphorce.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ContractService {

    @Autowired
    ContractRepository contractRepository;

    @Transactional
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Transactional(readOnly = true)
    public Optional<Contract> getOneByEmployee(int id) {
        return contractRepository.findByEmployee(id);
    }

    @Transactional(readOnly = true)
    public Optional<Contract> getOneById(long id) {
        return contractRepository.findById(id);
    }

    public List<Contract> existByEmployee(int id){
        return (List<Contract>)contractRepository.existsByEmployee(id);
    }

    @Transactional(readOnly = true)
    public List<Contract> list() {
        return (List<Contract>) contractRepository.findAll();
    }

    @Transactional(readOnly = true)
    public boolean existsById(long id) {
        return contractRepository.existsById(id);
    }
}
