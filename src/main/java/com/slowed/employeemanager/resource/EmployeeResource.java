package com.slowed.employeemanager.resource;

import com.slowed.employeemanager.model.EmployeeModel;
import com.slowed.employeemanager.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {

  private final EmployeeService employeeService;

  public EmployeeResource(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping("/all")
  public ResponseEntity<List<EmployeeModel>> getAllEmployees () {
    List<EmployeeModel> employees = employeeService.findAllEmployees();
    return new ResponseEntity<>(employees, HttpStatus.OK);
  }

  @GetMapping("/find/{id}")
  public ResponseEntity<EmployeeModel> getEmployeeById (@PathVariable("id") Long id) {
    EmployeeModel employee = employeeService.findEmployeeById(id);
    return new ResponseEntity<>(employee, HttpStatus.OK);
  }

  @PostMapping("add")
  public ResponseEntity<EmployeeModel> addEmployee(@RequestBody EmployeeModel employee) {
    EmployeeModel newEmployee = employeeService.addEmployee(employee);
    return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
  }

}
