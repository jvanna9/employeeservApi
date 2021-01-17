package com.paypal.bfs.test.employeeserv.impl.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)

public class EmployeeAlreadyExistsException extends RuntimeException {
    public EmployeeAlreadyExistsException(Object p0) {
    }
}
