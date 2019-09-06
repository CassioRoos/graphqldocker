package com.cassioroos.graphqldocker.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cassioroos.graphqldocker.DTO.CustomersDTO;
import com.cassioroos.graphqldocker.Service.Exceptions.ObjectNotFoundException;
import com.cassioroos.graphqldocker.domain.Customers;
import com.cassioroos.graphqldocker.repository.CustomersRepository;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;

@Service
@GraphQLApi
public class CustomersService {

	@Autowired
	private CustomersRepository customersRepository;

	@GraphQLQuery(name = "customers")
	public List<Customers> findAll() {
		return customersRepository.findAll();
	}

	@GraphQLQuery(name = "customer")
	public Customers findById(@GraphQLArgument(name = "id") String id) {
		return customersRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Customer not found! Id " + id));
	}

	public void insertMany(List<CustomersDTO> objs) {
		List<Customers> customersList = objs.stream().map(Customers::new).collect(Collectors.toList());
		customersRepository.saveAll(customersList);
	}
}
