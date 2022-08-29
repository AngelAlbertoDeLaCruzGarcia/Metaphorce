package com.backend.metaphorce.service;

import com.backend.metaphorce.entity.Contract;
import com.backend.metaphorce.entity.Employee;
import com.backend.metaphorce.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Transactional(readOnly = true)
    public List<Employee> list() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Transactional
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Transactional(readOnly = true)
    public Optional<Employee> getOneById(int id) {
        return employeeRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Employee> getOneByTaxId(String taxId) {
        return employeeRepository.findByTaxIdNumber(taxId);
    }

    @Transactional(readOnly = true)
    public boolean existsByTaxId(String taxId) {
        return employeeRepository.existsByTaxIdNumber(taxId);
    }

    @Transactional(readOnly = true)
    public boolean existsById(int id) {
        return employeeRepository.existsById(id);
    }

}
