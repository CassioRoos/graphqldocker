package com.cassioroos.graphqldocker.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.cassioroos.graphqldocker.DTO.ContactsDTO;
import com.cassioroos.graphqldocker.DTO.CustomersDTO;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
public class Customers implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GraphQLQuery(name = "id", description = "A customer's id")
    private String id;
    @GraphQLQuery(name = "firstname", description = "A customer's name")
    private String firstname;
    @GraphQLQuery(name = "lastname", description = "A customer's last name")
    private String lastname;
    @GraphQLQuery(name = "email", description = "A customer's last email")
    private String email;
    @GraphQLQuery(name = "gender", description = "A customer's last gender")
    private String gender;
    @GraphQLQuery(name = "companyname", description = "A customer's last companyname")
    private String companyname;
    @GraphQLQuery(name = "jobtitle", description = "A customer's last jobtitle")
    private String jobtitle;
    @GraphQLQuery(name = "ssn", description = "A customer's last ssn")
    private String ssn;
    @GraphQLQuery(name = "country", description = "A customer's last country")
    private String country;
    @GraphQLQuery(name = "city", description = "A customer's last city")
    private String city;
    @GraphQLQuery(name = "contacts", description = "A customer's last contacts")
    private List<ContactsDTO> contacts = new ArrayList<>();
    
    public Customers(String id, String firstname, String lastname, String email, String gender, String companyname,
			String jobtitle, String ssn, String country, String city) {
		super();
		
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.gender = gender;
		this.companyname = companyname;
		this.jobtitle = jobtitle;
		this.ssn = ssn;
		this.country = country;
		this.city = city;
	}
    
    public Customers(CustomersDTO obj) {
    	id = null;
    	firstname = obj.getFirstname();
    	lastname = obj.getLastname();
    	email = obj.getEmail();
    	gender = obj.getGender();
    	companyname = obj.getCompanyname();
    	jobtitle = obj.getJobtitle();
    	ssn = obj.getSsn();
    	country = obj.getCountry();
    	city = obj.getCity();
    	contacts = obj.getContacts();
    }
}
