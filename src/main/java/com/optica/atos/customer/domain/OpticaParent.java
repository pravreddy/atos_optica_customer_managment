package com.optica.atos.customer.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class OpticaParent {

    private List<Customer> customers;

}
