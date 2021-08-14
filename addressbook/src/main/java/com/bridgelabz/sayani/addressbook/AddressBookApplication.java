/**
 * UC4 : Introducing Services Layer in AddressBook App.
 * 			- This is the job of services layer to manage the Model.
 * 			- Autowired Annotation will be used to do Dependency Injection of the Services Object to the Controller.
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
