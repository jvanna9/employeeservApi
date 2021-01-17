# employeeserv
Assignment submission by Janardhan Vanna


## Application Overview
employeeserv is a spring boot rest application which would provide the CRUD operations for `Employee` resource.


## How to test the application
- Unzip the file
- use command mvn install  -Dmaven.test.skip=true
- Use command `mvn clean test` to build and run integrations tests.
- Use command `mvn spring-boot:run` from `employeeservImplementation` folder to start tomcat server.
- Use postman to post employee using json body ..... at `http://localhost:8080/v1/bfs/employees`
- Use Json of this format to insert:
  {
  "id" : int,
  "first_name" : string,
  "last_name" : string,
  "date_of_birth" : string[yyyy-MM-dd],
  "address_line1" : string,
  "address_line2" : string,
  "address_city"  : string,
  "address_state" : string,
  "address_country" : string,
  "address_zip_code" : int
  }
- Use postman or curl to access all employees  `http://localhost:8080/v1/bfs/employees` GET endpoint. It will return an Employee resource.


## Assignment submission

- Added Address elements
- Implemented POST and GET operations
- Added 6 Integrations tests
- Uses H2 DB
- Error handling done with various HTTP response codes
