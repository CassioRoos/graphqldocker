package com.cassioroos.graphqldocker.DTO;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomersDTO {
    private String firstname;
    private String lastname;
    private String email;
    private String gender;
    private String companyname;
    private String jobtitle;
    private String ssn;
    private String country;
    private String city;
    
    private List<ContactsDTO> contacts = new ArrayList<>();
}
