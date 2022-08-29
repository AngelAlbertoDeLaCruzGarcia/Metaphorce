package com.backend.metaphorce.controller;

import com.backend.metaphorce.dto.EmployeeDto;
import com.backend.metaphorce.entity.Contract;
import com.backend.metaphorce.entity.Employee;
import com.backend.metaphorce.exception.Response;
import com.backend.metaphorce.exception.Response2;
import com.backend.metaphorce.service.ContractService;
import com.backend.metaphorce.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin(origins = "")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping("")
    public ResponseEntity<?> get() {
        try {
            List<Employee> employeeList = employeeService.list();
            if( employeeList.isEmpty()){
                return new ResponseEntity(new Response("No hay registros", 200), HttpStatus.OK);
            }else {
                return new ResponseEntity(new Response2("Exito", 200, employeeList), HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity(e, HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody EmployeeDto employeeDto, Errors errors){
        try {
            String msgError = "";
            if(errors.hasErrors()) {
                for (ObjectError error : errors.getAllErrors()) {
                    msgError += error.getDefaultMessage() + ", " ;
                }
                return new ResponseEntity(new Response(msgError, -1), HttpStatus.BAD_REQUEST);
            }
            if(employeeService.existsByTaxId(employeeDto.getTaxIdNumber())){
                return new ResponseEntity(new Response("RFC ya registrado, inicie sesion", -1), HttpStatus.BAD_REQUEST);
            }
            Employee employee = new Employee(employeeDto.getTaxIdNumber(), employeeDto.getName(), employeeDto.getLastName(),
                employeeDto.getBirthDate(), employeeDto.getEmail(), employeeDto.getCellPhone(), employeeDto.isActive(),
                employeeDto.getDateCreated());
            employeeService.save(employee);
            return new ResponseEntity(new Response("Empleado creado", 201), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(new Response(e.toString(), 400), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/{taxId}")
    public ResponseEntity<?> update(@Valid @RequestBody EmployeeDto employeeDto, @PathVariable String taxId, Errors errors){
        try {
            String msgError = "";
            if(errors.hasErrors()) {
                for (ObjectError error : errors.getAllErrors()) {
                    msgError += error.getDefaultMessage() + ", " ;
                }
                return new ResponseEntity(new Response(msgError, -1), HttpStatus.BAD_REQUEST);
            }
            if(employeeService.existsByTaxId(employeeDto.getTaxIdNumber())){
                return new ResponseEntity(new Response("RFC ya registrado", -1), HttpStatus.BAD_REQUEST);
            }
            Employee employee = employeeService.getOneByTaxId(taxId).get();
            employee.setTaxIdNumber(employeeDto.getTaxIdNumber());
            employee.setName(employeeDto.getName());
            employee.setLastName(employeeDto.getLastName());
            employee.setBirthDate(employeeDto.getBirthDate());
            employee.setEmail(employeeDto.getEmail());
            employee.setCellPhone(employeeDto.getCellPhone());
            employee.setActive(employeeDto.isActive());
            employee.setDateCreated(employeeDto.getDateCreated());
            employeeService.save(employee);
            return new ResponseEntity(new Response("Empleado actualizado", 200), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(new Response(e.toString(), 400), HttpStatus.BAD_REQUEST);
        }
    }

}
