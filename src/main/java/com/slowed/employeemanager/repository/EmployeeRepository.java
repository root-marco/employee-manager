package com.slowed.employeemanager.repository;

import com.slowed.employeemanager.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {

  void deleteEmployeeById(Long id);

}
