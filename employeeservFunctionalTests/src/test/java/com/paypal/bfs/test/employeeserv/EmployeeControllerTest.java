package com.paypal.bfs.test.employeeserv;



import com.paypal.bfs.test.employeeserv.api.model.Employee;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
 import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)

@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
        //(classes={EmployeeservApplication.class})
public class EmployeeControllerTest {


    @Autowired
    private MockMvc mockMvc;

    /**
     * @throws Exception It tests creating a employee
     */
    @Test
    public void createEmployees() throws Exception {

        String json = "{\"id\": 1, \"first_name\": \"Dr James\", \"last_name\": \"Elton\", \"date_of_birth\": \"1957-11-11\", " +
                "\"address_line1\": \"100 John Lane\", " +
                "\"address_line2\": \"Universal Office\", " +
                "\"address_city\": \"Dallas\", " +
                "\"address_state\": \"TX\", " +
                "\"address_country\": \"USA\", " +
                "\"address_zip_code\": \"34578\" " +

                "}";

        mockMvc.perform(
                post("/v1/bfs/employees")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        json = "{\"id\": 2, \"first_name\": \"Dr Lebran\", \"last_name\": \"Curie\", \"date_of_birth\": \"1957-11-11\", " +
                "\"address_line1\": \"101 John Lane\", " +
                "\"address_line2\": \"Universal Office\", " +
                "\"address_city\": \"Dallas\", " +
                "\"address_state\": \"TX\", " +
                "\"address_country\": \"USA\", " +
                "\"address_zip_code\": \"34578\" " +

                "}";
        mockMvc.perform(
                post("/v1/bfs/employees")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());


        json = "{\"id\": 3, \"first_name\": \"Ellis\", \"last_name\": \"Stark\", \"date_of_birth\": \"1988-11-11\", " +
                "\"address_line1\": \"106 Test Lane\", " +
                "\"address_line2\": \"Universal Office\", " +
                "\"address_city\": \"Dallas\", " +
                "\"address_state\": \"TX\", " +
                "\"address_country\": \"USA\", " +
                "\"address_zip_code\": \"34578\" " +

                "}";
        mockMvc.perform(
                post("/v1/bfs/employees")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

    }

    /**
     * @throws Exception It tests creating a employee
     */
    @Test
    public void createWithExistingId() throws Exception {

        String json = "{\"id\": 1, \"first_name\": \"Dr James\", \"last_name\": \"Elton\", \"date_of_birth\": \"1957-11-11\", " +
                "}";
        mockMvc.perform(
                post("/v1/bfs/employees")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isBadRequest());
    }


    /**
     * @throws Exception It tests finding a employee
     */
    @Test
    public void findById1() throws Exception {

        String res = "{\"id\":1,\"first_name\":\"Dr James\",\"last_name\":\"Elton\",\"date_of_birth\":\"1957-11-11\",\"address_line1\":\"100 John Lane\",\"address_line2\":\"Universal Office\",\"address_city\":\"Dallas\",\"address_state\":\"TX\",\"address_country\":\"USA\",\"address_zip_code\":34578}";

        assertEquals(" Compare json   failed",

                mockMvc.perform(get("/v1/bfs/employees/1"))
                        .andExpect(status().isOk())
                        .andReturn()
                        .getResponse()
                        .getContentAsString(),
                res
        );
    }


    @Test
    public void findById2() throws Exception {

        String    res = "{\"id\":2,\"first_name\":\"Dr Lebran\",\"last_name\":\"Curie\",\"date_of_birth\":\"1957-11-11\",\"address_line1\":\"101 John Lane\",\"address_line2\":\"Universal Office\",\"address_city\":\"Dallas\",\"address_state\":\"TX\",\"address_country\":\"USA\",\"address_zip_code\":34578}";
        assertEquals(" Compare json   failed",

                mockMvc.perform(get("/v1/bfs/employees/2"))
                        .andExpect(status().isOk())
                        .andReturn()
                        .getResponse()
                        .getContentAsString(),
                res
        );
    }

    /**
     * @throws Exception It tests finding a employee
     */
    @Test
    public void findEmployeeByNonExistingId() throws Exception {

        mockMvc.perform(get("/v1/bfs/employees/100"))
                .andExpect(status().isNotFound());
    }

    /**
     * @throws Exception It tests finding all employees
     */
    @Test
    public void findAll() throws Exception {

        String res = "[{\"id\":1,\"first_name\":\"Dr James\",\"last_name\":\"Elton\",\"date_of_birth\":\"1957-11-11\",\"address_line1\":\"100 John Lane\",\"address_line2\":\"Universal Office\",\"address_city\":\"Dallas\",\"address_state\":\"TX\",\"address_country\":\"USA\",\"address_zip_code\":34578},{\"id\":2,\"first_name\":\"Dr Lebran\",\"last_name\":\"Curie\",\"date_of_birth\":\"1957-11-11\",\"address_line1\":\"101 John Lane\",\"address_line2\":\"Universal Office\",\"address_city\":\"Dallas\",\"address_state\":\"TX\",\"address_country\":\"USA\",\"address_zip_code\":34578},{\"id\":3,\"first_name\":\"Ellis\",\"last_name\":\"Stark\",\"date_of_birth\":\"1988-11-11\",\"address_line1\":\"106 Test Lane\",\"address_line2\":\"Universal Office\",\"address_city\":\"Dallas\",\"address_state\":\"TX\",\"address_country\":\"USA\",\"address_zip_code\":34578}]";

        assertEquals(" Compare json arrays failed",

                mockMvc.perform(get("/v1/bfs/employees"))
                        .andExpect(status().isOk())
                        .andReturn()
                        .getResponse()
                        .getContentAsString(),
                res

        );
    }

}
