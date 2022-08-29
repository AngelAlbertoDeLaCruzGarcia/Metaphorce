package com.backend.metaphorce.controller;

import com.backend.metaphorce.dto.ContractDto;
import com.backend.metaphorce.dto.EmployeeDto;
import com.backend.metaphorce.entity.Contract;
import com.backend.metaphorce.entity.ContractType;
import com.backend.metaphorce.entity.Employee;
import com.backend.metaphorce.exception.Response;
import com.backend.metaphorce.exception.Response2;
import com.backend.metaphorce.service.ContractService;
import com.backend.metaphorce.service.ContractTypeService;
import com.backend.metaphorce.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/contract")
@CrossOrigin(origins = "")
public class ContractController {

    @Autowired
    EmployeeService employeeService;
    ContractService contractService;
    ContractTypeService contractTypeService;
    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody ContractDto contractDto, Errors errors){
        try {
            String msgError = "";
            if(errors.hasErrors()) {
                for (ObjectError error : errors.getAllErrors()) {
                    msgError += error.getDefaultMessage() + ", " ;
                }
                return new ResponseEntity(new Response(msgError, -1), HttpStatus.BAD_REQUEST);
            }

            Employee employee = employeeService.getOneById(contractDto.getEmployee()).get();
//            ContractType contractType = contractTypeService.getOneById(contractDto.getContractType()).get();
//            Contract contractNew = new Contract(contractDto.getDateFrom(), contractDto.getDateTo(), contractDto.getSalaryPerDay(),
//                    contractDto.isActive(), contractDto.getDateCreated());
//            contractService.save(contractNew);
/*
                Contract contract = contractService.getOneByEmployee(contractDto.getEmployee()).get();
                contract.setDateTo(new Date());
                contractService.save(contract);
                ContractType contractType = contractTypeService.getOneById(contractDto.getContractType()).get();

                Contract contractExtension = new Contract(contractDto.getDateFrom(), contractDto.getDateTo(), contractDto.getSalaryPerDay(),
                        contractDto.isActive(), contractDto.getDateCreated(), employee, contractType);
                contractService.save(contractExtension);

*/
                return new ResponseEntity(new Response("Contrato creado", 201), HttpStatus.CREATED);
//            }else {
//                ContractType contractType = contractTypeService.getOneById(contractDto.getContractType()).get();
//                Contract contractNew = new Contract(contractDto.getDateFrom(), contractDto.getDateTo(), contractDto.getSalaryPerDay(),
//                        contractDto.isActive(), contractDto.getDateCreated(), employee, contractType);
//                contractService.save(contractNew);

//                return new ResponseEntity(new Response("Contrato extendido", 201), HttpStatus.CREATED);
//            }
//            return new ResponseEntity(new Response("Contrato extendido", 201), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(new Response(e.toString(), 400), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        if (!contractService.existsById(id)) {
            return new ResponseEntity(new Response("No existe", 404), HttpStatus.NOT_FOUND);
        } else {
            Contract contract = contractService.getOneById(id).get();
            contract.setDateTo(new Date());
            contractService.save(contract);
            return new ResponseEntity(new Response("Eliminado", 200), HttpStatus.OK);
        }
    }

}