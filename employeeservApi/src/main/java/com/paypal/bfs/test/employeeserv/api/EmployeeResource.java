package com.paypal.bfs.test.employeeserv.api;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Interface for employee resource operations.
 */

@RequestMapping(value = "/v1/bfs/employees")
public interface EmployeeResource {

    /**
     * Retrieves the {@link Employee} resource by id.
     *
     * @param id employee id.
     * @return {@link Employee} resource.
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    Employee employeeGetById(@PathVariable("id") Integer id);


    /**
     * Creates the {@link Employee} resource.
     *
     * @param emp employee .
     * @return {@link Employee} resource.
     */

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Employee createEmployee(@RequestBody Employee emp);

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    List<Employee> getAll();

}
