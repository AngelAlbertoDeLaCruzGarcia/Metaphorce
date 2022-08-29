package com.backend.metaphorce.service;

import com.backend.metaphorce.entity.ContractType;
import com.backend.metaphorce.repository.ContractTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ContractTypeService {

    @Autowired
    ContractTypeRepository contractTypeRepository;

    @Transactional(readOnly = true)
    public Optional<ContractType> getOneById(int id) {
        return contractTypeRepository.findById(id);
    }

}
