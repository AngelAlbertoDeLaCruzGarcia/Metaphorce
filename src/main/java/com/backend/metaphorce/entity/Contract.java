package com.backend.metaphorce.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "contracts")
public class Contract implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Long contractId;

    @Column(name = "date_from", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFrom;

    @Column(name = "date_to", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTo;

    @Column(name = "salary_per_day", nullable = false, columnDefinition = "DECIMAL")
    private double salaryPerDay;

    @Column(name = "is_active", nullable = false)
    private boolean isActive = false;

    @Column(name = "date_created", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "employees_id", referencedColumnName = "employee_id")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Employee employee;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_types_id", referencedColumnName = "contract_type_id")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private ContractType contractType;

    public Contract() { }

    public Contract(Date dateFrom, Date dateTo, double salaryPerDay, boolean isActive, Date dateCreated
                    ) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.salaryPerDay = salaryPerDay;
        this.isActive = isActive;
        this.dateCreated = dateCreated;
//        this.employee = employee;
//        this.contractType = contractType;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    public ContractType getContractType() {
        return contractType;
    }

    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }

    private static final long serialVersionUID = 1L;
}
