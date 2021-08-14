/**
 * UC3 : Introducing DTO and Model to AddressBook App.
 * 			- Note that you can keep the DTO and Model fairly simplistic with only few fields.
 * 			- Use ResponseEntity to return JSON Response.
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
