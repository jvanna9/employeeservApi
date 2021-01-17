package com.paypal.bfs.test.employeeserv;

import com.paypal.bfs.test.employeeserv.impl.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class EmployeeservApplication
        implements CommandLineRunner
{
    public static void main(String[] args) {
        SpringApplication.run(EmployeeservApplication.class, args);
    }

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {


//        Employee e = new Employee();
//        e.setAddressCity("wgl");
//       // e.setId(100);
//        e.setFirstName("Ma");
//        employeeRepository.save(e);
//
//
//        e = new Employee();
//        e.setAddressCity("hnk");
//       // e.setId(200);
//        e.setFirstName("Ma2");
//        employeeRepository.save(e);

    }
}