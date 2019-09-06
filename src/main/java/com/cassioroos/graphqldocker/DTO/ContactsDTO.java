package com.cassioroos.graphqldocker.DTO;

import java.io.Serializable;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContactsDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	@GraphQLQuery(name = "name", description = "A customer's contact name")
	private String name;
	@GraphQLQuery(name = "phone", description = "A customer's contact phone")
	private String phone;
	@GraphQLQuery(name = "email", description = "A customer's contact email")
	private String email;
	@GraphQLQuery(name = "country", description = "A customer's contact country")
	private String country;
	@GraphQLQuery(name = "city", description = "A customer's contact city")
	private String city;

}
