package com.backend.metaphorce.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

public class ContractDto {

//    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Mexico_City")
    private Date dateFrom;

//    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Mexico_City")
    private Date dateTo;

    @Positive(message = "Salario debe ser positivo")
    private double salaryPerDay;

    private boolean isActive = true;

    private Date dateCreated = new Date();

    private int employee;

    private int contractType;

    public ContractDto() { }

    public ContractDto( double salaryPerDay, int employee, int contractType, Date dateFrom, Date dateTo) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.salaryPerDay = salaryPerDay;
        this.employee = employee;
        this.contractType = contractType;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public double getSalaryPerDay() {
        return salaryPerDay;
    }

    public void setSalaryPerDay(double salaryPerDay) {
        this.salaryPerDay = salaryPerDay;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getEmployee() {
        return employee;
    }


    public void setEmployee(int employee) {
        this.employee = employee;
    }

    public int getContractType() {
        return contractType;
    }

    public void setContractType(int contractType) {
        this.contractType = contractType;
    }
}
