package com.paypal.bfs.test.employeeserv.impl.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class EmployeeDoesNotExistsException extends RuntimeException {
    public EmployeeDoesNotExistsException(String s) {
    }
}
