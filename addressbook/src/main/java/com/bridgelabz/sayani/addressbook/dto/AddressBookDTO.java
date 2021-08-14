package com.bridgelabz.sayani.addressbook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressBookDTO {
    private int id;

    @NotEmpty(message = "Person Name cannot be null")
    @Pattern(regexp = "^[A-Z][a-zA-z\\s]{2,}$", message = "Person Name Invalid")
    private String name;

    @NotEmpty(message = "Address cannot be null")
    @Pattern(regexp = "^[A-Z][a-zA-z0-9\\s]+$", message = "Person Address Invalid")
    private String address;

    @NotEmpty(message = "City cannot be null")
    @Pattern(regexp = "^[A-Z][a-zA-z\\s]+$", message = "Person City Invalid")
    private String city;

    @NotEmpty(message = "State cannot be null")
    @Pattern(regexp = "^[A-Z][a-zA-z\\s]+$", message = "Person State Invalid")
    private String state;

    @NotEmpty(message = "PhoneNo cannot be null")
    @Pattern(regexp = "^[0-9]{10}$", message = "Person PhoneNo Invalid")
    private String phoneNo;

    @NotEmpty(message = "Zip cannot be null")
    @Pattern(regexp = "^[0-9]{6}$", message = "Person Zip Invalid")
    private String zip;
}
