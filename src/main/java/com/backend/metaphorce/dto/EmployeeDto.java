package com.backend.metaphorce.dto;

import javax.validation.constraints.*;
import java.util.Date;

public class EmployeeDto {

    @Pattern(regexp = "^[A-ZÑ&]{4}\\d{6}[A-V1-9][A-Z1-9][0-9A]$", message = "RFC no valido")
    @NotEmpty(message = "RFC no debe de ser nulo")
    private String taxIdNumber;

    @Size(min = 2, max = 60, message = "Nombre acepta maximo 60 caracteres")
    @NotEmpty(message = "Nombre no debe de ser nulo")
    private String name;

    @Size(min = 5, max = 120, message = "Apellidos acepta maximo 120 caracteres")
    @NotEmpty(message = "Apellidos no deben de ser nulo")
    private String lastName;

    @Past(message = "Fecha de cumpleaños no valida")
    private Date birthDate;

    @Email(message = "Email no valido")
    @NotEmpty(message = "Email no debe de ser nulo")
    private String email;

    @Size(min = 10, max = 20, message = "Telefono no valido")
    @NotEmpty(message = "Numero de telefono celular no debe de ser nulo")
    private String cellPhone;

    private boolean isActive = true;

    private Date dateCreated = new Date();

    public EmployeeDto() { }

    public EmployeeDto(String taxIdNumber, String name, String lastName, Date birthDate, String email, String cellPhone) {
        this.taxIdNumber = taxIdNumber;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.cellPhone = cellPhone;
    }

    public String getTaxIdNumber() {
        return taxIdNumber;
    }

    public void setTaxIdNumber(String taxIdNumber) {
        this.taxIdNumber = taxIdNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
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
}
