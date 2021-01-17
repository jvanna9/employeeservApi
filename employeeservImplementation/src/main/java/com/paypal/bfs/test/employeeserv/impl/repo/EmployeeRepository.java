package com.paypal.bfs.test.employeeserv.impl.repo;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
