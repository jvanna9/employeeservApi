package com.paypal.bfs.test.employeeserv.impl.controller;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.impl.controller.exceptions.EmployeeAlreadyExistsException;
import com.paypal.bfs.test.employeeserv.impl.controller.exceptions.EmployeeDoesNotExistsException;
import com.paypal.bfs.test.employeeserv.impl.repo.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * Implementation class for employee resource.
 */
@RestController
@Slf4j
public class EmployeeResourceImpl implements EmployeeResource {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee employeeGetById(Integer id) {
        Optional<Employee> exists = employeeRepository.findById(id);

        if (exists.isPresent()) {
            return exists.get();
        }
        log.error("This emp id does not exists:: {}", id);

        throw new EmployeeDoesNotExistsException("This emp id does not exists: +" + id);

    }

    /**
     * Creates the {@link Employee} resource.
     *
     * @param emp employee .
     * @return {@link Employee} resource.
     */
    @Override
    public Employee createEmployee(Employee emp) {
        Optional<Employee> exists = employeeRepository.findById(emp.getId());

        if (exists.isPresent()) {
            log.error("This emp id already exists:: {}", emp.getId());
            throw new EmployeeAlreadyExistsException("This emp id already exists: +" + emp.getId());
        }
        return employeeRepository.save(emp);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}
