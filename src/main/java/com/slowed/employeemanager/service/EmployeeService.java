package com.slowed.employeemanager.service;

import com.slowed.employeemanager.model.EmployeeModel;
import com.slowed.employeemanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

  private final EmployeeRepository employeeRepository;

  @Autowired
  public EmployeeService(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  public EmployeeModel addEmployee(EmployeeModel employee) {
    employee.setEmployeeCode(UUID.randomUUID().toString());
    return employeeRepository.save(employee);
  }

  public List<EmployeeModel> findAllEmployees() {
    return employeeRepository.findAll();
  }

  public EmployeeModel updateEmployee(EmployeeModel employee) {
    return employeeRepository.save(employee);
  }

}
