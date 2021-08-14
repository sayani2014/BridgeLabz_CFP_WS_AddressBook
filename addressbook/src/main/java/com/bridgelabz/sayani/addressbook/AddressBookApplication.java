/**
 * UC5 : Ability for the Services Layer to store the AddressBook Data.
 * 			- In this use case the Services Layer will store this	Data in a Memory as a List.
 * 			- As we go further down we will persist this data in DB.
 * 			- Make sure to test all CURL Calls – GET, GET by ID, POST, PUT to Update by ID, and DELETE.
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
