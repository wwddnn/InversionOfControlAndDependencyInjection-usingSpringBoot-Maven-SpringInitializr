package com.devsuperior.aula.services;

import com.devsuperior.aula.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryService {

    @Autowired
    private TaxService taxService;

    @Autowired
    private PensionService pensionService;

    /*
    o spring aceita a injecao de dependencia por meio de @Autowired, conforme acima. mas o spring tambem aceita a injecao de dependencia por meio de construtor conforme demostrado abaixo
    private TaxService taxService;
    private PensionService pensionService;
    public SalaryService(TaxService taxService, PensionService pensionService) {
        this.taxService = taxService;
        this.pensionService = pensionService;
    }
     */

    public double netSalary(Employee employee) {
        return employee.getGrossSalary() - taxService.tax(employee.getGrossSalary()) - pensionService.discount(employee.getGrossSalary());
    }
}
