package com.cassioroos.graphqldocker.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cassioroos.graphqldocker.DTO.CustomersDTO;
import com.cassioroos.graphqldocker.Service.CustomersService;
import com.cassioroos.graphqldocker.domain.Customers;

@RestController
@RequestMapping(value = "/customers")
public class CustomersResource {

	@Autowired
	private CustomersService customersService;

	@GetMapping
	public ResponseEntity<List<Customers>> findAll() {
		return ResponseEntity.ok().body(customersService.findAll());
	}

	@GetMapping(value = "/{cod}")
	public ResponseEntity<Customers> findById(@PathVariable String cod) {
		return ResponseEntity.ok().body(customersService.findById(cod));
	}
	
	@PostMapping
	public ResponseEntity<Void> insertMany(@RequestBody List<CustomersDTO> objs){
		customersService.insertMany(objs);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		return ResponseEntity.created(uri).build();
	}
}
