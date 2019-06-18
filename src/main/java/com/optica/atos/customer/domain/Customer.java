package com.optica.atos.customer.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
public class Customer {

    @JsonProperty("Id")
    private String id;

    @JsonProperty("Firstname")
    private String firstName;

    @JsonProperty("Surname")
    private String lastName;

}
