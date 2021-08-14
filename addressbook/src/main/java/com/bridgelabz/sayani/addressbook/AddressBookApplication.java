/**
 * UC2 : Create a Rest Controller to demonstrate the various HTTP Methods.
 		- Before starting set application.properties to set properties of MySQL Driver and MySQL Credentials.
 		- Use ResponseEntity to return JSON Response.
 		- Test the REST Calls using CURL.
 		- At this stage the interest is to establish the connectivity and ensure data is transmitted in REST Calls.
 		- Make sure to test all CURL Calls – GET, GET by ID, POST, PUT to Update by ID, and DELETE
 *
 * @author : SAYANI KOLEY
 * @since : 14.08.2021
 */

package com.bridgelabz.sayani.addressbook;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;

@SpringBootApplication
@Slf4j
public class AddressBookApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AddressBookApplication.class, args);
		log.info("Address Book Application Started in {} Environment",
				context.getEnvironment().getProperty("environment"));
		log.info("Inside Main Method.");
	}

}
