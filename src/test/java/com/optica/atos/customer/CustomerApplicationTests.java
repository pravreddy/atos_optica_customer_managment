package com.optica.atos.customer;

import com.optica.atos.customer.domain.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void given_operation_when_submits_then_returns_list_of_customers() throws Exception {

        this.mockMvc.perform(get("/api/customers")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.customers[0].Firstname").value("John"));

    }

    @Test
    public void given_customer_when_adds_then_returns_succesfull_message() throws Exception {

        Customer customer = Customer.builder()
                .id(UUID.randomUUID().toString())
                .firstName("Satish")
                .lastName("Yeruva")
                .build();

        ObjectMapper mapper = new ObjectMapper();

        String customerJson = mapper.writeValueAsString(customer);

        this.mockMvc.perform(post("/api/customers")
                .contentType(MediaType.APPLICATION_JSON).content(customerJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customers[0].Surname").value("Yeruva"));

    }

    @Test
    public void given_customer_when_remove_then_remove_frm_customers() throws Exception {

        String id = "A12345";

        this.mockMvc.perform(delete("/api/customers/"+id))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("customers[0].Surname").value("smith"));
    }


}
