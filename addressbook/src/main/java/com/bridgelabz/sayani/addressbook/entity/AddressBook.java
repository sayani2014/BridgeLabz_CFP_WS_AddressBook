package com.bridgelabz.sayani.addressbook.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String address;
    private String city;
    private String state;
    private String phoneNo;
    private String zip;
    private LocalDate createdDate;
    private LocalDate updatedDate;

    public AddressBook() {
        this.createdDate = LocalDate.now();
        this.updatedDate = LocalDate.now();
    }
}
